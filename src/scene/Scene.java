package scene;
import elements.AmbientLight;
import elements.Camera;
import geometries.Geometry;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;

public class Scene {

    private String sceneName;
    private Color backGround;
    private ArrayList<Geometry> geometries;
    private Camera camera;
    private double screenDistance;
    private AmbientLight ambientLight;
    public void addGeometry(Geometry geometry){
        this.getGeometries().add(geometry);
    }

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
    public AmbientLight getAmbientLight() {
        return ambientLight;
    }
    public void setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
    }

    // ***************** Constructors ********************** //
    public Scene() {
        setSceneName("default scene");
        setGeometries(new ArrayList<>());
        setScreenDistance(160);
        setBackGround(Color.black);
        setCamera(new Camera());
        setAmbientLight(new AmbientLight());
    }

    public Scene(String sceneName, Color backGround, Camera camera, double screenDistance, AmbientLight ambientLight) {
        this.setSceneName(sceneName);
        this.setBackGround(backGround);
        this.setGeometries(new ArrayList<>());
        this.setCamera(camera);
        this.setScreenDistance(screenDistance);
        this.setAmbientLight(ambientLight);
    }

    public Scene(Scene scene) {
        this.setSceneName(scene.getSceneName());
        this.setBackGround(scene.getBackGround());
        this.setGeometries(scene.getGeometries());
        this.setCamera(scene.getCamera());
        this.setScreenDistance(scene.getScreenDistance());
        this.setAmbientLight(scene.getAmbientLight());
    }
    public Iterator<Geometry> getGeometriesIterator()
    {
        return this.getGeometries().iterator();
    }

}
