class Chunk {
    private Position position;
    
    public Chunk(Position position) {
        this.position = position;
    }
    
    // Load chunk data (could be done asynchronously in a real-world scenario).
    public void load() {
        // Simulate chunk loading
        System.out.println("Loading chunk at " + position);
    }
    
    // Unload the chunk and free resources.
    public void unload() {
        // Simulate chunk unloading
        System.out.println("Unloading chunk at " + position);
    }
    
    public Position getPosition() {
        return position;
    }
}
