package Geometrics;

import primitives.*;

public class Sphere extends RadialGeometry {

    protected Point3D middlePoint;

    public Sphere(double _radius, Point3D middlePoint) {
        super(_radius);
        this.middlePoint = middlePoint;
    }

    public Sphere(RadialGeometry radialGeometry, Point3D middlePoint) {
        super(radialGeometry);
        this.middlePoint = middlePoint;
    }
    public Vector getNormal(Point3D point) {
        Vector vector = new Vector(middlePoint, point);
        vector.normalize();
        return vector;
    }
    public Point3D getMiddlePoint() {
        return middlePoint;
    }
}

