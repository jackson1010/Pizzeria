package TFIP.Test1.Service;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import TFIP.Test1.Model.PizzaModel;


@Component
public class PizzaService {

    public void newOrder( PizzaModel pizzaModel, Model model) {
        model.addAttribute("pizzaModel", pizzaModel);
    }
    
}
