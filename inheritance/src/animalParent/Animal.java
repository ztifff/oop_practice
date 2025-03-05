package animalParent;

import soundChild.Sound;

public class Animal {
    private  Sound sound;  // Encapsulated Sound object

    public Animal(Sound sound) {
        this.sound = sound;
    }

    protected Sound getSound() {
        return sound;
    }
    public void makeSound() {
        System.out.println("Animal makes sound: " + sound.getSound());
    }
}
