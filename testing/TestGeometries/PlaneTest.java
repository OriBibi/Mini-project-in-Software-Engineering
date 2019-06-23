package TestGeometries;

import geometries.Plane;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void findIntersections() {
        // creating the expected values

        List<Point3D> answerList = new ArrayList<>();
        Point3D answerPoint = new Point3D(0, 0, -200);
        answerList.add(answerPoint);

        // building the plane

        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);

        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane(Color.white, planePoint, direction);

        // building the ray that will intersect the plane

        Point3D centerPoint = new Point3D(0,0,0);
        Vector vector = new Vector(0, 0, -5);
        Ray ray = new Ray(vector,centerPoint);

        // testing the findIntersection function

        List<Point3D> list;
        list = plane.findIntersections(ray);
        assertEquals(answerList, list);
    }

    @Test
    void getOrthogonalVector() {
        Vector answer = new Vector(0,0, -1);

        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);
        Point3D normalPoint = new Point3D(1, 1, -200);

        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane( planePoint, direction);

        Vector vector = plane.getOrthogonalVector();
        assertEquals(answer, vector);
    }
}