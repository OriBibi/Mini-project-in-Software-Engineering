package primitives;

public class Ray {
    private Vector vector;
    private  Point3D startPoint;

    public Ray(Vector vector, Point3D startPoint) {
        this.vector = vector;
        this.startPoint = startPoint;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Point3D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point3D startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public String toString() {
        return "Ray{" +
                "\nvector=" + vector +
                ",\n startPoint=" + startPoint +
                '}';
    }
}
