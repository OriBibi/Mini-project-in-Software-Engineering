package renderer;
import scene.*;
import primitives.*;
import geometries.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
                ArrayList<Point3D> intersections = getSceneRayIntersections(ray);
                if(intersections.isEmpty()) {
                    imageWriter.writePixel(j, i, scene.getBackGround());
                }
                else {
                    imageWriter.writePixel(j, i, calcColor(getClosestPoint(intersections)));
                }
            }
        }
    }
    private Point3D getClosestPoint(ArrayList<Point3D> intersectionPoints) {

        double distance = Double.MAX_VALUE;
        Point3D P0 = scene.getCamera().getp0();
        Point3D minDistancePoint = null;

        for (Point3D point: intersectionPoints) {
            if (Point3D.distance(point, P0) < distance)
                minDistancePoint = new Point3D(point);
        }
        //distance = Point3D.distance(minDistancePoint,P0);
        return minDistancePoint;
    }
    private Color calcColor(Point3D point) {
        return getScene().getAmbientLight().getIntensity(point);
    }
    private ArrayList<Point3D> getSceneRayIntersections(Ray ray) {

        Iterator<Geometry> geometries = scene.getGeometriesIterator();
        ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
            intersectionPoints.addAll(geometryIntersectionPoints);
        }
        return intersectionPoints;

    }
}