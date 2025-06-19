package com.cpbank.AML_API.Controller;

import com.cpbank.AML_API.models.AMLRequest;
import com.cpbank.AML_API.models.AMLResponse;
import com.cpbank.AML_API.services.AMLService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AMLController {
    @Autowired
    private AMLService  amlService;


@PostMapping("/aml")
public ResponseEntity<AMLResponse> getRiskLevel(@RequestBody AMLRequest request) {
    try {
        AMLResponse response = amlService.PostCustomer(request);
        return ResponseEntity.ok(response); // Return response wrapped in ResponseEntity
    } catch (Exception e) {
        // Handle exceptions and return an appropriate error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
