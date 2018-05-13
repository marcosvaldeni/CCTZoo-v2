package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Insect;

public class ImplementInsect extends Animal implements Insect {
	public ImplementInsect(){
	};
	public ImplementInsect(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, speciename, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void metamorphose() {
		System.out.println("Metamorphosing!");
	}


}
