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

        Vector u = new Vector(ray.getStartPoint(), this.getMiddlePoint());//Vector "center" which is between the main point and the center point of the sphere.
        Vector nd=ray.getVector().getNormal();//Find  normal vector for multiplication with the special coefficient.
        double tm = u.dotProduct(nd);//We get the size of the vector on which the intersection points of the ray     are located with the sphere.
        double d = Math.sqrt((u.vectorSize()*u.vectorSize()) - (tm*tm));//The size of the vertical with the given ray.
        d=(int)((d*10000));
        d=d/10000;
        if (d > this.get_radius())//If the vertical is larger than the radius it means that the ray  is not intersected with the sphere

            return intersectionPoints; // return null;

        double th = Math.sqrt((this.get_radius()*this.get_radius()) - (d*d));//The third side in the right triangle. One side is the vertical, the other is the radius and the third is found by the Phygorers theorem


        double t1 = tm - th;//The coefficient that will lead me to the near  point of intersection
        double t2 = tm + th;//The coefficient that will lead me to the far point of intersection

        if (t1 > 0){
            Vector V = ray.getVector().getNormal();
            V.scale(t1);
            Point3D p = ray.getStartPoint();
            Point3D P1 =p.addVector(V);
            intersectionPoints.add(P1);
        }

        if (t2>0&& t2!=t1){
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

