package dogDoorSimulator;

import java.util.ArrayList;
import java.util.List;

public class DogDoor {
    private boolean open;
    private List<Bark> allowedBarks;

    public DogDoor() {
        this.open = false;
        this.allowedBarks = new ArrayList<>();
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        if (open) {
            return true;
        } else {
            return false;
        }
    }

    public void addAllowedBark(Bark bark) {
        allowedBarks.add(bark);
    }

    public List<Bark> getAllowedBarks() {
        return allowedBarks;
    }
}
