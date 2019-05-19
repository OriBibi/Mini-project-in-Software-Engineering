package primitives;

import java.util.Objects;

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
                "\nvector=" + vector.toString() +
                ",\n startPoint=" + startPoint.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return vector.equals(ray.vector) &&
                startPoint.equals(ray.startPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector, startPoint);
    }
}
