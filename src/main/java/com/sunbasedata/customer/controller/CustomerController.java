package com.sunbasedata.customer.controller;

import com.sunbasedata.customer.model.AuthRequest;
import com.sunbasedata.customer.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sunbase/portal/api")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();
    @Value("${app.auth.token}")
    private String authToken; // This will be set from properties file

    @PostMapping("/assignment_auth.jsp")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthRequest authRequest) {
        if (authRequest.getLoginId().equals("test@sunbasedata.com") && authRequest.getPassword().equals("Test@123")) {
            return ResponseEntity.ok(authToken);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization");
        }
    }

    @PostMapping("/assignment.jsp")
    public ResponseEntity<String> handleCustomerAction(@RequestHeader("Authorization") String token,
                                                       @RequestParam("cmd") String cmd,
                                                       @RequestParam(value = "uuid", required = false) String uuid,
                                                       @RequestBody(required = false) Customer customer) {
        if (!isValidAuthToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization");
        }

        if ("create".equals(cmd)) {
            if (customer == null || customer.getFirstName() == null || customer.getLastName() == null) {
                return ResponseEntity.badRequest().body("First Name or Last Name is missing");
            }
            customer.setUuid(UUID.randomUUID().toString());
            customerList.add(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
        } else if ("update".equals(cmd)) {
            if (uuid == null || uuid.isEmpty()) {
                return ResponseEntity.badRequest().body("UUID is missing");
            }

            // Implement update customer logic here using customer.getUuid()
            return ResponseEntity.ok("Successfully Updated");
        } else if ("delete".equals(cmd)) {
            if (uuid == null || uuid.isEmpty()) {
                return ResponseEntity.badRequest().body("UUID is missing");
            }

            // Find and remove the customer with the given UUID from the list
            boolean deleted = false;
            for (Customer existingCustomer : customerList) {
                if (existingCustomer.getUuid().equals(uuid)) {
                    customerList.remove(existingCustomer);
                    deleted = true;
                    break;
                }
            }

            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UUID not found");
            }

            return ResponseEntity.ok("Successfully Deleted");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid Command");
        }
    }

    @GetMapping("/assignment.jsp")
    public ResponseEntity<List<Customer>> getCustomerList(@RequestHeader("Authorization") String token,
                                                          @RequestParam("cmd") String cmd) {
        if (!isValidAuthToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if ("get_customer_list".equals(cmd)) {
            return ResponseEntity.ok(customerList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private boolean isValidAuthToken(String token) {
        return token != null && token.startsWith("Bearer ") && token.substring(7).equals(authToken);
    }
}