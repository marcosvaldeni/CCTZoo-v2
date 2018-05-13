package species;

import java.time.LocalDate;
import java.util.List;

import animaltypes.Aquatic;
import animaltypes.Reptile;

public class ImplementReptileAquatic extends Animal implements Reptile, Aquatic {
	public ImplementReptileAquatic(){
	};
	public ImplementReptileAquatic(String Name,String speciename,LocalDate dateOfBirth, LocalDate dateOfArrival,
			Character gender, List<Animal> offspring) {
		super(Name, speciename, dateOfBirth, dateOfArrival, gender, offspring);
	}

	@Override
	public void swimming() {
		System.out.println("Swimming!");
		
	}

	@Override
	public void walk() {
		System.out.println("Walking!");
		
	}

	@Override
	public void crawl() {
		System.out.println("Crawling!");
		
	}


}
