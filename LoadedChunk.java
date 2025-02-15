class LoadedChunk {
    private Chunk chunk;
    private int ticketTicks;

    public LoadedChunk(Chunk chunk, int initialTicket) {
        this.chunk = chunk;
        this.ticketTicks = initialTicket;
    }
    // Refresh the ticket (reset to max).
    public void refreshTicket(int maxTicket) {
        this.ticketTicks = maxTicket;
    }
    // Decrement the ticket.
    public void decrementTicket() {
        ticketTicks--;
    }
    public int getTicketTicks() {
        return ticketTicks;
    }
    public Chunk getChunk() {
        return chunk;
    }
}