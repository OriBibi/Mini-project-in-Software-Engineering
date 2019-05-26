package renderer;
import scene.*;
import primitives.*;
import geometries.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;


public class Render  {

    protected Scene scene;
    protected ImageWriter imageWriter;

    // ************* Constructors ****************** //
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

    // ************* Functions ****************** //

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
                Map<Geometry,List<Point3D>> intersections = getSceneRayIntersections(ray);
                if(intersections.isEmpty()) {
                    imageWriter.writePixel(j, i, scene.getBackGround());
                }
                else {
                    Entry<Geometry,Point3D> entry=getClosestPoint(intersections);
                    imageWriter.writePixel(j, i, calcColor(entry.getValue(),entry.getKey()));
                }
            }
        }
    }
    private Entry<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints) {

        double distance = Double.MAX_VALUE;
        Geometry finalGeometry= null;
        Point3D minDistancePoint= new Point3D();
        Point3D P0 = scene.getCamera().getp0();

        for(Entry<Geometry,List<Point3D>> entry: intersectionPoints.entrySet()){
            for (Point3D point: entry.getValue()) {
                if (Point3D.distance(point, P0) < distance)
                    minDistancePoint = new Point3D(point);
                    finalGeometry=entry.getKey();
            }
        }

        HashMap<Geometry,Point3D> finalEntry= new HashMap<Geometry,Point3D>();
        finalEntry.put(finalGeometry,minDistancePoint);

        return finalEntry.entrySet().iterator().next();
    }
    private Color addColors(Color c1,Color c2){
        int red=Math.max(0,Math.min(255,c1.getRed()+c2.getRed()));
        int green=Math.max(0,Math.min(255,c1.getGreen() + c2.getGreen()));
        int blue=Math.max(0,Math.min(255, c1.getBlue()+ c2.getBlue()));
        Color color = new Color (red, blue, green);
        return color;
    }
    private Color calcColor(Point3D point,Geometry geometry) {
        Color ambientLight = this.scene.getAmbientLight().getIntensity(point);
        Color emissionLight = geometry.getEmmission();
        Color I0 = addColors(ambientLight,emissionLight);

        return I0;


    }
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
}