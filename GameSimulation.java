public class GameSimulation {
    public static void main(String[] args) {
        // Initialize the player at tile position (0, 0).
        Player player = new Player(new Position(0, 0));

        // Create a ChunkManager with a renderDistance of 4 screens.
        ChunkManager chunkManager = new ChunkManager(1);

        // Register the ChunkManager as an observer of the player.
        player.addObserver(chunkManager);

        // Create a TickManager that ticks every 50ms (20 ticks per second).
        TickManager tickManager = new TickManager(50);
        tickManager.register(chunkManager);

        // Start the tick loop in a separate thread.
        new Thread(tickManager::run).start();

        // Simulate dynamic walking:
        // The player will move one tile per second in a diagonal direction.
        // This gradual movement simulates realistic walking and will eventually cause the player to cross chunk boundaries.
        int totalSteps = 80; // total number of tiles to move
        int dx = 1;          // move right 1 tile per step
        int dy = 0;          // move down 1 tile per step

        for (int i = 0; i < totalSteps; i++) {
            // Get the current position and compute the new position.
            Position current = player.getPosition();
            Position newPosition = new Position(current.getX() + dx, current.getY() + dy);

            // Move the player.
            player.move(newPosition);
            System.out.println(newPosition);

            // Sleep for 1 second between moves.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}