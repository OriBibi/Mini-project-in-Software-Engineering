package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

// This class not in use.

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
    public Vector getNormal(Point3D point){
        return new Vector(1,1,1);
    }
    public Ray getRay() {
        return ray;
    }
}
