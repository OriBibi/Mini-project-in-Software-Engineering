package scene;
import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    private String sceneName;
    private Color backGround;
    private ArrayList<Geometry> geometries;
    private Camera camera;
    private double screenDistance;
    private AmbientLight ambientLight;
    private List<Light> lights;

    public void addGeometry(Geometry geometry){
        this.getGeometries().add(geometry);
    }
    public void addLight(Light light){
        this.lights.add(light);
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
    public List<Light> getLights() {
        return lights;
    }
    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    // ***************** Constructors ********************** //
    public Scene() {
        setSceneName("default scene");
        setGeometries(new ArrayList<>());
        setScreenDistance(150);
        setSceneName(" ");
        setBackGround(Color.black);
        setCamera(new Camera());
        setAmbientLight(new AmbientLight());
        setLights(new ArrayList<>());
    }

    public Scene(String sceneName, Color backGround, Camera camera, double screenDistance, AmbientLight ambientLight) {
        this.setSceneName(sceneName);
        this.setBackGround(backGround);
        this.setGeometries(new ArrayList<>());
        this.setCamera(camera);
        this.setScreenDistance(screenDistance);
        this.setAmbientLight(ambientLight);
    }

    public Scene(String sceneName, Color backGround, Camera camera, double screenDistance, AmbientLight ambientLight,List<Light> lights) {
        this.setSceneName(sceneName);
        this.setBackGround(backGround);
        this.setGeometries(new ArrayList<>());
        this.setCamera(camera);
        this.setScreenDistance(screenDistance);
        this.setAmbientLight(ambientLight);
        this.setLights(lights);
    }

    public Scene(Scene scene) {
        this.setSceneName(scene.getSceneName());
        this.setBackGround(scene.getBackGround());
        this.setGeometries(scene.getGeometries());
        this.setCamera(scene.getCamera());
        this.setScreenDistance(scene.getScreenDistance());
        this.setAmbientLight(scene.getAmbientLight());
        this.setLights(scene.lights);
    }
    public Iterator<Geometry> getGeometriesIterator()
    {
        return this.getGeometries().iterator();
    }
    public Iterator<Light> getLightsIterator(){
        return this.getLights().iterator();
    }

}
