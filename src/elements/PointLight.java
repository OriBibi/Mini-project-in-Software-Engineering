package elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class PointLight extends Light {
    Point3D position;
    double Kc, Kl, Kq;
    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position,
                      double kc, double kl, double kq){
    this.color=color;
    this.position=position;
    this.Kc=kc;
    this.Kl=kl;
    this.Kq=kq;
    }
    public PointLight(){
        this.color=Color.yellow;
        this.position=new Point3D(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(10.0));
        this.Kc=0;
        this.Kl=0;
        this.Kq=0;

    }
    // ***************** Getters/Setters ********************** //
    public Color getIntensity(Point3D point);
    public Vector getL(Point3D point);
}
