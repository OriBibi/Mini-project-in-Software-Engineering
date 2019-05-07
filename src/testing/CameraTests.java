package testing;
import primitives.*;
import static org.junit.jupiter.api.Assertions.*;
import elements.Camera;
public class CameraTests {

    @org.junit.jupiter.api.Test
    void testRaysConstruction() {
        Vector vup = new Vector(0, 1, 0);
        Vector vto = new Vector(0, 0, -1);

        Camera c = new Camera(new Point3D(), vup, vto);

        Ray ray = c.constructRayThroughPixel(3, 3, 3
                , 3, 100, 150, 150);
        Point3D centerPoint = new Point3D(0, 0, 0);
        Vector direction = new Vector(-0.5773502691896257, -0.5773502691896257, -0.5773502691896257);

        //x is negative why?
        Ray answer = new Ray( direction,centerPoint);
        assertEquals(answer.toString(), ray.toString());
    }
}
