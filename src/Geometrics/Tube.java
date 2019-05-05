package Geometrics;

import primitives.Ray;


public class Tube extends RadialGeometry {

    protected Ray ray;

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
