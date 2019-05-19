package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.awt.*;
import java.util.List;

public abstract class  Geometry {


    private Color emmission;
    Geometry(){
        setEmmission(Color.white);
    }
    Geometry(Geometry g){
        setEmmission(g.getEmmission());
    }
    Geometry(Color color){
        setEmmission(color);
    }
    public abstract List<Point3D> findIntersections( Ray ray);
    public Color getEmmission() {
        return emmission;
    }

    public void setEmmission(Color emmission) {
        this.emmission = emmission;
    }
}
