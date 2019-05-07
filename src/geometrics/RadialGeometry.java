package geometrics;

public abstract class RadialGeometry extends Geometry {

    protected double _radius;
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
