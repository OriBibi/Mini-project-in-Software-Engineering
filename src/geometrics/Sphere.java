package geometrics;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class Sphere extends RadialGeometry {

    protected Point3D middlePoint;
    public Sphere(Color color,double _radius, Point3D middlePoint){
        this.geoColor=color;
        this._radius=_radius;
        this.middlePoint=middlePoint;

    }
    public Sphere(double _radius, Point3D middlePoint) {
        super(_radius);
        this.middlePoint = middlePoint;
    }

    public Sphere(RadialGeometry radialGeometry, Point3D middlePoint) {
        super(radialGeometry);
        this.middlePoint = middlePoint;
    }
    public Vector getNormal(Point3D point) {
        Vector vector = new Vector(middlePoint, point);
        vector.normalize();
        return vector;
    }
    public Point3D getMiddlePoint() {
        return middlePoint;
    }
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoints= new ArrayList<Point3D>(2);
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        Vector u = new Vector(ray.getStartPoint(), this.getMiddlePoint());
        double tm = u.dotProduct(ray.getVector().getNormal());
        double  d = Double.parseDouble(numberFormat.format(Math.sqrt((u.vectorSize()*u.vectorSize()) - (tm*tm))));

        if (d > this.get_radius())
            return intersectionPoints; // return null;

        double th = Math.sqrt((this.get_radius()*this.get_radius()) - (d*d));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0){
            Vector V = ray.getVector().getNormal();
            V.scale(t1);
            Point3D p = ray.getStartPoint();
            Point3D P1 =p.addVector(V);
            intersectionPoints.add(P1);
        }

        if (t2 >= 0){
            Vector V = ray.getVector().getNormal();
            V.scale(t2);
            Point3D p = ray.getStartPoint();
            Point3D P2 =p.addVector(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;
    }
}

