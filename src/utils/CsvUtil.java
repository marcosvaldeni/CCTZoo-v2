package utils;

import java.util.stream.Collectors;

import species.Animal;
import species.Keeper;

public class CsvUtil {
	public static String getHeaderAnimal() {
		return "Name,Specie,date of birth, date of arrival, gender,medication,vaccine,exhibit number,diet,offspring";
	}
	public static String getLineAnimal(Animal animal) {
		return "\n\""+animal.getName()
		+"\",\""+animal.getSpecieName().replaceAll(",", "")
		+"\",\""+animal.getDateOfBirth()
		+"\",\""+animal.getDateOfArrival()
		+"\",\""+animal.getGender()
		+"\",\""+String.join("| ",animal.getMedication().stream().map(x->x.name()).collect(Collectors.toList()))
		+"\",\""+String.join("| ",animal.getVaccine().stream().map(x->x.name()).collect(Collectors.toList()))
		+"\",\""+animal.getExhibitNumber()
		+"\",\""+String.join("| ",animal.getDiet().stream().map(x->x.name()).collect(Collectors.toList()))
		+"\",\""+String.join("| ",animal.getOffspring().stream().map(x->String.valueOf(x.getExhibitNumber())).collect(Collectors.toList()))+"\"";
	}
	public static String getHeaderKeeper() {
		return "Name,Id,Skills,Animals";
	}
	public static String getLineKeeper(Keeper keeper) {
		return "\n"+keeper.getName()
		+","+keeper.getId()
		+","+String.join("| ",keeper.getAnimaltypelist().stream().map(x->x.getSimpleName()).collect(Collectors.toList()))
		+","+String.join("| ",keeper.getAnimals().stream().map(x->String.valueOf(x.getExhibitNumber())).collect(Collectors.toList()));
	}
}
