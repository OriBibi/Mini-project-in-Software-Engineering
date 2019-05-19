package geometries;

import primitives.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class Triangle extends Geometry {

    protected Point3D A,B,C;
    public Triangle (Triangle triangle){
        this.setEmmission(triangle.getEmmission());
        this.A = triangle.A;
        this.B = triangle.B;
        this.C = triangle.C;
    }
    public Triangle (Color color,Point3D a, Point3D b, Point3D c ) {
    setEmmission(color);
    A = a;
    B = b;
    C = c;
}
    public Triangle(Point3D a, Point3D b, Point3D c) {
        A = a;
        B = b;
        C = c;
    }

    public Point3D getA() {
        return A;
    }
    public Point3D getB() {
        return B;
    }
    public Point3D getC() {
        return C;
    }

    public Vector getNormal(Point3D p) {
        Vector v1 = new Vector(A, B);
        Vector v2 = new Vector(A, C);
        Vector v = v2.crossProduct(v1);
        v.normalize();
        v.scale(-1);
        return v;
    }
    @Override
    public List<Point3D> findIntersections(Ray ray) {

        List<Point3D> intersectionPoints = new ArrayList<Point3D>(1);

        // Intersecting the triangular plane

        Point3D P0 = ray.getStartPoint();

        Vector N = getNormal(null);

        Plane plane = new Plane(C,N);
        if (plane.findIntersections(ray).isEmpty())
            return intersectionPoints;

        Point3D intersectionPlane = plane.findIntersections(ray).get(0);

        // Checking if the interseculating point is bounded by the triangle
        Vector P_P0 = new Vector(P0, intersectionPlane);

        // Checking 1/3 triangular side
        Vector V1_1 = new Vector(P0, this.A);
        Vector V2_1 = new Vector(P0, this.B);
        Vector N1 = V1_1.crossProduct(V2_1);
        N1.normalize();
        double S1 = -P_P0.dotProduct(N1);

        // Checking 2/3 triangular side
        Vector V1_2 = new Vector(P0, this.B);
        Vector V2_2 = new Vector(P0, this.C);
        Vector N2 = V1_2.crossProduct(V2_2);
        N2.normalize();
        double S2 = -P_P0.dotProduct(N2);

        // Checking 1/3 triangular side
        Vector V1_3 = new Vector(P0, this.C);
        Vector V2_3 = new Vector(P0, this.A);
        Vector N3 = V1_3.crossProduct(V2_3);
        N3.normalize();
        double S3 = -P_P0.dotProduct(N3);

        if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                ((S1 < 0) && (S2 < 0) && (S3 < 0))) {
            intersectionPoints.add(intersectionPlane);
        }

        return intersectionPoints;

    }
}