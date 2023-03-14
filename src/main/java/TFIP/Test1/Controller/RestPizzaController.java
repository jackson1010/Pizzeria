// package TFIP.Test1.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.http.ResponseEntity;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.server.ResponseStatusException;

// import com.google.gson.JsonObject;

// import TFIP.Test1.Model.AddressModel;
// import TFIP.Test1.Service.AddressService;

// @RestController
// public class RestPizzaController {
   
//     @Autowired
//     private AddressService AddressS;
    
//     @GetMapping("/order/{Orderid}")
//     public AddressModel getOrderbyId(Model model, @PathVariable String id){
//         AddressModel addressmodel = AddressS.retrieveSurvey(id);

//         // if survey not found throw response error 404
//         if (addressmodel == null) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }

//         final JsonObject resp = Json.createObject().add("OrderId", addressmodel.getId());

//         HttpHeaders headers = new HttpHeaders();
//         headers.add("message","Order {Oderid} not found");
//         new ResponseEntity( headers, HttpStatus.NOT_FOUND);
        

//         return addressmodel;

// }

// @PostMapping("/order/{Orderid}")
//     public AddressModel savedOrderbyId(Model model, @PathVariable String id){
//         AddressModel addressmodel = AddressS.retrieveSurvey(id);

//         // if survey not found throw response error 404
//         if (addressmodel == null) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }
//         return addressmodel;

//         HttpHeaders headers = new HttpHeaders();
//         headers.add("","");
//         new ResponseEntity(entity, headers, HttpStatus.OK);

        
// }
// }
