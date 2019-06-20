package scene;
import elements.*;
import geometries.Geometry;
import primitives.Vector;

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
        //addLightSoft(light);
        this.lights.add(light);
    }
    public void addLightSoft(Light light){
        if(light instanceof DirectionalLight||light instanceof AmbientLight){
            this.lights.add(light);
        }
        else {
            light.setColor(new Color(light.getColor().getRed() / 7,
                    light.getColor().getGreen() / 7,
                    light.getColor().getBlue() / 7));

            if(light instanceof PointLight) {
                PointLight pointLight = (PointLight) light;
                //making the lights form in a 3d area
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(0, 0, 5)));
                this.lights.add(new PointLight(pointLight));
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(0, 0, -10)));
                this.lights.add(new PointLight(pointLight));
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(0, 5, 5)));
                this.lights.add(new PointLight(pointLight));
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(0, -10, 0)));
                this.lights.add(new PointLight(pointLight));
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(5, 5, 0)));
                this.lights.add(new PointLight(pointLight));
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(-10, 0, 0)));
                this.lights.add(new PointLight(pointLight));
                pointLight.setPosition(pointLight.getPosition().addVector(new Vector(5, 0, 0)));
                this.lights.add(new PointLight(pointLight));
            }
            else if(light instanceof SpotLight){
                SpotLight spotLight=(SpotLight)light;

                //need to enter orthogonal vectors to spotlight direction
                //to put 5 point of lights with one of them in the middle

                spotLight.setPosition(spotLight.getPosition().addVector(new Vector(0, 0, 20)));
                this.lights.add(new SpotLight(spotLight));
                spotLight.setPosition(spotLight.getPosition().addVector(new Vector(0, 0, -40)));
                this.lights.add(new SpotLight(spotLight));
                spotLight.setPosition(spotLight.getPosition().addVector(new Vector(0, 20, 20)));
                this.lights.add(new SpotLight(spotLight));
                spotLight.setPosition(spotLight.getPosition().addVector(new Vector(0, -40, 0)));
                this.lights.add(new SpotLight(spotLight));
                spotLight.setPosition(spotLight.getPosition().addVector(new Vector(20, 20, 0)));
                this.lights.add(new SpotLight(spotLight));
            }
        }
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
