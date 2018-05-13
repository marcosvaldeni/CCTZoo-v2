package species;
import java.time.LocalDate;
import java.util.List;

import animaltypes.Avian;
import animaltypes.Mammal;

public class ImplementMammalAvian extends Animal implements Mammal, Avian {
	public ImplementMammalAvian(){
	};
	public ImplementMammalAvian(String Name,String specieName,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, specieName, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void fly() {
		System.out.println("Flying!");
	}

	@Override
	public void walk() {
		System.out.println("Walking!");
	}

	@Override
	public void lactate() {
		System.out.println("Giving milk!");
	}


}
