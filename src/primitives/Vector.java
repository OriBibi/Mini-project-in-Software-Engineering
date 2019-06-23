package primitives;

import java.util.Objects;
public class Vector
{
    protected Point3D  head;
    // ***************** Constructors ********************** //

    public Vector(Point3D head) {
        this.setHead(head);
    }
    public Vector(Point3D pt1, Point3D pt2) {

        setHead(new Point3D(
                pt2.getX().subtract(pt1.getX()),
                pt2.getY().subtract(pt1.getY()),
                pt2.getZ().subtract(pt1.getZ())));
    }
    public Vector() {
    this.setHead(new Point3D(0,0,-1));
    }
    public Vector(Coordinate x,Coordinate y, Coordinate z)
    {
        head= new Point3D(x,y,z);
    }
    public  Vector(Vector vector){ this.setHead(vector.getHead());}
    public Vector(double x,double y,double z){
        head=new Point3D(new Coordinate(x),new Coordinate(y),new Coordinate(z));
    }
    // ***************** Getter\Setter ********************** //

    public Point3D getHead() {
        return (new Point3D(head));
    }

    public void setHead(Point3D head) {
        this.head = (new Point3D(head));
    }

    // ***************** Operations ******************** //

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + this.getHead().toString().substring(7) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return getHead().equals(vector.getHead());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }
    /*************************************************
     * FUNCTION:
      scale
     * PARAMETERS:
      double
     * RETURN VALUE:
      none
     * MEANING:
      This function scaling the vector by miltiply each component by the scaling factor
     **************************************************/
    public void scale(double scalingFactor){

        this.head.setX(new Coordinate(
               head.getX().scale(scalingFactor)));

        this.head.setY(new Coordinate(
                head.getY().scale(scalingFactor)));

        this.head.setZ(new Coordinate(
                head.getZ().scale(scalingFactor)));
    }
    /*************************************************
     * FUNCTION
     * crossProduct
     * PARAMETERS
     * vector
     * RETURN VALUE
     * vector
     * MEANING
     * This function aplly the cross product of two 3D vectors
     **************************************************/
    public Vector crossProduct (Vector vector){

        double x1 = this.getHead().getX().get();
        double y1 = this.getHead().getY().get();
        double z1 = this.getHead().getZ().get();

        double x2 = vector.getHead().getX().get();
        double y2 = vector.getHead().getY().get();
        double z2 = vector.getHead().getZ().get();

        return new Vector(new Point3D(
                new Coordinate(Util.usubtract(Util.uscale(y1 ,z2), Util.uscale( z1 , y2))),
                new Coordinate(Util.usubtract(Util.uscale(z1, x2),Util.uscale( x1, z2))),
                new Coordinate(Util.usubtract(Util.uscale(x1 , y2),Util.uscale(y1 , x2)))));

    }
    public Vector subtractVector(Vector vector)
    {


        return new Vector(new Point3D(
                this.getHead().getX().subtract(vector.getHead().getX()),
                this.getHead().getY().subtract(vector.getHead().getY()),
                this.getHead().getZ().subtract(vector.getHead().getZ())));
    }
    public Vector addVector(Vector vector)
    {


        return new Vector(new Point3D(
                this.getHead().getX().add(vector.getHead().getX()),
                this.getHead().getY().add(vector.getHead().getY()),
                this.getHead().getZ().add(vector.getHead().getZ())));
    }
    public double vectorSize()
    {
        double x1 = this.getHead().getX().get();
        double y1 = this.getHead().getY().get();
        double z1 = this.getHead().getZ().get();
        return Math.sqrt(Util.uadd(Util.uadd(Util.uscale(x1,x1),Util.uscale(y1,y1)),Util.uscale(z1,z1)));
    }
    public double dotProduct(Vector vector) {

        double x1 = this.getHead().getX().get();
        double y1 = this.getHead().getY().get();
        double z1 = this.getHead().getZ().get();

        double x2 = vector.getHead().getX().get();
        double y2 = vector.getHead().getY().get();
        double z2 = vector.getHead().getZ().get();

        return Util.uadd(Util.uadd(Util.uscale(x1,x2),Util.uscale(y1,y2)),Util.uscale(z1,z2));

    }
    public void normalize()
    {
    double length = this.vectorSize();

    if (length == 0)
        throw new ArithmeticException("you can't divide by zero");
  this.setHead(new Point3D(
          new Coordinate(this.getHead().getX().get()/length),
          new Coordinate(this.getHead().getY().get()/length),
          new Coordinate(this.getHead().getZ().get()/length)
  ));
}

    public Vector getNormal(){
        Vector v=new Vector(this.getHead());
        v.normalize();
        return v;
    }
}
