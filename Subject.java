abstract class Subject {
    // Encapsulated list of observers.
    private List<Observer> observers = new ArrayList<>();

    // Register a new observer.
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer.
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers with the new position.
    protected void notifyObservers(Position position) {
        for (Observer observer : observers) {
            observer.update(position);
        }
    }
}
