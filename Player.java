class Player extends Subject {
    private Position position;

    public Player(Position startPosition) {
        this.position = startPosition;
    }

    // Move the player to a new position and notify observers.
    public void move(Position newPosition) {
        // Only notify if the player has actually moved.
        if (!newPosition.equals(position)) {
            this.position = newPosition;
            notifyObservers(newPosition);
        }
    }

    public Position getPosition() {
        return position;
    }
}
