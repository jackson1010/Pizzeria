package TFIP.Test1.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PizzaModel {

    @NotNull(message="Please select a pizza")
    private String typeOfPizza;
    
    @Min(value =1, message ="Minimum order is 1")
    @Max(value =10, message ="Maximum order is 10")
    private int noOfPizza;

    private String sizeOfPizza;

    public PizzaModel(String typeOfPizza, int noOfPizza, String sizeOfPizza) {
        this.typeOfPizza = typeOfPizza;
        this.noOfPizza = noOfPizza;
        this.sizeOfPizza = sizeOfPizza;
    }

    public PizzaModel() {
    }

    @Override
    public String toString() {
        return "pizza [typeOfPizza=" + typeOfPizza + ", noOfPizza=" + noOfPizza + ", sizeOfPizza=" + sizeOfPizza + "]";
    }

    public String getTypeOfPizza() {
        return typeOfPizza;
    }

    public void setTypeOfPizza(String typeOfPizza) {
        this.typeOfPizza = typeOfPizza;
    }

    public int getNoOfPizza() {
        return noOfPizza;
    }

    public void setNoOfPizza(int noOfPizza) {
        this.noOfPizza = noOfPizza;
    }

    public String getSizeOfPizza() {
        return sizeOfPizza;
    }

    public void setSizeOfPizza(String sizeOfPizza) {
        this.sizeOfPizza = sizeOfPizza;
    }

}
