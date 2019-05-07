package geometrics;

import primitives.Point3D;
import primitives.Vector;

public class Triangle {

    protected Point3D A,B,C;

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

}