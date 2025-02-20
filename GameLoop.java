public class GameLoop {
    public void updateNeeds(NeedSubject subject){
        decreaseHunger(subject);
        decreaseThirst(subject);
    }
    public void decreaseHunger(NeedSubject subject) {
        int newLevel = subject.getHungerLevel() - 5;
        subject.setHungerLevel(newLevel);
    }
    public void decreaseThirst (NeedSubject subject){
        int newLevel = subject.getThirstLevel() - 5;
        subject.setThirstLevel(newLevel);
    }
}
