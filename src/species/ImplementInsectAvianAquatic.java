package species;
import java.time.LocalDate;
import java.util.List;

import animaltypes.Aquatic;
import animaltypes.Avian;
import animaltypes.Insect;



public class ImplementInsectAvianAquatic extends Animal implements Insect,Avian, Aquatic {
	public ImplementInsectAvianAquatic(){
	};
	public ImplementInsectAvianAquatic(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
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
	@Override
	public void swimming() {
		System.out.println("Swimming!");
		
	}


}
