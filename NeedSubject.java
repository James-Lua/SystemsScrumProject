import java.util.ArrayList;
import java.util.List;

public class NeedSubject {
    private List<NeedObserver> observers = new ArrayList<>();
    private int hungerLevel = 100;
    private int thirstLevel = 100;

    public void addObserver(NeedObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NeedObserver observer) {
        observers.remove(observer);
    }

    public void setHungerLevel(int level) {
        this.hungerLevel = Math.max(0, Math.min(100, level));
        notifyObservers("hunger", hungerLevel);
    }

    public void setThirstLevel(int level) {
        this.thirstLevel = Math.max(0, Math.min(100, level));
        notifyObservers("thirst", thirstLevel);
    }
    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    private void notifyObservers(String needType, int level) {
        for (NeedObserver observer : observers) {
            observer.onNeedChanged(needType, level);
        }
    }
}