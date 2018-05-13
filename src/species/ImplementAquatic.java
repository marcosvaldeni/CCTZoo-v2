package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Aquatic;

public class ImplementAquatic extends Animal implements Aquatic {
	public ImplementAquatic(){
	};
	public ImplementAquatic(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, speciename, dateOfBirth, dateOfArrival, gender, offspring);
	}
	@Override
	public void swimming() {
		System.out.println("Swimming!");
		
	}


}
