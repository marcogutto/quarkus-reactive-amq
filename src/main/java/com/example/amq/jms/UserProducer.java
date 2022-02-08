package com.example.amq.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.example.amq.domain.dto.UserDTO;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

@ApplicationScoped
public class UserProducer {

    private final Logger logger = Logger.getLogger(UserProducer.class);
    
    @Inject
    @Channel("user-out")
    Emitter<UserDTO> emitter;

    public void send(UserDTO userDTO) {

        logger.infof("Send a userDTO", userDTO.getId());
        
        emitter.send(userDTO);

    }
}
