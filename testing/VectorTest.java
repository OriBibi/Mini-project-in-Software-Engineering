
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void testequals(){
        Vector one = new Vector(new Point3D(2,3,4));
        Vector onemore = new Vector(new Point3D(2,3,4));
        assertEquals(one,onemore);
    }

    @Test
    void toStringTest() {
    }

    @org.junit.jupiter.api.Test
    void scale() {
    }

    @org.junit.jupiter.api.Test
    void crossProduct() {
    }

    @org.junit.jupiter.api.Test
    void subtractVector() {
    }

    @org.junit.jupiter.api.Test
    void addVector() {
    }

    @org.junit.jupiter.api.Test
    void vectorSize() {
    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
    }

    @org.junit.jupiter.api.Test
    void normalize() {
    }

    @org.junit.jupiter.api.Test
    void getNormal() {
    }

}