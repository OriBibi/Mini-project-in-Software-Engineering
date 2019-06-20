package elements;

import primitives.Point3D;
import primitives.Vector;


import java.awt.*;

public abstract class Light {

    // ***************** variables ********************** //

    private Color color;
    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point);


    // ***************** Getters/Setters ********************** //

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    // ***************** Constructors ********************** //

    public Light(){
        this.setColor(Color.yellow);
    }
    public Light(Light light){
        this.setColor(light.getColor());
    }
    public Light(Color color) {
        this.setColor(color);
    }
}
