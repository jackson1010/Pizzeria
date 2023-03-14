package TFIP.Test1.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public class AddressModel {
    

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be min 3 characters")
    private String name;
    @NotNull(message = "Address cannot be null")
    private String address;
    @Size(min = 8, message = "Name must be min 3 characters")
    private String PhoneNumber;
    private boolean rush;
    private String id;
    private String comments;

    private PizzaModel pizzaModel;

    public PizzaModel getPizzaModel() {
        return pizzaModel;
    }

    public void setPizzaModel(PizzaModel pizzaModel) {
        this.pizzaModel = pizzaModel;
    }   

   

    // private double pizzaCost;
    // private double totalCost;
    // private int rushCost;

    
    public AddressModel(String name, String address, String phoneNumber, boolean rush) {
        this.name = name;
        this.address = address;
        this.PhoneNumber = phoneNumber;
        this.rush = rush;
    }

    public AddressModel() {
        this.rush = false;
        UUID uuid = UUID.randomUUID();
        String uuidString =uuid.toString();
        this.id= uuidString;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public boolean isRush() {
        return rush;
    }
    public void setRush(boolean rush) {
        this.rush = rush;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        this.id = uuidString.substring(0,8);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    // public double getPizzaCost() {
    //     return pizzaCost;
    // }

    // public void setPizzaCost(double pizzaCost) {
    //     this.pizzaCost = pizzaCost;
    // }

    // public double getTotalCost() {
    //     return totalCost;
    // }

    // public void setTotalCost(double totalCost) {
    //     this.totalCost = totalCost;
    // }

    // public int getRushCost() {
    //     return rushCost;
    // }

    // public void setRushCost(int rushCost) {
    //     this.rushCost = rushCost;
    // }




    
}
