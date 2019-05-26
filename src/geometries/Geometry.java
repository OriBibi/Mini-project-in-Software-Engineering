package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;

import java.awt.*;
import java.util.List;

public abstract class  Geometry {

    private Material material;



    private Color emmission;
    Geometry(){
        setMaterial(new Material());
        setEmmission(Color.white);
    }
    Geometry(Geometry g){
        setMaterial(g.getMaterial());
        setEmmission(g.getEmmission());
    }
    Geometry(Color color,Material material){
        setMaterial(material);
        setEmmission(color);
    }
    public abstract List<Point3D> findIntersections( Ray ray);
    public Color getEmmission() {
        return emmission;
    }
    public void setEmmission(Color emmission) {
        this.emmission = emmission;
    }
    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
}
