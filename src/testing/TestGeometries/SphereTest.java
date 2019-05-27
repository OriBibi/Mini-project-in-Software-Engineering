package TestGeometries;

import geometries.Sphere;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getNormal() {
        Vector answer = new Vector(0.7071067811865475, 0.7071067811865475, 0.0);

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(1,1, -400);

        Sphere sphere = new Sphere( 200, p1);

        Vector vector = sphere.getNormal(p2);
        assertEquals(answer, vector);
    }
    /*
    @Test
    void findIntersections() {
        // creating the expected values
        List<Point3D> answerList1 = new ArrayList<Point3D>();
        List<Point3D> answerList2 = new ArrayList<Point3D>();

        Point3D answerPoint1 = new Point3D(0, 0, -200);
        Point3D answerPoint2 = new Point3D(0, 0, -600);

        answerList2.add(answerPoint1);
        answerList2.add(answerPoint2);


        // building the spheres

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(p1);
        Point3D centerPoint = new Point3D(0,0,0);

        Vector direction1 = new Vector(50, -50, -50);
        Vector direction2 = new Vector(0, 0, -5);
        Sphere sphere1 = new Sphere(Color.white, 200, p1);
        Sphere sphere2 = new Sphere(Color.white, 200, p2);

        // building the ray that will intersect the spheres

        Ray ray1 = new Ray( direction1,centerPoint);
        Ray ray2 = new Ray( direction1,centerPoint);
        // testing the findIntersection functions
        List<Point3D> list1 = new ArrayList<Point3D>();
        list1 = sphere1.findIntersections(ray1);
        assertEquals(answerList1, list1);

        List<Point3D> list2 = new ArrayList<Point3D>();
        list2 = sphere2.findIntersections(ray2);
        assertEquals(answerList2, list2);
    }*/

    @Test
    public void testFindIntersections() {
        /**
         * test for p0==o
         */
        Sphere sphere = new Sphere(5, new Point3D(0, 0, 1));
        Ray ray = new Ray( new Vector(0, 0, -2),new Point3D(0, 0, 1));
        ArrayList<Point3D> list = new ArrayList<Point3D>();

        list.add(new Point3D(0, 0, -4));
        assertEquals(sphere.findIntersections(ray), list);

        /**
         * test for p0 inside the sphere with the same Direction
         */

        sphere = new Sphere(5, new Point3D(0, 0, 1));
        ray = new Ray( new Vector(0, 0, 1),new Point3D(0, 0, 2));
        list.clear();
        list.add(new Point3D(0, 0, 6));
        assertEquals(sphere.findIntersections(ray), list);

        /**
         * test for p0 inside the sphere with the different Direction
         */

        sphere = new Sphere(4,new  Point3D());
        ray = new Ray( new Vector(1, 0, 0),new Point3D(0, 1, 0));
        list = new ArrayList<Point3D>();
        list.add(new Point3D(Math.sqrt(15), 1, 0));
        assertEquals(sphere.findIntersections(ray), list);

        /**
         * Test for ray Parallel to the sphere without passing through it
         */
        sphere = new Sphere(1, new Point3D());
        ray = new Ray(new Vector(1, 0, 0),new Point3D(0, 0, 2));
        list = new ArrayList<Point3D>();
        assertEquals(sphere.findIntersections(ray), list);

        /**
         * Test for getting 2 point on the sphere
         */
        ray = new Ray(new Vector(0, 0, -1),new Point3D(0, 0, 3));
        list.add(new Point3D(0, 0, 1));
        list.add(new Point3D(0, 0, -1));
        assertEquals(sphere.findIntersections(ray), list);

        /**
         * test for ray that tangent to the sphere
         */

        ray = new Ray(new Vector(0, -5, 0),new Point3D(0, 1, 1));
        list.clear();
        list.add(new Point3D(0, 0, 1));
        List<Point3D> l=sphere.findIntersections(ray);
        assertEquals(l, list);

        /**
         * test for when the ray start on the surface of the sphere and go away from it
         */

        ray = new Ray( new Vector(0, 0, 1),new Point3D(0, 0, 1));
        // System.out.println(sphere.findIntersections(ray));
        list.clear();
        assertEquals(sphere.findIntersections(ray), list);
    }
}