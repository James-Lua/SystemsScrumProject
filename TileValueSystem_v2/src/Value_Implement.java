public class Value_Implement implements Value {
    private final Tile tile;  // Tile represents the current tile the character is on
    private int velocity;     // The velocity associated with the entity's movement

    // Constructor to initialize the tile and default velocity
    public Value_Implement(Tile tile) {
        this.tile = tile;
        this.velocity = 0;  // Default velocity is set to 0
    }

    @Override
    public int velocity() {
        return this.velocity;  // Return the current velocity
    }

    @Override
    public Tile getTile() {
        return this.tile;  // Return the tile the entity is on
    }

    // Setter for velocity (in case you want to modify it later)
    public int setVelocity(int velocity) {
        this.velocity = velocity;
        return velocity;
    }
}