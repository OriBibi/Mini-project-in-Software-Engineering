package elements;

import primitives.Point3D;

import java.awt.Color;

public class AmbientLight {
    private Color color;
    private double ka;

    public AmbientLight() {
        this.setColor(Color.white);
        this.setKa(1.0);
    }
    public AmbientLight(Color color, double ka) {
        this.setColor(color);
        this.setKa(ka);
    }
    public AmbientLight(int a,int b,int c){
        this.setKa(0.1);
        this.setColor(new Color(a,b,c));
    }
    public AmbientLight(AmbientLight al){
        this.setColor(al.getColor());
        this.setKa(al.getKa());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
}
