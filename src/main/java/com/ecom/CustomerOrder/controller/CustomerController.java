package com.ecom.CustomerOrder.controller;



import com.ecom.CustomerOrder.model.Customer;
import com.ecom.CustomerOrder.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000") // Allows React to call this API


@RestController

@Tag(name = "Customer API", description = "Operations related to customers")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return service.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/{id}") // ✅ Corrected the mapping from "/id" to "/{id}"
    public void deleteCustomer(@PathVariable Long id) { // ✅ Added @PathVariable
        service.deleteCustomer(id);
    }
}
