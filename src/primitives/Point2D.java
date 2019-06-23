package primitives;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")
public class Point2D {
    private Coordinate x;
    private Coordinate y;
    public Point2D(double x,double y){

        this.setX(new Coordinate(x));
        this.setY(new Coordinate(y));

    }
    public Point2D(Point2D other) {
        this.setX(other.getX());
        this.setY(other.getY());
    }
    public Point2D(Coordinate x,Coordinate y) {
        this.setX(x);
        this.setY(y);
    }

    public Point2D() {
        setX(Coordinate.ZERO);
        setY(Coordinate.ZERO);

    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + getX().get()+
                ", y=" + getY().get() +
                '}';
    }

    public Coordinate getX() {
        return (new Coordinate(x));
    }

    public Coordinate getY() {
        return (new Coordinate(y)) ;
    }

    public void setY(Coordinate y) {
        this.y = new Coordinate(y);
    }

    public void setX(Coordinate x) {
        this.x = new Coordinate(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return getX().equals(point2D.getX()) &&
                getY().equals(point2D.getY());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
