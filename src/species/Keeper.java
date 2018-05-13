package species;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import animaltypes.AnimalType;

public class Keeper {
	private static int num = 0;
	private final int id;
	private String name;
	private Set<Class<?extends AnimalType>> animaltypelist;
	private Set<Animal> animals;
	
	public Keeper(String name) {
		super();
		this.id = num++;
		this.name = name;
		this.animaltypelist = new HashSet<Class<?extends AnimalType>>();
		this.animals = new HashSet<Animal>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Class<? extends AnimalType>> getAnimaltypelist() {
		return animaltypelist;
	}
	public boolean addAnimal(Animal animal) {
		if(animals.size() >= 10) {
			return false;
		}
		List<Class<?>> types = Arrays.asList(animal.getClass().getInterfaces());
		if(types.stream().allMatch(x->animaltypelist.stream().anyMatch(y->y.getSimpleName().equalsIgnoreCase(x.getSimpleName())))){
			animals.add(animal);
			return true;
		}else {
			return false;
		}
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	@Override
	public String toString() {
		return "Keeper [id=" + id + ", name=" + name + ", animaltypelist="
				+ animaltypelist + ", animals=" + animals + "]";
	}
	
}
