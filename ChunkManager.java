import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ChunkManager implements Observer {
    // Map to hold loaded chunks, keyed by their chunk coordinate.
    private Map<Position, Chunk> loadedChunks = new HashMap<>();
    private int loadDistance; // in chunk units

    // Constant for the size of each chunk (e.g., 16x16 units).
    public static final int CHUNK_SIZE = 16;

    public ChunkManager(int loadDistance) {
        this.loadDistance = loadDistance;
    }

    // Called when the player's position changes.
    @Override
    public void update(Position newPosition) {
        Position currentChunk = getChunkCoordinate(newPosition);
        // Unload chunks that are now out of range.
        Iterator<Position> iterator = loadedChunks.keySet().iterator();
        while (iterator.hasNext()) {
            Position chunkCoord = iterator.next();
            if (distance(chunkCoord, currentChunk) > loadDistance) {
                Chunk chunk = loadedChunks.get(chunkCoord);
                chunk.unload();
                iterator.remove();
            }
        }
        // Load any chunks within the render distance that are not yet loaded.
        for (int dx = -loadDistance; dx <= loadDistance; dx++) {
            for (int dy = -loadDistance; dy <= loadDistance; dy++) {
                Position neighborChunk = new Position(currentChunk.getX() + dx, currentChunk.getY() + dy);
                if (!loadedChunks.containsKey(neighborChunk)) {
                    loadChunk(neighborChunk);
                }
            }
        }
    }

    // Convert a world position to a chunk coordinate.
    private Position getChunkCoordinate(Position position) {
        int chunkX = (int) Math.floor((double) position.getX() / CHUNK_SIZE);
        int chunkY = (int) Math.floor((double) position.getY() / CHUNK_SIZE);
        return new Position(chunkX, chunkY);
    }

    // Load a chunk at the specified chunk coordinate.
    private void loadChunk(Position chunkCoord) {
        Chunk chunk = new Chunk(chunkCoord);
        chunk.load();
        loadedChunks.put(chunkCoord, chunk);
    }

    // Unload a chunk at the specified chunk coordinate.
    private void unloadChunk(Position chunkCoord) {
        Chunk chunk = loadedChunks.get(chunkCoord);
        if (chunk != null) {
            chunk.unload();
            loadedChunks.remove(chunkCoord);
        }
    }

    // Helper method to calculate Manhattan distance between two chunk coordinates.
    private int distance(Position a, Position b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}
