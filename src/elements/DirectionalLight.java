package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
//Light that is found in the infinite. He has strength and intensity. I do not have a position, so the amount of light is equal to each point in space.
public class DirectionalLight extends Light {
    private Vector direction;

    public DirectionalLight() {
        super();
        this.setDirection(new Vector(0,-1,0));
    }
    public DirectionalLight(Vector direction) {
        super();
        this.setDirection(direction);
    }
    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.setDirection(direction);
    }
    public DirectionalLight(DirectionalLight directionalLight){
        this.setDirection(directionalLight.getDirection());

    }


    public Vector getDirection() {
        return direction;
    }
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public Color getIntensity(Point3D point){
        return super.getColor();
    }
    public Vector getL(Point3D point){
        //to implement
        return getDirection().getNormal();
    }

}
