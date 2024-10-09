package pl.dkaluza.validation.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dkaluza.validation.domain.SignUpCommand;
import pl.dkaluza.validation.domain.UserService;

@RestController
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    ResponseEntity<?> signUp(@RequestBody SignUpCommand signUpCommand) {
        userService.signUp(signUpCommand);
        return ResponseEntity.ok().build();
    }
}
