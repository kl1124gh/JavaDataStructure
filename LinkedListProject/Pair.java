package github;

public class Pair<S, T> {
    private S x; //first member of pair
    private T y; //second member of pair

    public Pair(){
      x = null;
      y = null;
    }
    
    public Pair(S x, T y) {
        this.x = x;
        this.y = y;
    }

    public void setX(S x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public S getX() {
        return x;
    }

    public T getY() {
        return y;
    }
}
