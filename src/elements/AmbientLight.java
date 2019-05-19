package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.Color;

public class AmbientLight extends Light{
    private double ka;

    public AmbientLight() {
        this.setColor(Color.yellow);
        this.setKa(0.25);
    }
    public AmbientLight(Color color, double ka) {
        this.setColor(color);
        this.setKa(ka);
    }
    public AmbientLight(int a,int b,int c){
        this.setKa(0.25);
        this.setColor(new Color(a,b,c));
    }
    public AmbientLight(AmbientLight al){
        this.setColor(al.getColor());
        this.setKa(al.getKa());
    }


    public double getKa() {
        return ka;
    }

    public void setKa(double ka) {
        this.ka = ka;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Color getIntensity(Point3D point){
        return new Color((int) (getColor().getRed() * getKa()),
                (int) (getColor().getGreen() * getKa()),
                (int) (getColor().getBlue() * getKa()));
    }

    @Override
    public Vector getL(Point3D point) {
        return new Vector(1,0,0);
    }
}
