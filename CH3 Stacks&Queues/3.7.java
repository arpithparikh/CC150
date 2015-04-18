//cats and dogs,
public class Solution{
	private int order;
	protected String name;
	public Animal(String n){
		n = name;
	}
	public void setOrder(int ord){
		ord = order;
	}
	public int getOrder(){
		return order;
	}
	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder;
	}
	public class AnimalQueue{
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		public void enqueue(Animal a){
			a.setOrder(order);
			order++;
			if( a instanceof Dog)
				dogs.addList((Dog) a);
			else if(a instanceof Cat)
				cats.addList((Cat) a);
		}
		public Animal dequeueAny(){
			if(dogs.size()==0)
				return dequeueCats();
			else if(cats.size()==0)
				return dequeueDogs();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat))
			return dequeueDogs();
		else return dequeueCats();
	}
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	public dequeueCats(){
		return cats.poll();
	}
	public class Dog extends Animal{
		public Dog(String n) {super(n);}
	}
	public class Cat extends Animal{
		public Cat(String n){super(n);}
	}
	}
}