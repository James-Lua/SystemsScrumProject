import java.util.Objects;

class Position {
    private final int x;
    private final int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    // Override equals and hashCode so that Position can be used as a key in a HashMap.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
