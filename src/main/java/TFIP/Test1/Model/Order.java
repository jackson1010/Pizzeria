package TFIP.Test1.Model;

public class Order {
    private AddressModel addressModel;
    private PizzaModel pizzaModel;

    public Order(AddressModel addressModel, PizzaModel pizzaModel) {
        this.addressModel = addressModel;
        this.pizzaModel = pizzaModel;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public PizzaModel getPizzaModel() {
        return pizzaModel;
    }
}
