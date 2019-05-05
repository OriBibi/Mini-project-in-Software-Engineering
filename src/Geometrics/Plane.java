package Geometrics;

import primitives.Point3D;
import primitives.Vector;

public class Plane {
    protected Point3D point;
    protected Vector orthogonalVector;
    public Plane(Point3D point, Vector orthogonalVector) {
        this.point = point;
        this.orthogonalVector = orthogonalVector;
    }
    public Point3D getPoint() {
        return point;
    }
    public Vector getOrthogonalVector() {
        return orthogonalVector;
    }
}
