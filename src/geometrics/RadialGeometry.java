package geometrics;
import primitives.Point3D;
import primitives.Ray;

import java.awt.*;
import java.util.List;


public abstract class RadialGeometry extends Geometry {
    protected Color geocolor;
    protected double _radius;
    public abstract List<Point3D> findIntersections(Ray ray);
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }
    public RadialGeometry(RadialGeometry radialGeometry) {
        this._radius =radialGeometry.get_radius();
    }
    public double get_radius() {
        return _radius;
    }
}
