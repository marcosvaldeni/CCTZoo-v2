package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Aquatic;
import animaltypes.Mammal;

public class ImplementMammalAquatic extends Animal implements Mammal,Aquatic {
	public ImplementMammalAquatic(){
	};
	public ImplementMammalAquatic(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, speciename, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void lactate() {
		System.out.println("Giving milk!");

	}

	@Override
	public void swimming() {
		System.out.println("Swimming!");
		
	}

}
