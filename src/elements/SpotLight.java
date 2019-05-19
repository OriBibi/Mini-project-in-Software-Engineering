package elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class SpotLight extends PointLight {

    private Vector direction;
    // ***************** Constructor ********************** //
    public SpotLight(Color color, Point3D position, Vector direction,
                     double kc, double kl, double kq){
        this.color=color;
        this.position=position;
        this.direction=direction;
        this.setKc(kc);
        this.setKl(kl);
        this.setKq(kq);
    }
    public SpotLight(){
        this.color=Color.yellow;
        this.position=new Point3D(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(10.0));
        this.direction=new Vector(new Coordinate(1.0),Coordinate.ZERO,Coordinate.ZERO);
        this.setKc(0);
        this.setKl(0);
        this.setKq(0);
    }
    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point);
}
