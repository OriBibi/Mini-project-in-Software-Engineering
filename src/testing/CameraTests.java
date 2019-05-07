package testing;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import elements.Camera;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTests {

    @Test
    public void testConstructRay1() {
        //System.out.println("Test Ray Through Pixel");

        Vector vup = new Vector(0, 1, 0);
        Vector vto = new Vector(0, 0, -1);

        Camera c = new Camera(new Point3D(100,-100,-100),vup, vto);

        Ray ray = c.constructRayThroughPixel(3, 3, 3
                , 3, 100, 150, 150);
        Point3D centerPoint = new Point3D(100,-100,-100);
        Vector direction = new Vector(-0.5773502691896257, -0.5773502691896257, -0.5773502691896257);

        Ray answer = new Ray(direction,centerPoint);
        assertEquals(answer, ray);
    }

    @Test
    public void testConstructRay2() {

        final int WIDTH  = 3;
        final int HEIGHT = 3;


        Point3D p = new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(0.0));
        Point3D p1 = new Point3D(new Coordinate(0.0), new Coordinate(1.0), new Coordinate(0.0));
        Point3D p2 = new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1.0));


        Vector v1 = new Vector(p1);
        Vector v2 = new Vector(p2);

        Point3D[][] screen = new Point3D [HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(),v1, v2);

        System.out.println("Camera:\n" + camera);
        System.out.println("##");

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                Ray ray = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                //screen[i][j] = ray.getPoo();

                System.out.print(" ^^ " + screen[i][j]);
                System.out.println(" *** " + ray.getStartPoint());

                // Checking z-coordinate
                assertTrue(Double.compare(screen[i][j].getZ().get(), -1.0) == 0);

                // Checking all options
                double x = screen[i][j].getX().get();
                double y = screen[i][j].getX().get();

                if (Double.compare(x, 3) == 0 ||
                        Double.compare(x, 0) == 0 ||
                        Double.compare(x, -3) == 0){
                    if (Double.compare(y, 3) == 0 ||
                            Double.compare(y, 0) == 0 ||
                            Double.compare(y, -3) == 0){
                        assertTrue(true);
                    } else {
                        fail("Wrong y coordinate");
                    }
                } else {
                    fail("Wrong x coordinate");
                }

            }
            System.out.println("--");
        }

    }


}
