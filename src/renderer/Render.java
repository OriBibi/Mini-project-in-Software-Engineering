package renderer;
import elements.Light;
import primitives.Vector;
import scene.*;
import primitives.*;
import geometries.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;


public class Render  {

    private Scene scene;
    private ImageWriter imageWriter;

    // ************* Constructors ******************* //
    public Render(Scene scene, ImageWriter imageWriter) {
        this.scene = scene;
        this.imageWriter = imageWriter;
    }
    public Render(Render render) {
        this.scene=render.scene;
        this.imageWriter=render.imageWriter;
    }

    // ************* Getters/Setters ****************** //
    public Scene getScene() {
        return scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public ImageWriter getImageWriter() {
        return imageWriter;
    }
    public void setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
    }
    private static class GeoPoint {
        public Geometry geometry;
        public Point3D point;
    }
    public void printGrid(int interval){
        int height = imageWriter.getHeight();
        int width = imageWriter.getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i % interval == 0 || j % interval == 0)
                    imageWriter.writePixel(j, i, Color.WHITE);

            }
        }
    }
    public void renderImage(){
        for (int i = 0; i < imageWriter.getHeight(); i++) {
            for (int j = 0; j < imageWriter.getWidth(); j++) {

                Ray ray = scene.getCamera().constructRayThroughPixel(
                        imageWriter.getNx(), imageWriter.getNy(), j, i,
                        scene.getScreenDistance(),
                        imageWriter.getWidth(), imageWriter.getHeight());
                Map<Geometry,List<Point3D>> intersections = getSceneRayIntersections(ray);//A function that collects all the points of intersection of the beam with the shapes.

                if(intersections.isEmpty()) {//If intersection == null inserts the background color.
                    imageWriter.writePixel(j, i, scene.getBackGround());
                }
                else {//If there are any cut points then you will return the nearest crop point.
                    Entry<Geometry,Point3D> entry=getClosestPoint(intersections).entrySet().iterator().next();
                    Color color=calcColor(entry.getValue(),entry.getKey(),ray,0);

                    Color tempcolor=Color.black;
                    ray.setStartPoint(ray.getStartPoint().addVector(new Vector(0,2,0)));
                    intersections = getSceneRayIntersections(ray);
                    if(!intersections.isEmpty()) {
                        entry = getClosestPoint(intersections).entrySet().iterator().next();
                        tempcolor=calcColor(entry.getValue(),entry.getKey(),ray,0);
                    }
                    color=mixColors(color,tempcolor);

                    tempcolor=Color.black;
                    ray.setStartPoint(ray.getStartPoint().addVector(new Vector(0,-4,0)));
                    intersections = getSceneRayIntersections(ray);
                    if(!intersections.isEmpty()) {
                        entry = getClosestPoint(intersections).entrySet().iterator().next();
                        tempcolor=calcColor(entry.getValue(),entry.getKey(),ray,0);
                    }
                    color=mixColors(color,tempcolor);

                    tempcolor=Color.black;
                    ray.setStartPoint(ray.getStartPoint().addVector(new Vector(2,2,0)));
                    intersections = getSceneRayIntersections(ray);
                    if(!intersections.isEmpty()) {
                        entry = getClosestPoint(intersections).entrySet().iterator().next();
                        tempcolor=calcColor(entry.getValue(),entry.getKey(),ray,0);
                    }
                    color=mixColors(color,tempcolor);

                    tempcolor=Color.black;
                    ray.setStartPoint(ray.getStartPoint().addVector(new Vector(-4,0,0)));
                    intersections = getSceneRayIntersections(ray);
                    if(!intersections.isEmpty()) {
                        entry = getClosestPoint(intersections).entrySet().iterator().next();
                        tempcolor=calcColor(entry.getValue(),entry.getKey(),ray,0);
                    }
                    color=mixColors(color,tempcolor);

                    imageWriter.writePixel(j, i, color);//Request from imageWriter to write a certain color to the current pixel.
                }
            }
        }
    }//A function that builds a ray for each pixel and checks for Intersection points with shapes in the scene.
   private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints){

       double distance = Double.MAX_VALUE;
       Point3D P0 = new Point3D(scene.getCamera().getp0());
       Point3D minDistancPoint = null;
       Geometry minDistancGeometry = null;

       for(Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()){
           for (Point3D point: entry.getValue())
               if(Point3D.distance(point, P0) < distance){
                   minDistancPoint = new Point3D(point);
                   minDistancGeometry = entry.getKey();
                   distance = Point3D.distance(point, P0);
               }
       }

       Map<Geometry,Point3D> minDistancMap=new HashMap<>();
       minDistancMap.put(minDistancGeometry,minDistancPoint);
       return minDistancMap;
   }
    public Color addColors(Color c1,Color c2){
        int red=Math.max(0,Math.min(255,c1.getRed()+c2.getRed()));
        int green=Math.max(0,Math.min(255,c1.getGreen() + c2.getGreen()));
        int blue=Math.max(0,Math.min(255, c1.getBlue()+ c2.getBlue()));
        return new Color (red, green, blue);
    }
    private Color scaleColor(Color color,double scaling){
        int red=(int)Math.max(0,Math.min(255,color.getRed()*scaling));
        int green=(int)Math.max(0,Math.min(255,color.getGreen() *scaling));
        int blue=(int)Math.max(0,Math.min(255, color.getBlue()*scaling));
        return new Color (red, green, blue);
    }
    private Color mixColors(Color color1,Color color2){
        return addColors(scaleColor(color1,0.5),scaleColor(color2,0.5));
    }
    private boolean occluded(Light light, Point3D point, Geometry geometry)  {
        Vector lightDirection = light.getL(point);
        lightDirection.scale(-1);

        Point3D geometryPoint = new Point3D(point);

        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.scale(2);
        geometryPoint=geometryPoint.addVector(epsVector);

        Ray lightRay = new Ray( lightDirection,geometryPoint);
        Map <Geometry,List<Point3D>> intersectionPoint = getSceneRayIntersections(lightRay);

        if (geometry instanceof FlatGeometry){
            intersectionPoint.remove(geometry);
        }
        for (Entry<Geometry, List<Point3D>> entry: intersectionPoint.entrySet())//Adding a condition to the shadow: If the geometry is sealed (KT == 0) - there is a shadow, if it is a bit transparent - no shadow.
            if (entry.getKey().getMaterial().getKt() == 0)
                return true;
        return false;

    }
    public Color calcColor(Point3D point,Geometry geometry, Ray inRay,int level) {
        int RECURSION_LEVEL = 3;
        if (level == RECURSION_LEVEL){
            return new Color(0, 0, 0);
        }
        Color ambientLight = this.scene.getAmbientLight().getIntensity(point);
        Color emissionLight = geometry.getEmmission();
        Color I0 = addColors(ambientLight,emissionLight);
        Iterator<Light> lights = scene.getLightsIterator();
        while (lights.hasNext()) {
            Light light = lights.next();
            if (!occluded(light, point, geometry)) {

                I0 = addColors(I0,
                        calcDiffuseComp(geometry.getMaterial().getKd(),
                                geometry.getNormal(point),
                                light.getL(point),
                                light.getIntensity(point)));

                I0 = addColors(I0,
                        calcSpecularComp(geometry.getMaterial().getKs(),
                                new Vector(point, scene.getCamera().getp0()),
                                geometry.getNormal(point),
                                light.getL(point),
                                geometry.getMaterial().getnShininess(),
                                light.getIntensity(point)));
            }
        }
            // Recursive call for a reflected ray
             Vector vector=geometry.getNormal(point);
            Ray reflectedRay = constructReflectedRay(vector, point, inRay);
            Entry<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
            Color reflected = new Color(0, 0, 0);
            if (reflectedEntry != null){
                reflected = calcColor( reflectedEntry.getValue(),reflectedEntry.getKey(), reflectedRay, level + 1);
                double kr = geometry.getMaterial().getKr();
                reflected = scaleColor(reflected,kr);

            }

            // Recursive call for a refracted ray
            Ray refractedRay = constructRefractedRay(geometry, point, inRay);
            Entry<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
            Color refracted = new Color(0, 0, 0);
            if (refractedEntry != null){
                refracted = calcColor(refractedEntry.getValue(),refractedEntry.getKey(), refractedRay, level + 1);
                double kt = geometry.getMaterial().getKt();
                refracted = scaleColor(refracted,kt);

            }
        I0= addColors(I0,reflected);
        I0= addColors(I0,refracted);
        return I0;


    }//Calculate the final color while considering the different light types that affect the shape. Using a Phong model
    private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray) {

        Iterator<Geometry> geometries = scene.getGeometriesIterator();
        HashMap<Geometry,List<Point3D>> intersectionPoints=new HashMap<>();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
            if (geometryIntersectionPoints.isEmpty())
                continue;
            intersectionPoints.put(geometry,geometryIntersectionPoints);
        }
        return intersectionPoints;

    }
    private Color calcDiffuseComp(double kd, Vector normal, Vector vecL, Color intensity)   {

        vecL.normalize();
        normal.normalize();
        /*The more the angle formed between the normal of the shape
         and direction vector of the light will be the bigger the
         amount of light will decreasing*/
        Double diffuse= -1*kd*normal.dotProduct(vecL);
        if(diffuse<0){
            diffuse=0.0;
        }
        return scaleColor(intensity,diffuse);

    }//Light that comes to geometry and creates the effect of light that distributes light to its environment.
    private Color calcSpecularComp(double ks,Vector vector,Vector normal,Vector vecL, int shininess,Color intensity){
        normal.normalize();
        vecL.normalize();
        vector.normalize();
        Vector tempvector=new Vector(normal);
        tempvector.scale(vecL.dotProduct(normal)*2);//The more the angle of the viewer \ camera will be the smaller the specular affects more.
        Vector R= vecL.subtractVector(tempvector);
        R.normalize();
        double colorscale=0;
        if(vector.dotProduct(R)>0){
            colorscale=ks*Math.pow(vector.dotProduct(R),shininess);
        }
        return scaleColor(intensity,colorscale);
    }//Light created by a special break of light.
    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay)  {

       Vector normal = geometry.getNormal(point);
       normal.scale(-2);
       point=point.addVector(normal);
       Vector temp= new Vector( inRay.getVector());
       if (geometry instanceof FlatGeometry){
           return new Ray (temp,point);
       } else {
           return new Ray (temp,point);
       }

   }
    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay)  {

        Vector l = inRay.getVector();
        l.normalize();

        normal.scale(-2 * l.dotProduct(normal));
        l=l.addVector(normal);

        Vector R = new Vector(l);
        R.normalize();

        point=point.addVector(normal);
        Point3D point1 = new Point3D(point);
        point1.addVector(R);
        return new Ray( R,point);
    }
    private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray)  {
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);

        if (intersectionPoints.size() == 0)
            return null;

        Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
        return closestPoint.entrySet().iterator().next();
    }
}