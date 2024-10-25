package com.cpbank.AML_API.Controller;

import com.cpbank.AML_API.models.AMLRequest;
import com.cpbank.AML_API.models.AMLResponse;
import com.cpbank.AML_API.services.AMLService;
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
//    try {
        // Call the service method to get the AMLResponse
        System.out.println("this is request"+request);
        AMLResponse response = amlService.getRiskLevel(request);
        System.out.println("this after service");
        return ResponseEntity.ok(response); // Return response wrapped in ResponseEntity
//    } catch (Exception e) {
//        // Handle exceptions and return an appropriate error response
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }
}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
