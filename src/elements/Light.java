package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public abstract class Light {

    Color color;
    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point);
    public Light() {
        this.color = Color.yellow;
    }
    public Light(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
