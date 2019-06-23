package geometries;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class Plane extends Geometry implements FlatGeometry {

    // ***************** variables ************************* //

    private Point3D point;
    private Vector orthogonalVector;

    // ***************** Constructors ********************** //

    public Plane(Point3D point, Vector orthogonalVector) {
        super();
        this.point = point;
        this.orthogonalVector = orthogonalVector;
    }
    public Plane( Color color,Point3D point, Vector orthogonalVector){
        this.setEmmission(color);
        this.point=point;
        this.orthogonalVector=orthogonalVector;
    }
    public Plane(Material material, Color color, Point3D point, Vector orthogonalVector){
        super(color,material);
        this.point=point;
        this.orthogonalVector=orthogonalVector;
    }
    public Plane(Plane plane){
        super(plane.getEmmission(),plane.getMaterial());
        this.point=plane.point;
        this.orthogonalVector=plane.orthogonalVector;
    }

    // ************* Getters/Setters ****************** //

    public Point3D getPoint() {
        return point;
    }
    public Vector getOrthogonalVector() {
        return orthogonalVector;
    }
    // ***************** Operations ******************** //

    public Vector getNormal(Point3D point){
        return orthogonalVector;
    }
    @Override
    /*************************************************
     * FUNCTION:
     FindIntersections
     * PARAMETERS:
     ray
     * RETURN VALUE:
     List<Point3D>
     * MEANING:
     This functions computes a all the intersections of specific ray with the plane.
     /*********************************************/
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersectionPoints = new ArrayList<>();
        Point3D P0 = ray.getStartPoint();
        Point3D Q0 = this.getPoint();
        Vector N = this.getOrthogonalVector();
        Vector V = ray.getVector();

        if(N.dotProduct(V)==0)
        {
            // ray.getDirection() is parralel to the plane
            // no intersections points
            return intersectionPoints;
        }

        Vector u = new Vector(Q0, P0);
        double t = (N.dotProduct(u)*-1 ) / N.dotProduct(V);

        if (t >= 0) {
            V.scale(t);
            Point3D p = P0.addVector(V);
            intersectionPoints.add(p);
        }
        return intersectionPoints;
    }

}