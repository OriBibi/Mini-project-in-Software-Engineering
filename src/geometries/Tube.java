package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

public class Tube extends RadialGeometry {

    protected Ray ray;
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // To be implemented
        return null;
    }
    public Tube(double _radius, Ray ray) {
        super(_radius);
        this.ray = ray;

    }
    public Tube(RadialGeometry radialGeometry, Ray ray) {
        super(radialGeometry);
        this.ray = ray;
    }
    public Ray getRay() {
        return ray;
    }
}
