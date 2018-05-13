package controller;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import animaltypes.AnimalType;
import species.Animal;
import species.Keeper;
import utils.Util;


public final class Zoo {
	
	private static Zoo _interface;
	
	private Zoo() {
	}
	//Singleton
	public static Zoo getInterface(){
		if(_interface == null){
			_interface = new Zoo();
		}
		return _interface;
	}
	
	//Read File
	public void start(String configFile){

	    InputStream reader =  getClass().getClassLoader().getResourceAsStream(configFile);
	    if(Util.start(reader)){
		    //TODO:do something
	    }
	}
	public List<Animal> getAnimalAll(){
		return Util.animals;
	}
	public List<Animal> getAnimalByType(Class<?extends AnimalType> type){
		return Util.animals.stream().filter(
				x->Arrays.asList(x.getClass().getInterfaces()).stream().anyMatch(
						y->y.getSimpleName().equals(type.getSimpleName()))).collect(Collectors.toList());
	}
	public Animal getAnimalById(int id){
		return Util.animals.stream().filter(x->x.getExhibitNumber() == id).findFirst().get();
	}
	public List<Animal> getAnimalByName(String name){
		return Util.animals.stream().filter(x->x.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
	}
	public List<Keeper> getKeeperByName(String name){
		return Util.keepers.stream().filter(x->x.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
	}
	public List<Keeper> getKeeperAll(){
		return Util.keepers;
	}
	public Keeper getKeeperById(int id){
		return Util.keepers.stream().filter(x->x.getId() == id).findFirst().get();
	}
	public void newKeeper(String keepername, List<Class<? extends AnimalType>> keeperskills) {
		Keeper k = new Keeper(keepername);
		k.getAnimaltypelist().addAll(keeperskills);
		Util.keepers.add(k);
	}
	public void newAnimal(String name,String dateofbirth,String dateofarrival,char gender, Animal offspringof,Class<? extends Animal> specie){
		//TODO:check if is baby and limit dates
		Animal a;
		try {
			a = specie.newInstance();
			a.setName(name);
			String[] dbsplited = dateofbirth.split("/");
			String[] dasplited = dateofarrival.split("/");
		    a.setDateOfBirth(LocalDate.of(Integer.parseInt(dbsplited[2]), Integer.parseInt(dbsplited[1]), Integer.parseInt(dbsplited[0])));
		    a.setDateOfArrival(LocalDate.of(Integer.parseInt(dasplited[2]), Integer.parseInt(dasplited[1]), Integer.parseInt(dasplited[0])));
		    a.setGender(gender);
		    if(offspringof!=null){
		    	offspringof.getOffspring().add(a);
		    }
		    Util.addAnimal(a);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
