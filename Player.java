class Player extends Subject {
    private Position position;

    public Player(Position startPosition) {
        this.position = startPosition;
    }

    // Move the player and notify observers.
    public void move(Position newPosition) {
        this.position = newPosition;
        notifyObservers(newPosition);
    }

    public Position getPosition() {
        return position;
    }
}