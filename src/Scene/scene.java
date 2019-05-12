package Scene;
import elements.Camera;
import geometrics.Geometry;

import java.awt.Color;
import java.util.ArrayList;

public class scene {

    protected String sceneName;
    protected Color backGround;
    ArrayList<Geometry> geometries;
    Camera camera;
    double screenDistance;
    public void addGeometry(Geometry geometry){}

    // ***************** Getters/Setters ********************** //
    public String getSceneName() {
        return sceneName;
    }
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }
    public Color getBackGround() {
        return backGround;
    }
    public void setBackGround(Color backGround) {
        this.backGround = backGround;
    }
    public ArrayList<Geometry> getGeometries() {
        return geometries;
    }
    public void setGeometries(ArrayList<Geometry> geometries) {
        this.geometries = geometries;
    }
    public Camera getCamera() {
        return camera;
    }
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public double getScreenDistance() {
        return screenDistance;
    }
    public void setScreenDistance(double screenDistance) {
        this.screenDistance = screenDistance;
    }

    // ***************** Constructors ********************** //
    public scene() {
        geometries=new ArrayList<>();
        screenDistance=0;
        sceneName=" ";
        backGround=Color.black;
        camera= new Camera();
    }
}
