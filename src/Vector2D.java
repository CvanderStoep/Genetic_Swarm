public class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double dot (Vector2D that) {
        return this.getX() * that.getX() + this.getY() * that.getY();
    }

    public double magnitude () {
        return this.dot(this);
    }

    public double distanceTo (Vector2D that) {
        return this.minus(that).magnitude();
    }

    public Vector2D scale (double factor) {
        return new Vector2D(factor * this.getX(), factor * this.getY());
    }

    public Vector2D minus (Vector2D that) {
        return this.plus(that.scale(-1));
    }

    public Vector2D plus (Vector2D that) {
        return new Vector2D(this.getX() + that.getX(), this.getY() + that.getY());
    }
}