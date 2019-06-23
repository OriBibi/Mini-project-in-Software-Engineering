package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.Color;

//An ambient light source represents a fixed-intensity and fixed-color light source that affects all objects in the scene equally.

@SuppressWarnings("WeakerAccess")
public class AmbientLight extends Light{

    // ***************** variables ************************* //

    private double ka;

    // ***************** Constructors ********************** //

    public AmbientLight() {
        this.setColor(Color.white);
        this.setKa(0);
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

    // ***************** Getters/Setters ******************* //


    public double getKa() {
        return ka;
    }
    public void setKa(double ka) {
        this.ka = ka;
    }


    // ***************** Operations *********************** //

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public String toString() {
        return super.toString();
    }
    /*************************************************
     * FUNCTION:
     getIntensity.
     * PARAMETERS:
     Point3D
     * RETURN VALUE:
     color.
     * MEANING
     We are never use this function,  inheritance from an abstract class.
     **************************************************/
    public Color getIntensity(Point3D point){
        return new Color((int) (getColor().getRed() * getKa()),
                (int) (getColor().getGreen() * getKa()),
                (int) (getColor().getBlue() * getKa()));
    }
    @Override
    public Vector getL(Point3D point) {
        return new Vector(1,0,0);
    }
    /*************************************************
     * FUNCTION:
       getIntensity.
     * PARAMETERS:
       N\A.
     * RETURN VALUE:
       color.
     * MEANING
       This function returns the color of the geomtry that using the ambient light.
     **************************************************/
    public Color getIntensity() {
        return new Color((int) (getColor().getRed() * getKa()),
                (int) (getColor().getGreen() * getKa()),
                (int) (getColor().getBlue() * getKa()));

    }
}
