package dogDoorSimulator;

public class Bark {
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
