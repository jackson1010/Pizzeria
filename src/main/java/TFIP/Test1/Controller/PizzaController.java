package TFIP.Test1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import TFIP.Test1.Model.AddressModel;
import TFIP.Test1.Model.PizzaModel;
import TFIP.Test1.Service.AddressService;
import TFIP.Test1.Service.PizzaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PizzaController {

    @Autowired
    private PizzaService pizzaS;

    @Autowired
    private AddressService AddressS;

    @GetMapping
    public String getHomepage(Model model, HttpSession session) {
        PizzaModel pizzaModel = (PizzaModel) session.getAttribute("pizzaModel");
        if (null == pizzaModel) {
            pizzaModel = new PizzaModel();
            session.setAttribute("pizzaModel", pizzaModel);
            System.out.println("pizza MOdel created");
        }
        model.addAttribute("pizzaModel", pizzaModel);
        return "index";
    }

    @PostMapping
    public String getOrders(Model model, HttpSession session,
            @Valid @ModelAttribute("pizzaModel") PizzaModel pizzaModel, BindingResult binding) {

        if (binding.hasErrors()) {
            return "index";
        }

        // if(pizzaModel.getTypeOfPizza() == null){
        // System.out.println(pizzaModel.getTypeOfPizza());
        // FieldError error = new FieldError("PizzaModel", "typeOfPizza", "Please choose
        // the type of pizza");
        // binding.addError(error);
        // return "index";
        // }

        pizzaS.newOrder(pizzaModel, model);
        session.setAttribute("pizzaModel", pizzaModel);
        return "redirect:/address";
    }

    @GetMapping("/address")
    public String getAddress(Model model, HttpSession session) {
        AddressModel addressModel = (AddressModel) session.getAttribute("AddressModel");
        if (null == addressModel) {
            addressModel = new AddressModel();
            session.setAttribute("AddressModel", addressModel);
        }
        model.addAttribute("AddressModel", addressModel);
        return "DeliveryDetails";
    }

    @PostMapping("/address")
    public String SaveAddress(@Valid @ModelAttribute("AddressModel") AddressModel addressModel, BindingResult binding,
            Model model, HttpSession session) throws JsonProcessingException {

        if (binding.hasErrors()) {
            return "DeliveryDetails";
        }
        session.setAttribute("AddressModel", addressModel);
        PizzaModel pizzaModel = (PizzaModel) session.getAttribute("pizzaModel");

        //Push to redis
        AddressS.confirmOrder(addressModel, pizzaModel);


        return "redirect:/order";
    }

    @GetMapping("/cancel-order")
    public String cancelOrder() {
        return "redirect:/"; // Redirect to main page after order is cancelled
    }

    @GetMapping("/order")
    public String showOrder(Model model, HttpSession session) {
        PizzaModel pizzaModel = (PizzaModel) session.getAttribute("pizzaModel");
        AddressModel addressmodel = (AddressModel) session.getAttribute("AddressModel");

        model.addAttribute("pizzaCost", AddressS.getPizzaCost(addressmodel, pizzaModel, model));
        model.addAttribute("totalCost", AddressS.calculateTotalCost(addressmodel, pizzaModel, model));
        

        return "Orders";
    }
}
