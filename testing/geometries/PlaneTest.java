package geometries;
import java.util.ArrayList;
import java.util.List;

import primitives.*;
import elements.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlaneTest {
    @Test
    public void Test18()
    {

        final int WIDTH  = 3;
        final int HEIGHT = 3;

        System.out.println("Test18: Plane intersection test");

        Ray[][] rays = new Ray [HEIGHT][WIDTH];

        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        // plane orthogonal to the view plane
        Plane plane1  = new Plane( new Point3D(0.0, 0.0, -3.0),new Vector(0.0, 0.0, -1.0));

        // 45 degrees to the view plane
        Plane plane2 = new Plane( new Point3D(0.0, 0.0, -3.0),new Vector(0.0, 0.25, -1.0));

        List<Point3D> intersectionPointsPlane1 = new ArrayList<>(2);
        List<Point3D> intersectionPointsPlane2 = new ArrayList<>(2);

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                List<Point3D> rayIntersectionPoints1  = plane1.findIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2  = plane2.findIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints1)
                    intersectionPointsPlane1.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsPlane2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsPlane1.size() == 9);
        assertTrue(intersectionPointsPlane2.size() == 9);

        System.out.println("Plane1 intersetions");
        for (Point3D iPoint: intersectionPointsPlane1)
            System.out.println(iPoint);
        System.out.println("---");
        System.out.println("Plane2 intersetions");
        for (Point3D iPoint: intersectionPointsPlane2)
            System.out.println(iPoint);
    }

}

