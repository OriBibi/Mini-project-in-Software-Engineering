package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.List;

public abstract class  Geometry {

    // ***************** variables ************************* //

    private Material material;//everything that wants to be a geometry that has to be made of a particular material.
    private Color emmission;//The light that geometry produces

    // ***************** Constructors ********************** //

    Geometry(){
        setMaterial(new Material());
        setEmmission(Color.black);
    }
    Geometry(Geometry g){
        setMaterial(g.getMaterial());
        setEmmission(g.getEmmission());
    }
    Geometry(Color color,Material material){
        setMaterial(material);
        setEmmission(color);
    }

    // ***************** Getters/Setters ******************* //

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

    // ***************** Operations ******************** //

    public abstract List<Point3D> findIntersections( Ray ray);//All geometries must contain this function if they want to be visible in space
    public abstract Vector getNormal(Point3D point);//You must know Normal at any point in geometry for many uses, such as for correct calculation of lighting


}
