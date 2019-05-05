package Geometrics;

import primitives.Ray;

public class Cylinder extends Tube {

    protected Double hight;

    public Cylinder(double _radius, Ray ray, Double hight) {
        super(_radius, ray);
        this.hight = hight;
    }

    public Cylinder(RadialGeometry radialGeometry, Ray ray, Double hight) {
        super(radialGeometry, ray);
        this.hight = hight;
    }

    public Double getHight() {
        return hight;
    }
}
