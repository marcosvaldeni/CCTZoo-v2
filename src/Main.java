import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import animaltypes.AnimalType;
import controller.Zoo;
import species.Animal;
import species.Keeper;
import utils.CsvUtil;
import utils.InterfacesUtil;
import utils.Medications;
import utils.Util;
import utils.Vaccines;

public class Main {
	static Scanner cursor;
	static Zoo zoo;
	private static void menuListKeepers(){
		int submenu1 = 0;
		while(submenu1 > -1) {
			System.out.println("####################################################");
			System.out.println("1 - List Keepers By Name");
			System.out.println("2 - List Keepers All");
			System.out.println("3 - Detail Keeper By Id");
			System.out.println("4 - New Keeper");
			System.out.println("-1 - Go Back");
			submenu1 = cursor.nextInt();
			switch (submenu1) {
			case 1:

				System.out.println("Search Name");
				String searchname = cursor.next();
				System.out.println(zoo.getKeeperByName(searchname));
				
				break;
			case 2:

				zoo.getKeeperAll().stream().forEach(
						x->System.out.println(x.getId() + " - " + x.getName() + " - "+ String.join(", ",x.getAnimaltypelist().stream().map(y->y.getSimpleName()).collect(Collectors.toList())))
				);
				
				break;
			case 3:

				System.out.println("Id number");
				int idnumber = cursor.nextInt();
				Keeper a = zoo.getKeeperById(idnumber);
				if(a != null) {
					System.out.println(a);
					System.out.println("Needs Update? True or False");
					boolean isneedupdate = cursor.nextBoolean();
					if(isneedupdate) {
						int submenu3 = 0;
						while(submenu3 > -1) {
							System.out.println("1 - Update Skils");
							System.out.println("-1 - Go Back");
							submenu3 = cursor.nextInt();
							switch (submenu3) {
							case 1:
								System.out.println("New Skill");
								List<String> skilllist = InterfacesUtil.loadAnimalTypes().stream().map(x->x.getSimpleName()).collect(Collectors.toList());
								skilllist.stream().forEach(x-> System.out.println((skilllist.indexOf(x)+1)+" - "+x));
								int medication = cursor.nextInt();
								if(medication > skilllist.size()) {
									System.err.println("Not Valid");
									break;
								}
								a.getAnimaltypelist().add(InterfacesUtil.loadAnimalTypes().get(medication-1));
								break;
							default:
								break;
							}
						}
					}
				}
				break;
			case 4:
				System.out.println("First Name");
				String firstname = cursor.next();
				System.out.println("Surname");
				String surname = cursor.next();
				String keepername = firstname + " " +surname;
				List<Class<? extends AnimalType>> keeperskills = new ArrayList<Class<? extends AnimalType>>();
				boolean keeperskillmenu = true;
				while(keeperskillmenu) {
					System.out.println("Skill");
					List<Class<? extends AnimalType>> animaltypes =InterfacesUtil.loadAnimalTypes(); 
					animaltypes.forEach(x->System.out.println(animaltypes.indexOf(x)+" - "+x.getSimpleName()));
					System.out.println("-1 - Save");
					
					int skillSelected = cursor.nextInt();
					
					if(skillSelected == -1) {
						keeperskillmenu = false;
					}else if(skillSelected > animaltypes.size()){
						System.out.println("Not Valid");
					}else {
						keeperskills.add(animaltypes.get(skillSelected));
					}
				}
				zoo.newKeeper(keepername,keeperskills);
				break;
			case -1:
				
				break;

			default:
				break;
			}
		}
		return;
	}
	private static void menuListAnimals(){
		int submenu1 = 0;
		while(submenu1 > -1) {
			System.out.println("####################################################");
			System.out.println("1 - List Animals By Type");
			System.out.println("2 - List Animals By Name");
			System.out.println("3 - List Animals All");
			System.out.println("4 - Detail Animal By Id");
			System.out.println("5 - New Animal");
			System.out.println("-1 - Go Back");
			submenu1 = cursor.nextInt();
			switch (submenu1) {
			case 1:
				int submenu2 = 0;
				while(submenu2 > -1) {
					System.out.println("####################################################");
					InterfacesUtil.loadAnimalTypes().stream().forEach(
							x->System.out.println((InterfacesUtil.loadAnimalTypes().indexOf(x)+1) +" - "+x.getSimpleName()));
					System.out.println("-1 - Go Back");
					submenu2 = cursor.nextInt();
					if(submenu2 > InterfacesUtil.loadAnimalTypes().size()) {
						System.out.println("Not Valid");
					}else if(submenu2 != -1){
						zoo.getAnimalByType(InterfacesUtil.loadAnimalTypes().get(submenu2-1)).stream().forEach(
								x->System.out.println(x.getExhibitNumber() + " - " + x.getName() + " - "+ x.getSpecie() + " - "+ String.join(", ", x.getType()))
						);
					}
				}
				break;
			case 2:
				System.out.println("Search Name");
				String searchname = cursor.next();
				System.out.println(zoo.getAnimalByName(searchname));
				
				break;
			case 3:
				zoo.getAnimalAll().stream().forEach(
						x->System.out.println(x.getExhibitNumber() + " - " + x.getName() + " - "+ x.getSpecie() + " - "+ String.join(", ", x.getType()) + " - "+x.getOffspring().size()+" Babies")
				);
				break;
			case 4:
				System.out.println("Id number");
				int idnumber = cursor.nextInt();
				Animal a = zoo.getAnimalById(idnumber);
				if(a != null) {
					System.out.println(a);
					System.out.println("Needs Update? True or False");
					boolean isneedupdate = cursor.nextBoolean();
					if(isneedupdate) {
						int submenu3 = 0;
						while(submenu3 > -1) {
							System.out.println("1 - Update Medications");
							System.out.println("2 - Update Vaccines");
							System.out.println("-1 - Go Back");
							submenu3 = cursor.nextInt();
							switch (submenu3) {
							case 1:
								System.out.println("New Medication");
								List<Medications> medicationlist = Arrays.asList(Medications.values());
								medicationlist.stream().forEach(x-> System.out.println((medicationlist.indexOf(x)+1)+" - "+x.name()));
								int medication = cursor.nextInt();
								if(medication > medicationlist.size()) {
									System.err.println("Not Valid");
									break;
								}
								a.getMedication().add(medicationlist.get(medication-1));
								break;
							case 2:
								System.out.println("New Vaccine");
								List<Vaccines> vacinelist = Arrays.asList(Vaccines.values());
								vacinelist.stream().forEach(x-> System.out.println((vacinelist.indexOf(x)+1)+" - "+x.name()));
								int vacine = cursor.nextInt();
								if(vacine > vacinelist.size()) {
									System.err.println("Not Valid");
									break;
								}
								a.getVaccine().add(vacinelist.get(vacine-1));
								break;

							default:
								break;
							}
						}
					}
				}
				break;
			case 5:
				System.out.println("Name");
				String name = cursor.next();
				System.out.println("Gender M/F");
				String genderString = cursor.next("M");
				List<Class<? extends AnimalType>> animaltypes =InterfacesUtil.animaltypes; 
				animaltypes.forEach(x->System.out.println(animaltypes.indexOf(x)+" - "+x.getSimpleName()));
				int typeIndex = cursor.nextInt();
				List<Class<? extends Animal>> species = InterfacesUtil.animalSpeciesByType(animaltypes.get(typeIndex));
				species.forEach(x->System.out.println(species.indexOf(x)+" - "+x.getSimpleName()));
				int specieIndex = cursor.nextInt();
				System.out.println("Date of Birth");
				String dateofbirth = cursor.next("1/1/2018");
				System.out.println("Date of Arrival");
				String dateofarrival = cursor.next("1/1/2018");
				zoo.newAnimal(name, dateofbirth, dateofarrival, genderString.charAt(0), null, species.get(specieIndex));
				break;
			case -1:
				
				break;

			default:
				break;
			}
		}
		return;
	}
	private static void mainMenu(){
		int menu = 0;
		while(menu > -1) {
			System.out.println("####################################################");
			System.out.println("1 - List Animals");
			System.out.println("2 - List Keepers");
			System.out.println("-1 - Quit System");
			menu = cursor.nextInt();
			switch (menu) {
			case 1:
				menuListAnimals();
				break;
			case 2:
				menuListKeepers();
				break;
			case -1:
		        int nexport = 0;
		        String csvFile = "";
		        boolean hasName = false;
		        while(!hasName){
		        csvFile = "export"+Util.version+"-"+nexport+".csv";
		        File f = new File("export"+Util.version+"-"+nexport+".csv");
			        if(!f.exists() && !f.isDirectory()) { 
			            hasName = true;
			        }else {
			        	nexport++;
			        }
		        }
		        try {
					FileWriter writer = new FileWriter(csvFile);
			        writer.append(CsvUtil.getHeaderAnimal());
			        zoo.getAnimalAll().stream().forEach(x->{
						try {
							writer.append(CsvUtil.getLineAnimal(x));
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
			        writer.append("\n");
			        writer.append(CsvUtil.getHeaderKeeper());
			        zoo.getKeeperAll().stream().forEach(x->{
						try {
							writer.append(CsvUtil.getLineKeeper(x));
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
			        writer.flush();
			        writer.close();
		        }catch (Exception e2) {
		        	e2.printStackTrace();
				}
				System.out.println("System finished!");
				cursor.close();
				break;

			default:
				break;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("Starting Zoo Management!");
		zoo = Zoo.getInterface();
		InterfacesUtil.loadAnimalTypes();
		InterfacesUtil.loadAnimalSpecies();
		zoo.start("config.properties");
		System.out.println("Started Zoo Management!");
        cursor = new Scanner(System.in);
        mainMenu();
	}

}
