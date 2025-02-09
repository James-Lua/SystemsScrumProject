public class GameSimulation {
    public static void main(String[] args) {
        // Initialize player at position (0, 0)
        Player player = new Player(new Position(0, 0));
        
        // Initialize ChunkManager with a load distance of 2 chunks.
        ChunkManager chunkManager = new ChunkManager(2);
        
        // Register the ChunkManager as an observer of the player.
        player.addObserver(chunkManager);
        
        // Simulate player movement.
        player.move(new Position(20, 20)); // Should trigger chunk loading/unloading
        player.move(new Position(40, 40)); // Another movement triggering updates
    }
}
