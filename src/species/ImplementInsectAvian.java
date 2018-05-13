package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Avian;
import animaltypes.Insect;

public class ImplementInsectAvian extends Animal implements Insect, Avian {
	public ImplementInsectAvian(){
	};
	public ImplementInsectAvian(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
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
	@Override
	public void metamorphose() {
		System.out.println("Metamorphosing!");
		
	}
}
