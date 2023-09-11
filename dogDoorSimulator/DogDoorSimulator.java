package dogDoorSimulator;

import java.util.ArrayList;
import java.util.List;

class Bark {
    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public boolean equals(Bark otherBark) {
        if (otherBark == null) return false;
        return this.sound.equalsIgnoreCase(otherBark.getSound());
    }
}

class DogDoor {
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

class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("BarkRecognizer: Heard a '" + bark.getSound() + "'");

        if (door.getAllowedBarks().stream().anyMatch(allowed -> allowed.equals(bark))) {
            if (!door.isOpen()) {
                door.open();
            }if (door.isOpen()) {
                door.close();
            }else {
            System.out.println("This dog is not allowed.");
            }    
        }
    }
}



class Remote {
    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
        }
    }
}

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("rowlf"));
        door.addAllowedBark(new Bark("rooowlf"));
        door.addAllowedBark(new Bark("rawlf"));
        door.addAllowedBark(new Bark("woof"));
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Bruce starts barking.");
        recognizer.recognize(new Bark("rowlf"));

        System.out.println("\nBruce has gone outside...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println("\nBruce all done...");
        System.out.println("...but he's stuck outside!");

        // Simulate the hardware hearing a bark (not Bruce!)
        Bark smallDogBark = new Bark("yip");
        System.out.println("Bitsie starts barking.");
        recognizer.recognize(smallDogBark);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Simulate the hardware hearing a bark again
        System.out.println("\nBruce starts barking.");
        recognizer.recognize(new Bark("rooowlf"));

        System.out.println("\nBruce's back inside...");
    }
}
