package com.example.amq.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.amq.domain.dto.UserDTO;
import com.example.amq.jms.UserProducer;

import io.smallrye.mutiny.Uni;

@Path("/users")
public class UserResource {

    @Inject
	private UserProducer producer;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Uni<Response> save(UserDTO userDTO) {
		
		producer.send(userDTO);
		
		return Uni.createFrom().item(Response.status(Response.Status.CREATED)
			.entity(userDTO).build());
		
	}
}