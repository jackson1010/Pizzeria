package TFIP.Test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;

import TFIP.Test1.Model.AddressModel;
import TFIP.Test1.Model.PizzaModel;
import TFIP.Test1.Repo.PizzaRepo;

@Component
public class AddressService {

    @Autowired 
    private PizzaRepo pizzaRepo;
    

    public double calculateTotalCost(AddressModel addressModel, PizzaModel pizzaModel, Model model) {
        
        int rush = 0;
        if (addressModel.isRush()) {
            rush = 2;
            // addressModel.setRushCost(2);
            addressModel.setRush(true);
        }

        double PizzaCost = getPizzaCost(addressModel, pizzaModel, model); 
        double totalCost = PizzaCost + rush;

        // addressModel.setPizzaCost(PizzaCost);
        // addressModel.setTotalCost(totalCost);

        return totalCost;

    }

    public double getPizzaCost(AddressModel addressModel, PizzaModel pizzaModel, Model model){
        
        model.addAttribute("AddressModel", addressModel);
        double noOfPizza = pizzaModel.getNoOfPizza();
        String typeOfPizza = pizzaModel.getTypeOfPizza();
        String sizeOfPizza = pizzaModel.getSizeOfPizza();
        double pizzaSizeCost = 0;
        double typeOfPizzaCost = 0;

    
        if (sizeOfPizza.equalsIgnoreCase("small")) {
            pizzaSizeCost = 1;
        }
        if (sizeOfPizza.equalsIgnoreCase("medium")) {
            pizzaSizeCost = 1.20;
        }
        if (sizeOfPizza.equalsIgnoreCase("large")) {
            pizzaSizeCost = 1.50;
        }

        switch (typeOfPizza) {
            case "Bella", "Marinara", "Spianata Calabrese":
                typeOfPizzaCost = 30;
                break;

            case "Margherita":
                typeOfPizzaCost = 22;
                break;

            case "Trio Formaggio":
                typeOfPizzaCost = 25;
                break;

            default:
                typeOfPizzaCost = 0;
                break;

        }

        double PizzaCost = noOfPizza * pizzaSizeCost * typeOfPizzaCost;

        return PizzaCost;
    }

    public void confirmOrder(AddressModel addressModel, PizzaModel pizzaModel) throws JsonProcessingException{
        pizzaRepo.saveOrder(addressModel, pizzaModel);
    }


}
