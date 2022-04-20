package Weather;

import java.util.List;
import java.util.ArrayList;

import Flyable.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable obs : observers) {
            obs.updateConditions();
        }
    }
}