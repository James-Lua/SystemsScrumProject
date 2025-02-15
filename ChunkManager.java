import java.util.*;

class ChunkManager implements Observer, Tickable {
    // Map of currently loaded chunks and their ticket counters.
    private Map<Position, LoadedChunk> loadedChunks = new HashMap<>();
    private int renderDistance;         // in screen units
    private Position currentPlayerChunk = new Position(0, 0);
    private final int MAX_TICKET_TICKS = 20;

    // Constants for our tile and screen settings.
    public static final int CHUNK_SIZE = 16;
    public static final int SCREEN_CHUNKS_WIDTH = 4;  // 4 chunks per screen horizontally
    public static final int SCREEN_CHUNKS_HEIGHT = 3; // 3 chunks per screen vertically

    public ChunkManager(int renderDistance) {
        this.renderDistance = Math.max(renderDistance, 1);  // enforce minimum render distance
    }

    // Called when the player moves.
    @Override
    public void update(Position newPosition) {
        currentPlayerChunk = getChunkCoordinate(newPosition);
        System.out.println("moved");
    }

    // Called each tick by the TickManager.
    @Override
    public void tick() {
        // Calculate the desired loaded area based on the player's current chunk.
        Set<Position> desiredArea = getLoadedArea(currentPlayerChunk);

        // For each desired chunk, load or refresh it.
        for (Position coord : desiredArea) {
            if (loadedChunks.containsKey(coord)) {
                loadedChunks.get(coord).refreshTicket(MAX_TICKET_TICKS);
            } else {
                loadChunk(coord);
            }
        }

        // For each loaded chunk outside the desired area, decrement its ticket and unload if needed.
        Iterator<Map.Entry<Position, LoadedChunk>> iter = loadedChunks.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Position, LoadedChunk> entry = iter.next();
            Position coord = entry.getKey();
            if (!desiredArea.contains(coord)) {
                LoadedChunk lc = entry.getValue();
                lc.decrementTicket();
                if (lc.getTicketTicks() <= 0) {
                    lc.getChunk().unload();
                    iter.remove();
                }
            }
        }
    }

    // Convert a world tile position to a chunk coordinate.
    private Position getChunkCoordinate(Position position) {
        int chunkX = (int)Math.floor((double) position.getX() / CHUNK_SIZE);
        int chunkY = (int)Math.floor((double) position.getY() / CHUNK_SIZE);
        return new Position(chunkX, chunkY);
    }

    // Calculate the desired area of loaded chunks based on the player's current chunk.
    private Set<Position> getLoadedArea(Position centerChunk) {
        Set<Position> area = new HashSet<>();
        int totalScreens = (2 * renderDistance) + 1;  // e.g., 9 screens if renderDistance is 4
        int totalWidth = totalScreens * SCREEN_CHUNKS_WIDTH;   // e.g., 9 * 4 = 36 chunks wide
        int totalHeight = totalScreens * SCREEN_CHUNKS_HEIGHT; // e.g., 9 * 3 = 27 chunks high
        int halfWidth = totalWidth / 2;
        int halfHeight = totalHeight / 2;

        for (int x = centerChunk.getX() - halfWidth; x <= centerChunk.getX() + halfWidth; x++) {
            for (int y = centerChunk.getY() - halfHeight; y <= centerChunk.getY() + halfHeight; y++) {
                area.add(new Position(x, y));
            }
        }
        return area;
    }

    // Load a new chunk at the specified coordinate.
    private void loadChunk(Position chunkCoord) {
        Chunk chunk = new Chunk(chunkCoord);
        chunk.load();
        LoadedChunk loadedChunk = new LoadedChunk(chunk, MAX_TICKET_TICKS);
        loadedChunks.put(chunkCoord, loadedChunk);
    }
}