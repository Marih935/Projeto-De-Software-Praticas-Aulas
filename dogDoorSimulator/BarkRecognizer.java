package dogDoorSimulator;

public class BarkRecognizer {
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
