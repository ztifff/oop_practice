package animalParent;

import soundChild.Sound;

public class Cat extends Animal {
    public Cat() {
        super(new Sound("Meow! Meow!"));
    }

    @Override
    public void makeSound() {
        System.out.println("Cat says: " + getSound().getSound());
    }
}
