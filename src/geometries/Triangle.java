package geometries;

import primitives.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class Triangle extends Geometry implements FlatGeometry {

    protected Point3D A,B,C;

    // ************* Constructors ****************** //

    public Triangle() {
        super();
        A=new Point3D(1,0,0);
        B=new Point3D(0,1,0);
        C=new Point3D(0,0,1);
    }
    public Triangle (Triangle triangle){
        super(triangle.getEmmission(),triangle.getMaterial());
        this.A = triangle.A;
        this.B = triangle.B;
        this.C = triangle.C;
    }
    public Triangle (Material material,Color color,Point3D a, Point3D b, Point3D c ) {
        super(color,material);
        A = a;
        B = b;
        C = c;
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

    // ************* Getters/Setters ****************** //

    public Point3D getA() {
        return A;
    }
    public Point3D getB() {
        return B;
    }
    public Point3D getC() {
        return C;
    }

    // ************* Functions ************************ //

    /*************************************************
     * FUNCTION
     * getNormal
     * PARAMETERS
     * Point3D point
     * RETURN VALUE
     * Vector who is the normal to the point
     * MEANING
     * This functions computes a normal vector into specific point.

     /***************************************************/
    public Vector getNormal(Point3D p) {
        Vector v1 = new Vector(A, B);
        Vector v2 = new Vector(A, C);
        Vector v = v1.crossProduct(v2);
        v.normalize();
        //v.scale(-1);
        return v;
    }
    @Override
    /*************************************************
     * FUNCTION:
      FindIntersections
     * PARAMETERS:
      ray
     * RETURN VALUE:
      List<Point3D>
     * MEANING:
      This functions computes a all the intersections of specific ray with the triangle
     /***************************************************/
    public List<Point3D> findIntersections(Ray ray) {

        List<Point3D> intersectionPoints = new ArrayList<>(1);

        // Intersecting the triangular plane

        Point3D P0 = ray.getStartPoint();

        Vector N = getNormal(null);

        Plane plane = new Plane(C,N);
        List<Point3D> planeIntersections = plane.findIntersections(ray);
        if (!planeIntersections.isEmpty()) {

            Point3D intersectionPlane = planeIntersections.get(0);

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
        }

        return intersectionPoints;

    }
}