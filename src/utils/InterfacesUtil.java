package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import animaltypes.AnimalType;
import animaltypes.Aquatic;
import animaltypes.Avian;
import animaltypes.Insect;
import animaltypes.Mammal;
import animaltypes.Reptile;
import species.Animal;
import species.ImplementInsectAquatic;
import species.ImplementMammalAvian;
import species.ImplementMammal;
import species.ImplementReptileAquatic;
import species.ImplementInsectAvian;
import species.ImplementMammalAquatic;
import species.ImplementInsect;
import species.ImplementAvian;
import species.ImplementReptile;
import species.ImplementInsectAvianAquatic;

public class InterfacesUtil {
	public static List<Class<?extends AnimalType>> animaltypes = null;
	public static List<Class<?extends Animal>> animalspecies = null;
	public static List<Class<?extends Animal>> animalSpeciesByType(Class<?extends AnimalType> type){
		return animalspecies.stream().filter(
				x->Arrays.asList(x.getInterfaces()).stream().anyMatch(
						y->y.getSimpleName().equals(type.getSimpleName())
				)
		).collect(Collectors.toList());
	}
	public static List<Class<?extends AnimalType>> loadAnimalTypes() {
		if(animaltypes == null){
			animaltypes = new ArrayList<Class<?extends AnimalType>>();
			animaltypes.add(Aquatic.class);
			animaltypes.add(Insect.class);
			animaltypes.add(Reptile.class);
			animaltypes.add(Avian.class);
			animaltypes.add(Mammal.class);
		}
		return animaltypes;
	}
	public static List<Class<?extends Animal>> loadAnimalSpecies() {
		if(animalspecies == null){
			animalspecies = new ArrayList<Class<?extends Animal>>();
			animalspecies.add(ImplementMammal.class);
			animalspecies.add(ImplementMammalAvian.class);
			animalspecies.add(ImplementMammalAquatic.class);
			animalspecies.add(ImplementReptile.class);
			animalspecies.add(ImplementReptileAquatic.class);
			animalspecies.add(ImplementInsect.class);
			animalspecies.add(ImplementInsectAvian.class);
			animalspecies.add(ImplementInsectAquatic.class);
			animalspecies.add(ImplementInsectAvianAquatic.class);
			animalspecies.add(ImplementAvian.class);
		}
		return animalspecies;
	}
}
