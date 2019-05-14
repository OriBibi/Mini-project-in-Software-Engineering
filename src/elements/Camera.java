package elements;
import primitives.*;


public class Camera {

    // ***************** variables ********************** //

    protected Point3D p0;
    protected Vector vUp;
    protected Vector vRight;
    protected Vector vToward;


    // ***************** Constructors ********************** //

    public Camera(Point3D sourcePoint, Vector vUp, Vector vRight, Vector vToward) {
        this.p0 = sourcePoint;
        this.vUp = vUp;
        this.vRight = vRight;
        this.vToward = vToward;
    }
    public Camera(Point3D sourcePoint) {
        this.p0 = sourcePoint;
        vUp=new Vector(new Coordinate(1.0),Coordinate.ZERO,Coordinate.ZERO);
        vToward=new Vector(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(-1.0));
        vRight=vUp.crossProduct(vToward);
    }
    public Camera(Point3D point,Vector vUp, Vector vToward) {
        this.vUp = vUp;
        this.vToward = vToward;
        this.vRight=vUp.crossProduct(vToward);
        this.p0=point;
    }
    public Camera() {
        p0= new Point3D(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(10.0));
        vUp=new Vector(new Coordinate(1.0),Coordinate.ZERO,Coordinate.ZERO);
        vToward=new Vector(Coordinate.ZERO,Coordinate.ZERO,new Coordinate(-1.0));
        vRight=vUp.crossProduct(vToward);

    }

    // ***************** Getters/Setters ********************** //
    public Point3D getp0() {
        return p0;
    }
    public Vector getvUp() {
        return vUp;
    }
    public Vector getvRight() {
        return vRight;
    }
    public Vector getvToward() {
        return vToward;
    }
    public void setP0(Point3D sourcePoint) {
        this.p0 = sourcePoint;
    }
    public void setvUp(Vector vUp) {
        this.vUp = vUp;
        vRight=vUp.crossProduct(vToward);

    }
    public void setvToward(Vector vToward) {
        this.vToward = vToward;
        vRight=vToward.crossProduct(vUp);
    }
    // ***************** Administration ********************** //
    public String toString(){
        return "vToward: "   + vToward + "\n" +
                "vUp: "   + vUp + "\n" +
                "vRight:" + vRight + ".";
    }    // ***************** Operations ******************** //
    public Ray constructRayThroughPixel (int Nx, int Ny, double i, double j, double screenDist, double screenWidth, double screenHeight)
    {
        Vector vToward = new Vector(getvToward());
        Vector vRight = new Vector(getvRight());
        Vector vUP = new Vector(getvUp());

        vToward.normalize();
        vToward.scale(screenDist);
        Point3D Pc = getp0().addVector(vToward);

        vToward.normalize();
        vRight.normalize();
        vUP.normalize();


        // Calculating x-y ratios
        double Rx = screenWidth  / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        double y_j = (j - (Ny / 2.0)) * Ry + (Ry / 2.0);
        double x_i = (i - (Nx / 2.0)) * Rx + (Rx / 2.0);

        vRight.scale(x_i);
        vUP.scale(y_j);

        Vector deltaV = vRight.subtractVector(vUP);

        Point3D p_ij = Pc.addVector(deltaV);

        Vector V_ij = new Vector(getp0(), p_ij);
        V_ij.normalize();
        // returning the constructed ray between P0 and the intersection point
        return new Ray( V_ij,getp0());
    }
}

