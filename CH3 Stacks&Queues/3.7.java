// An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out"
// basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select
// whether they would prefer a dog or a cat(and will receive the oldest animal of that type). They cannot select which specific animal thet would
// like. Create the data structures to maintain this system and implement operation such as an enqueue, dequeueAny, dequeueDog and dequeueCats. You
// may use built-in LinkedList data structure
package CC150;
import java.util.Queue;
import java.util.LinkedList;

class Animal{
	private int timestamp;
	private String type;
	public Animal(int val, String animalType){
		timestamp = val;
		type = animalType;
	}

	public int getTimestamp(){
		return timestamp;
	}

	public String getAnimalType(){
		return type;
	}
}

class Dog extends Animal{
	public Dog(int val, String animalType){
		super(val,animalType);
	}
}

class Cat extends Animal{
	public Cat(int val, String animalType){
		super(val,animalType);
	}
}



class AnimalShelter{

	Queue<Dog> dogs;
	Queue<Cat> cats;
	public AnimalShelter(){
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
	}

	public void enqueue(Animal animal){
		if( animal.getAnimalType().equals("Dog")){
			dogs.offer((Dog)animal);
		}else if( animal.getAnimalType().equals("Cat")){
			cats.offer((Cat)animal);
		}
	}

	public Animal dequeueAny(){
		if( dogs.size() == 0 && cats.size() != 0 ){
			return cats.poll();
		}
		if( cats.size() == 0 && dogs.size() != 0 ){
			return dogs.poll();
		}
		if( cats.size() != 0 && dogs.size() != 0){
			return dogs.peek().getTimestamp() > cats.peek().getTimestamp() ? cats.poll() : dogs.poll();
		}
		
		return null;
	}

	public Dog dequeueDog(){
		if( dogs.size() != 0 ){
			return dogs.poll();
		}
		return null;
	}

	public Cat dequeueCat(){
		if( cats.size() != 0 ){
			return cats.poll();
		}
		return null;
	}


}

public class Solution {
	public static void main(String[] args) {	
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog(1,"Dog"));
		shelter.enqueue(new Dog(2,"Dog"));
		shelter.enqueue(new Dog(3,"Dog"));
		shelter.enqueue(new Cat(4,"Cat"));
		shelter.enqueue(new Cat(5,"Cat"));
		shelter.enqueue(new Cat(6,"Cat"));
		shelter.enqueue(new Dog(7,"Dog"));
		shelter.enqueue(new Cat(8,"Cat"));		
		Animal resultAnimal = shelter.dequeueAny();
		System.out.println(" Dequeue Any Result: " + resultAnimal.getAnimalType() + " " + "id #" + resultAnimal.getTimestamp());
		resultAnimal = shelter.dequeueAny();
		System.out.println(" Dequeue Any Result: " + resultAnimal.getAnimalType() + " " + "id #" + resultAnimal.getTimestamp());
		Dog resultDog = shelter.dequeueDog();
		System.out.println(" Dequeue Dog Result: " + resultDog.getAnimalType() + " " + "id #" + resultDog.getTimestamp());
		Cat resultCat = shelter.dequeueCat();
		System.out.println(" Dequeue Cat Result: " + resultCat.getAnimalType() + " " + "id #" + resultCat.getTimestamp());
		resultDog = shelter.dequeueDog();
		System.out.println(" Dequeue Dog Result: " + resultDog.getAnimalType() + " " + "id #" + resultDog.getTimestamp());	
		resultAnimal = shelter.dequeueAny();
		System.out.println(" Dequeue Any Result: " + resultAnimal.getAnimalType() + " " + "id #" + resultAnimal.getTimestamp());
		resultAnimal = shelter.dequeueAny();
		System.out.println(" Dequeue Any Result: " + resultAnimal.getAnimalType() + " " + "id #" + resultAnimal.getTimestamp());
	}		
}