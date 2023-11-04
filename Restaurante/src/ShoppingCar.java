import java.util.ArrayList;
import java.util.List;

public class ShoppingCar extends Plates{
    private int amount;
    private static List<Plates> plateList = new ArrayList<>();
    private static List<ShoppingCar> CarList = new ArrayList<>();

    public ShoppingCar(String name,String description, String type, double cost, int preparationTime, int amount){
        super(name, description,type,cost,preparationTime);
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public static void AddPlate(Plates plate){
        boolean found;
        System.out.println(plate.getName());
        String namePlate = plate.getName();//Recuperamos el nombre
        for (ShoppingCar car: CarList){
            System.out.println("xd");
            if(car.getName().equals(namePlate)){//Comprobamos si encuentra en el codigo
                car.setAmount(car.getAmount()+ 1);//Si ya se encuentra aumenta su cantidad
                found = true;
            }
        }
        ShoppingCar product = new ShoppingCar(plate.getName(), plate.getDescription(), plate.getType(),plate.getCost(), plate.getPreparationTime(), 1);
        CarList.add(product);//Si no esta lo crea
    }
    public void RemovePlate(Plates plate){
        String namePlate = plate.getName();//Recuperamos el nombre
        for (ShoppingCar car: CarList){
            if(car.getName().equals(namePlate)){//Comprobamos si encuentra en el codigo
                if (car.getAmount() == 1){
                    CarList.remove(car);//Si ya se encuentra y existe solo 1 lo retira del carrito
                }else{
                    car.setAmount(car.getAmount()- 1);//Si ya se encuentra y existe mas de 1 disminuye su cantidad
                }
            }
        }
    }
    public static double CalculateTotalCost(){
        double total;
        total = 0;
        for(ShoppingCar car:CarList){
            total = total + car.getCost() * car.getAmount();
        }
        return total;
    }
    public static int CalculateTotalTime(){
        int total;
        total = 0;
        for(ShoppingCar car: CarList){
            total = total + car.getPreparationTime();
        }
        return total;
    }
    public static String GeneratePurchaseBill(){
        String bill = "";
        boolean bebida = false;
        if(CalculateTotalCost() > 200000){
            bill = "No somos una empresa de lavado de activos, por favor intenta que tu total no supere los 200.000 COP";
        }
        for(ShoppingCar car: CarList){
            System.out.println("estoy recorriendo ");
            if(car.getAmount() > 5 ){
                bill = "Entiendo que te guste mucho el plato " + car.getName() + ", pero no es necesario que pidas mas de 5, deja algo a los demas comenzales" ;
                return bill;
            }
            bill = bill + "Nombre: " +car.getName() +"\nDescripcion: "+ car.getDescription() + "\nTipo de plato: " + car.getType() + "\nPrecio: " + car.getCost() + "\nTiempo de espera: "+ car.getPreparationTime() + "\nCantidad: " + car.getAmount()+ "\n Costo subtotal: " + car.getCost() * car.getAmount() +"\n\n";
            if(car.getType() == "Bebida"){
                bebida = true;
                System.out.println("hay bebbidasdjasjd asdjasjd ");
            }
        }
        if (!bebida){
            bill = "No aceptamos suicidas por atrangamiento :'c, la proxima pide una bebida";
        }
        System.out.println(CarList);
        return bill;
    }
    
}
