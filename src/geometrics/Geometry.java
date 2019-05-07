package geometrics;

import primitives.*;

import java.awt.*;
import java.util.ArrayList;

public abstract class  Geometry {


    public Color geoColor;
    public abstract ArrayList<Point3D> findIntersections( Ray ray);

}
