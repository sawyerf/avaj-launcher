package weather;

import java.util.List;
import java.util.ArrayList;

import flyable.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public Boolean isEmpty() {
        return (observers.size() == 0);
    }

    protected void conditionsChanged() {
        for (Flyable obs : new ArrayList<Flyable>(observers)) {
            obs.updateConditions();
        }
    }
}