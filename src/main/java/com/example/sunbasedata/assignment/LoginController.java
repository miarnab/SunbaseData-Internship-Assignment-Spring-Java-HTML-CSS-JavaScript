package com.example.sunbasedata.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class LoginController {
    
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    
    public ResponseEntity<String> login(@RequestBody Form form) {
        
        String apiUrl = "YOUR_API_URL";
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, form, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            
            return ResponseEntity.ok("Authentication successful");
        } else {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
