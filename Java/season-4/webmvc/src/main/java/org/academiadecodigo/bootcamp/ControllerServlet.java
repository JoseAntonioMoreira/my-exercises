package org.academiadecodigo.bootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerServlet {

    public Customer createCustomer() {
        Customer customer = new Customer();

        customer.setId(1);
        customer.setFirstName("Rui");
        customer.setLastName("Ferrão");
        customer.setEmail("rui.ferrao@academiadecodigo.org");
        customer.setPhone("916668877");

        return customer;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public String requestCustomer(Model model) {

        model.addAttribute("customer", createCustomer());

        return "index";
    }
}
