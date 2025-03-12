package animalParent;

import soundChild.Sound;

public class Dog extends Animal {
    public Dog() {
        super(new Sound("Woof! Woof!"));
    }

    
    public void makeSound() {
        System.out.println("Dog says: " + getSound().getSound());
    }
}
