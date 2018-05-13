package utils;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import species.Animal;
import species.Keeper;

public class Util {
	public static List<Animal> animals = new ArrayList<Animal>();
	public static List<Keeper> keepers = new ArrayList<Keeper>();
	
	public static int version;
	
	public static LocalDate generateDate(int year,int month, int day){
		Random random = new Random();
		int startDay = (int) LocalDate.of(year, month, day).toEpochDay();
		int endDay = (int) LocalDate.now().toEpochDay();
		long result = startDay + random.nextInt(endDay - startDay);
		return LocalDate.ofEpochDay(result);
	}
	public static int generateRandomInteger(int start,int end){
		Random generator = new Random();
    	return generator.nextInt(end - start);
	}
	public static boolean generateRandomBoolean() {
		Random generator = new Random();
		return generator.nextBoolean();
	}
	public static int generateRandomInteger(int end){
		Random generator = new Random();
    	return generator.nextInt(end);
	}public static List<Integer> generateArrayInteger(int value,int divisor){
		int start = value/divisor;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < divisor; i++) {
			result.add(start);
		}
		int diff = 0;
		int total = 0;
		for (int i = 0; i < result.size(); i++) {
			if(i == (result.size()-1)){
				result.set(i, value - total);
			}else if(diff == 0){
				diff = generateRandomInteger(0,start)-(start/2);
				result.set(i, result.get(i) + diff);
			}else{
				result.set(i, result.get(i) + (diff*-1));
				diff = 0;
			}
			total+=result.get(i);
		}
		return result;
	}
	public static void addAnimal(Animal animal) {
		for (int j = 0; j < keepers.size(); j++) {
			boolean tobreak = keepers.get(j).addAnimal(animal);
			if(tobreak){
				break;
			}
		}
		animals.add(animal);
	}
	public static boolean start(InputStream reader){
		FileUtil.readFile(reader);
		return true;
	}
	protected static void createKeepers(int n,List<String> names,List<String> surnames){
		for (int i = 0; i < n; i++) {
			Keeper k = new Keeper(names.get(Util.generateRandomInteger(names.size())) + " " +
					surnames.get(Util.generateRandomInteger(surnames.size())));
			for (int j = 0; j < 3; j++) {
				k.getAnimaltypelist().add(InterfacesUtil.loadAnimalTypes().get(Util.generateRandomInteger(InterfacesUtil.loadAnimalTypes().size())));
			}
			keepers.add(k);
			}
	}
	protected static void createAnimals(Class<?extends Animal> animal, String species, int n,List<String> names){
		Animal togetbaby = null;
		int nBabies = 0;
		List<String> specieList = Arrays.asList(species.split(","));
		for (int i = 0; i < n; i++) {
		    LocalDate d1 = Util.generateDate(1990,1,1);
		    Animal b;
			try {
				b = animal.newInstance();
			    b.setName(names.get(Util.generateRandomInteger(names.size())));
			    b.setDateOfBirth(d1);
			    int index = Util.generateRandomInteger(specieList.size());
			    if(index == -1){
			    	System.out.println(specieList.size());
			    }
			    b.setSpecieName(specieList.get(index));
			    b.setDateOfArrival(Util.generateDate(d1.getYear(),d1.getMonthValue(),d1.getDayOfMonth()));
			    b.setGender('M');
			    //random to get babies
				if(togetbaby == null && n > 10 && Util.generateRandomBoolean() && LocalDate.ofEpochDay(d1.compareTo(LocalDate.now())).lengthOfMonth() > 3) {
					togetbaby = b;
					nBabies = Util.generateRandomInteger(1, (n/2));
				}else if(togetbaby != null && nBabies > 0){
					b.setDateOfBirth(Util.generateDate(togetbaby.getDateOfBirth().getYear(), togetbaby.getDateOfBirth().getMonthValue(), togetbaby.getDateOfBirth().getDayOfMonth()));
					b.setDateOfArrival(Util.generateDate(b.getDateOfBirth().getYear(), b.getDateOfBirth().getMonthValue(), b.getDateOfBirth().getDayOfMonth()));
					if(togetbaby.getSpecieName().equals(b.getSpecieName()))
						togetbaby.getOffspring().add(b);
					nBabies--;
					
				}else {
					togetbaby = null;
				}
				
			    addAnimal(b);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
	}
}
