package com.example.amq.jms;

import java.lang.reflect.Type;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Message;

import io.smallrye.reactive.messaging.MessageConverter;
import io.smallrye.reactive.messaging.amqp.IncomingAmqpMetadata;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class JsonToObjectConverter implements MessageConverter {

    @Override
    public boolean canConvert(Message<?> in, Type target) {
        return in.getMetadata(IncomingAmqpMetadata.class)
                .map(meta -> meta.getContentType().equals(MediaType.APPLICATION_JSON)  && target instanceof Class)
                .orElse(false);

    }

    @Override
    public Message<?> convert(Message<?> in, Type target) {
        return in.withPayload(((JsonObject) in.getPayload()).mapTo((Class<?>) target));
    }
}
