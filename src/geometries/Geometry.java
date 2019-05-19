package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.awt.*;
import java.util.List;

public abstract class  Geometry {


    protected Color geoColor;
    public abstract List<Point3D> findIntersections( Ray ray);

    public void setGeoColor(Color geoColor) {
        this.geoColor = geoColor;
    }

    public Color getGeoColor() {
        return geoColor;
    }
}
