package species;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Food;
import utils.Medications;
import utils.Vaccines;

public abstract class Animal {
	private static int num = 0;
	private String name;
	private String specieName;
	private LocalDate dateOfBirth,dateOfArrival;
	private Character gender;
	private List<Animal> offspring;
	private List<Medications> medication;
	private List<Vaccines> vaccine;
	private final int exhibitNumber;
	private List<Food> diet;
	public Animal(){
		this.exhibitNumber = num++;
		this.offspring = new ArrayList<Animal>();
		this.medication = new ArrayList<Medications>();
		this.vaccine = new ArrayList<Vaccines>();
		this.diet = new ArrayList<Food>();
	};
	public Animal(String name,String specieName, LocalDate dateOfBirth, LocalDate dateOfArrival, Character gender,
			List<Animal> offspring) {
		super();
		this.exhibitNumber = num++;
		this.name = name;
		this.specieName = specieName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.gender = gender;
		this.offspring = offspring;
		this.medication = new ArrayList<Medications>();
		this.vaccine = new ArrayList<Vaccines>();
		this.diet = new ArrayList<Food>();
	}
	public String getSpecie() {
		return this.getClass().getSimpleName();
	}

	public String getType(){
		List<String> interfaceList = new ArrayList<String>();
		for (Class<?> _interface : this.getClass().getInterfaces()) {
			interfaceList.add(_interface.getSimpleName());
		}
		for(int i=0; i< this.getClass().getInterfaces().length;i++){
		}
		return String.join(", ", interfaceList);
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(LocalDate dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public List<Animal> getOffspring() {
		return offspring;
	}

	public void setOffspring(List<Animal> offspring) {
		this.offspring = offspring;
	}

	public List<Medications> getMedication() {
		return medication;
	}

	public void setMedication(List<Medications> medication) {
		this.medication = medication;
	}

	public List<Vaccines> getVaccine() {
		return vaccine;
	}

	public void setVaccine(List<Vaccines> vaccine) {
		this.vaccine = vaccine;
	}

	public int getExhibitNumber() {
		return exhibitNumber;
	}
	
	public void addDiet(Food... food){
		if(food != null)
			diet.addAll(Arrays.asList(food));
	}

	public String getName() {
		return name;
	}

	public void setSpecieName(String specieName) {
		this.specieName = specieName;
	}

	public String getSpecieName() {
		return specieName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Food> getDiet() {
		return diet;
	}

	public void setDiet(List<Food> diet) {
		this.diet = diet;
	}
	@Override
	public String toString() {
		return "Animal [Name=" + name+" Specie Name=" + specieName + ", dateOfBirth=" + dateOfBirth + ", dateOfArrival=" + dateOfArrival
				+ ", gender=" + gender + ", offspring=" + offspring + ", medication=" + medication + ", vaccine="
				+ vaccine + ", exhibitNumber=" + exhibitNumber + ", diet=" + diet + "]";
	}
	
}
