package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Mammal;

public class ImplementMammal extends Animal implements Mammal {
	public ImplementMammal(){
	};
	public ImplementMammal(String Name,String specieName,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, specieName, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void lactate() {
		System.out.println("Giving milk!");

	}

}
