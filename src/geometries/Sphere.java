package geometries;
import primitives.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Sphere extends RadialGeometry {

    private Point3D middlePoint;

    // ************* Constructors ****************** //

    public Sphere(Color color,double _radius, Point3D middlePoint){
        this.setEmmission(color);
        this._radius=_radius;
        this.setMiddlePoint(middlePoint);

    }
    public Sphere(double _radius, Point3D middlePoint) {
        super(_radius);
        this.setMiddlePoint(middlePoint);
    }
    public Sphere( Color color, Material material,double _radius, Point3D middlePoint) {
        super(_radius,color,material);
        this.setMiddlePoint(middlePoint);
    }
    public Sphere(RadialGeometry radialGeometry, Point3D middlePoint) {
        super(radialGeometry);
        this.setMiddlePoint(middlePoint);
    }
    public Sphere(Sphere sphere){
        super(sphere);
        this.setMiddlePoint(sphere.getMiddlePoint());
    }

    // ************* Getters/Setters ****************** //

    public void setMiddlePoint(Point3D middlePoint) {
        this.middlePoint = middlePoint;
    }
    public Point3D getMiddlePoint() {
        return middlePoint;
    }

    // ************* Functions ************************ //

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoints= new ArrayList<Point3D>(2);

        Vector u = new Vector(ray.getStartPoint(), this.getMiddlePoint());
        Vector nd=ray.getVector().getNormal();
        double tm = u.dotProduct(nd);
        double d = Math.sqrt((u.vectorSize()*u.vectorSize()) - (tm*tm));
        d=(int)((d*10000));
        d=d/10000;
        if (d > this.get_radius())
            return intersectionPoints; // return null;

        double th = Math.sqrt((this.get_radius()*this.get_radius()) - (d*d));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 > 0){
            Vector V = ray.getVector().getNormal();
            V.scale(t1);
            Point3D p = ray.getStartPoint();
            Point3D P1 =p.addVector(V);
            intersectionPoints.add(P1);
        }

        if (t2 > 0&& t1!=t2){
            Vector V = ray.getVector().getNormal();
            V.scale(t2);
            Point3D p = ray.getStartPoint();
            Point3D P2 =p.addVector(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;
    }
    public Vector getNormal(Point3D point) {
        Vector vector = new Vector(getMiddlePoint(), point);
        vector.normalize();
        return vector;
    }

}

