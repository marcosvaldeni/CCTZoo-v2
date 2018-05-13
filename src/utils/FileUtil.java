package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import species.Animal;

public class FileUtil {

	public static boolean readFile(InputStream reader){
		
		try {
		    Properties props = new Properties();
		    props.load(reader);
		    int animalTotal = Integer.parseInt(props.getProperty("Animals","100"));
		    int keeperTotal = Integer.parseInt(props.getProperty("Keepers","40"));
		    List<String> names = Arrays.asList(props.getProperty("Names","John,Mary").split(", "));
		    List<String> surnames = Arrays.asList(props.getProperty("SurNames","Aaberg, Aaby").split(", "));
		    Map<Class<? extends Animal>,String> species = new HashMap<Class<? extends Animal>,String>();
		    List<Class<? extends Animal>> animalspecies = InterfacesUtil.loadAnimalSpecies();
		    for (int i = animalspecies.size()-1; i > -1; i--) {
		    	List<Class<?>> interfaces = Arrays.asList(animalspecies.get(i).getInterfaces());
		    	List<String> interfacesstring = interfaces.stream().map(x->x.getSimpleName()).collect(Collectors.toList());
		    	species.put(animalspecies.get(i), props.getProperty(String.join("",interfacesstring)));
		    	if(species.get(animalspecies.get(i)).isEmpty()){
		    		animalspecies.remove(i);
		    	}
		    }
		    Util.createKeepers(keeperTotal, names, surnames);
		    List<Integer> values = Util.generateArrayInteger(animalTotal,animalspecies.size());
		    for (int i = 0; i < animalspecies.size(); i++) {
		    	Util.createAnimals(animalspecies.get(i),species.get(animalspecies.get(i)),values.get(i) , names);
			}
		    reader.close();
		} catch (FileNotFoundException ex) {
		    System.out.println("file does not exist");
		    return false;
		} catch (IOException ex) {
		    System.out.println("I/O error");
		    return false;
		}
		return true;
	}
}
