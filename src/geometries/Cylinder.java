package geometries;
import primitives.Point3D;
import primitives.Ray;
import java.util.List;

// This class not in use.
public class Cylinder extends Tube {

    protected Double height;


    public Cylinder(double _radius, Ray ray, Double height) {
        super(_radius, ray);
        this.height = height;
    }
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // To be implemented
        return null;
    }
    public Cylinder(RadialGeometry radialGeometry, Ray ray, Double height) {
        super(radialGeometry, ray);
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }
}
