import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

    @Test
    void getNormal() {
        System.out.print("Test15: Triangle getNormal test: ");
        Triangle triangle = new Triangle(new Point3D( 0,  1, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2));
        Vector normal = triangle.getNormal(null);
        System.out.println(normal);
        Vector expected =new Vector(new Point3D(0.0, 0.0,1.0));
        boolean res = normal.equals(expected);
        System.out.println(res);
        assertEquals(expected, normal);


    }
}