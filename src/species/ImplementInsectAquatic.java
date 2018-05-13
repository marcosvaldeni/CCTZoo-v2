package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Aquatic;
import animaltypes.Insect;

public class ImplementInsectAquatic extends Animal implements Insect, Aquatic {
	public ImplementInsectAquatic(){
	};
	public ImplementInsectAquatic(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, speciename, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void swimming() {
		System.out.println("Swimming!");
	}
	@Override
	public void metamorphose() {
		System.out.println("Metamorphosing!");
		
	}


}
