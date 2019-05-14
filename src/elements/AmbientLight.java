package elements;

import primitives.Point3D;

import java.awt.Color;

public class AmbientLight {
    private Color intensity;
    private double ka;

    public AmbientLight() {
        this.setIntensity(Color.white);
        this.setKa(0.25);
    }
    public AmbientLight(Color intensity, double ka) {
        this.setIntensity(intensity);
        this.setKa(ka);
    }
    public AmbientLight(int a,int b,int c){
        this.setKa(0.25);
        this.setIntensity(new Color(a,b,c));
    }
    public AmbientLight(AmbientLight al){
        this.setIntensity(al.getIntensity());
        this.setKa(al.getKa());
    }

    public Color getIntensity() {
        return intensity;
    }

    public void setIntensity(Color intensity) {
        this.intensity = intensity;
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
        return new Color((int) (getIntensity().getRed() * getKa()),
                (int) (getIntensity().getGreen() * getKa()),
                (int) (getIntensity().getBlue() * getKa()));
    }
}
