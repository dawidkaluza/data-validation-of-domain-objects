package pl.dkaluza.spring_validation;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {
    @PostMapping("/greeting")
    ResponseEntity<?> greeting(@Valid @RequestBody GreetingRequest request) {
        return ResponseEntity.ok("Hello, " + request.name());
    }
}
