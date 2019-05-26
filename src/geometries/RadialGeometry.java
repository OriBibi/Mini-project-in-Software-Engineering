package geometries;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;

import java.awt.*;
import java.util.List;


public abstract class RadialGeometry extends Geometry {
    protected double _radius;
    public abstract List<Point3D> findIntersections(Ray ray);
    public RadialGeometry() {
        super();
    }
    public RadialGeometry(double _radius, Color color, Material material){
        super(color,material);
        this._radius = _radius;
    }
    public RadialGeometry(double _radius) {
        super();
        this._radius = _radius;
    }
    public RadialGeometry(RadialGeometry radialGeometry) {
        super(radialGeometry);
        this._radius =radialGeometry.get_radius();
    }
    public double get_radius() {
        return _radius;
    }
}
