import java.util.ArrayList;
import java.util.List;

class TickManager {
    private List<Tickable> tickables = new ArrayList<>();
    private final long tickIntervalMillis;

    public TickManager(long tickIntervalMillis) {
        this.tickIntervalMillis = tickIntervalMillis;
    }

    public void register(Tickable tickable) {
        tickables.add(tickable);
    }

    public void run() {
        while (true) {
            long start = System.currentTimeMillis();
            for (Tickable tickable : tickables) {
                tickable.tick();
            }
            long elapsed = System.currentTimeMillis() - start;
            long sleepTime = tickIntervalMillis - elapsed;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}