import java.util.ArrayList;
import java.util.List;

public class Plates {
    
    private String name;
    private String description;
    private String type;
    private double cost;
    private int preparationTime;
    public Plates(){ 
    }
    public Plates(String name, String description, String type, double cost, int preparationTime){
        this.name = name;
        this.description = description;
        this.type = type;
        this.cost = cost;
        this.preparationTime = preparationTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public int getPreparationTime() {
        return preparationTime;
    }
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    //Functions to the Create Read Update and Delete of plates---------------------------------------------------------------
    
    //Create
    public static void CreatePlate( List<Plates> plates, String name, String description, String type, double cost, int preparationTime){
        for(Plates plate: plates){
            if( name == plate.getName()){
                return;
            }
        }
        Plates plate = new Plates(name,description,type,cost,preparationTime);
        plates.add(plate);
    }
    
    //Update
    public static Plates SearchPlate(List<Plates> plates, String NamePlate){
        Plates plateToReturn = new Plates();
        for(Plates plate: plates){
            if(NamePlate == plate.getName()){
                plateToReturn = plate;
            }
        }
        return plateToReturn;
    }

    //Update
    public static Plates UpdatePlate(List<Plates> plates,Plates plate,String name, String description, String type, double cost, int preparationTime){
        plate = new Plates(name,description,type,cost,preparationTime);
        return plate;
    }
    public Plates SearchByName(String name, List<Plates> plates){
        for(Plates plate: plates){
            if(plate.getName() == name){
                return plate;
            }
        }
        return null;
    }
}