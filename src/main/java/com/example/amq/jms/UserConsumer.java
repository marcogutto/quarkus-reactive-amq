package com.example.amq.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.example.amq.domain.dto.UserDTO;
import com.example.amq.service.UserService;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class UserConsumer {

    @Inject
    private UserService userService;

    private final Logger logger = Logger.getLogger(UserConsumer.class);

    @Incoming("user-in")
    @Blocking
    public void receive(UserDTO userDTO) {

        logger.infof("Save a user with id: %s", userDTO.getId());
        
        userService.save(userDTO);
        
    }
}