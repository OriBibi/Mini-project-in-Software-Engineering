package primitives;

import java.util.Objects;

public class Point3D extends Point2D  {

    protected Coordinate z;

    // ***************** Constructors ********************** //

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.setZ(z);
    }
    public Point3D(Point3D other) {
        this.setX(other.getX());
        this.setY(other.getY());
      this.  setZ(other.getZ());
    }
    public Point3D() {
        super();
        this.setZ(Coordinate.ZERO);
    }
    public Point3D(double x,double y, double z){
        super(x, y);
        this.setZ(new Coordinate(z));
    }
    // ***************** Operations ******************** //

    public Coordinate getZ() {//////////////////////////////////////////////////
        return new Coordinate(z);
    }
    public void setZ(Coordinate z) {
        this.z = new Coordinate(z);
    }
    @Override
    public String toString() {
        String str= super.toString();
        return "Point3D{" + str.substring(8,str.length()-1)+
                ", z=" + Math.abs(getZ().get()*10000)/10000+
                '}';
    }
    public static double distance(Point3D point1, Point3D point2)
    {
        double x1 = point1.getX().get();
        double y1 = point1.getY().get();
        double z1 = point1.getZ().get();
        double x2 = point2.getX().get();
        double y2 = point2.getY().get();
        double z2 = point2.getZ().get();
        return Math.sqrt(Util.uadd
                (Util.uadd(Util.uscale
                                (Util.usubtract(x1,x2),Util.usubtract(x1,x2)), Util.uscale(Util.usubtract(y1,y2),Util.usubtract(y1,y2)))
                        ,Util.uscale(Util.usubtract(z1,z2),Util.usubtract(z1,z2))));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null) return false;
        if (!(o instanceof Point3D)) return false;
        if(!super.equals((Point2D)o)) return false;
        Point3D point3D = (Point3D) o;
        return getZ().equals(point3D.getZ());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getZ());
    }
public Point3D addVector(Vector v)
{
    return new  Point3D(this.getX().add(v.getHead().getX()),
            this.getY().add(v.getHead().getY()),
            this.getZ().add(v.getHead().getZ()));
}

}

