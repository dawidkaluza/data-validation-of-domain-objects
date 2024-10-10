package pl.dkaluza.validation.domain;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User signUp(@Valid SignUpCommand signUpCommand) {
        var user = new User(1L, signUpCommand.name());
        logger.info("Sign up: {}", signUpCommand);
        return user;
    }
}
