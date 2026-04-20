// Noah Thompson
// 20 April 2026
// Dog.java

public class Dog extends Mammal implements Animal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void makeSound(){
        System.out.println("Bark");
    }
}