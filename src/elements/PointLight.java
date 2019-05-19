package elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public class PointLight extends Light {
    private Point3D position;
    private double Kc;
    private double Kl;
    private double Kq;
    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position,
                      double kc, double kl, double kq){
    this.setColor(color);
    this.setPosition(position);
    this.setKc(kc);
    this.setKl(kl);
    this.setKq(kq);
    }
    public PointLight(){
        this.setColor(Color.yellow);
        this.setPosition(new Point3D(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(10.0)));
        this.setKc(0);
        this.setKl(0);
        this.setKq(0);

    }
    // ***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point) {

        int r = this.getColor().getRed();
        int g = this.getColor().getGreen();
        int b = this.getColor().getBlue();

        double d = Point3D.distance(getPosition(),point);

        double k = 1 / (getKc() + getKl() * d + getKq() * Math.pow(d, 2));

        if (k > 1) k = 1;

        return new Color((int) (r * k),
                (int) (g * k),
                (int) (b * k));
    }
    public Vector getL(Point3D point){return new Vector(position,point);}

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

    public double getKc() {
        return Kc;
    }

    public void setKc(double kc) {
        Kc = kc;
    }

    public double getKl() {
        return Kl;
    }

    public void setKl(double kl) {
        Kl = kl;
    }

    public double getKq() {
        return Kq;
    }

    public void setKq(double kq) {
        Kq = kq;
    }
}
