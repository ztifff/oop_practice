package soundChild;

public class Sound {
    private  String sound;  // Made private for encapsulation

    public Sound(String sound) {
        this.sound = sound;
    }

    public String getSound() {  // Getter method
        return sound;
    }

    public void setSound(String sound) {  // Setter method
        this.sound = sound;
    }
}
