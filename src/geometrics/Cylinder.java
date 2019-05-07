package geometrics;
import primitives.Point3D;
import primitives.Ray;
import java.util.List;


public class Cylinder extends Tube {

    protected Double hight;


    public Cylinder(double _radius, Ray ray, Double hight) {
        super(_radius, ray);
        this.hight = hight;
    }
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // To be implemented
        return null;
    }
    public Cylinder(RadialGeometry radialGeometry, Ray ray, Double hight) {
        super(radialGeometry, ray);
        this.hight = hight;
    }

    public Double getHight() {
        return hight;
    }
}
