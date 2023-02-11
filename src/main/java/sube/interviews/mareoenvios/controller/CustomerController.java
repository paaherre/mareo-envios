package sube.interviews.mareoenvios.controller;

import sube.interviews.mareoenvios.DTO.CustomerDTO;
import sube.interviews.mareoenvios.repository.CustomerRepository;
import sube.interviews.mareoenvios.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(value = "id") Long customerId) {
        CustomerDTO customerDTO = customerRepository.findById(customerId).map(CustomerDTO::new).orElse(null);
        if(customerDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customerDTO);
    }
}
