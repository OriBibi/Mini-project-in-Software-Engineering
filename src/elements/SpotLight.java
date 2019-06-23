package elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/*A light that combines direction and location.
 Its light is smaller as distance grows.*/

public class SpotLight extends PointLight {

    // ***************** variables ********************** //

    private Vector direction;

    // ***************** Constructor ********************** //

    public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq){
        this.setColor(color);
        this.setPosition(position);
        this.setDirection(direction);
        this.setKc(kc);
        this.setKl(kl);
        this.setKq(kq);
    }
    public SpotLight(SpotLight spotLight){
        this.setColor(spotLight.getColor());
        this.setPosition(spotLight.getPosition());
        this.setDirection(spotLight.getDirection());
        this.setKc(spotLight.getKc());
        this.setKl(spotLight.getKl());
        this.setKq(spotLight.getKq());

    }
    public SpotLight(){
        this.setColor(Color.yellow);
        this.setPosition(new Point3D(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(10.0)));
        this.setDirection(new Vector(new Coordinate(1.0),Coordinate.ZERO,Coordinate.ZERO));
        this.setKc(0);
        this.setKl(0);
        this.setKq(0);
    }

    // ***************** Getters/Setters ********************** //

    /*************************************************
     * FUNCTION
     getIntensity
     * PARAMETERS
     Point3D
     * RETURN VALUE
     Color
     * MEANING
     This functions computes the intensity of the light by the distance from the point
     /*********************************************/
    public Color getIntensity(Point3D point) {

        Color pointColor = super.getIntensity(point);

        Vector l = super.getL(point);
        l.normalize();
        double k = Math.abs(getDirection().dotProduct(l));

        if (k > 1) k = 1; // doesn't allow light magnification

        return new Color((int) (pointColor.getRed() * k),
                (int) (pointColor.getGreen() * k),
                (int) (pointColor.getBlue() * k));
    }
    public Vector getDirection() {
        return direction.getNormal();
    }
    public void setDirection(Vector direction) {
        this.direction = direction.getNormal();
    }
}
