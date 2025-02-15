class Chunk {
    private Position position;

    public Chunk(Position position) {
        this.position = position;
    }

    // Called when the chunk is loaded.
    public void load() {
        System.out.println("Loaded chunk at " + position);
    }

    // Called when the chunk is unloaded.
    public void unload() {
        System.out.println("Unloaded chunk at " + position);
    }

    public Position getPosition() {
        return position;
    }
}