package scene;
import elements.AmbientLight;
import elements.Camera;
import geometries.Geometry;
import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;

public class Scene {

    protected String sceneName;
    protected Color backGround;
    protected ArrayList<Geometry> geometries;
    protected Camera camera;
    protected double screenDistance;
    protected AmbientLight ambientLight;
    public void addGeometry(Geometry geometry){
        this.geometries.add(geometry);
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
        geometries=new ArrayList<>();
        screenDistance=100;
        sceneName=" ";
        backGround=Color.black;
        camera= new Camera();
        ambientLight=new AmbientLight();
    }

    public Scene(String sceneName, Color backGround, Camera camera, double screenDistance, AmbientLight ambientLight) {
        this.sceneName = sceneName;
        this.backGround = backGround;
        this.geometries = new ArrayList<>();
        this.camera = camera;
        this.screenDistance = screenDistance;
        this.ambientLight = ambientLight;
    }

    public Scene(Scene scene) {
        this.sceneName = scene.sceneName;
        this.backGround = scene.backGround;
        this.geometries = scene.geometries;
        this.camera = scene.camera;
        this.screenDistance = scene.screenDistance;
        this.ambientLight = scene.ambientLight;
    }
    public Iterator<Geometry> getGeometriesIterator()
    {
        return this.geometries.iterator();
    }

}
