package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Avian;

public class ImplementAvian extends Animal implements Avian {
	public ImplementAvian(){
	};
	public ImplementAvian(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, speciename, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void fly() {
		System.out.println("Flying!");

	}

	@Override
	public void walk() {
		System.out.println("Walking!");

	}

}
