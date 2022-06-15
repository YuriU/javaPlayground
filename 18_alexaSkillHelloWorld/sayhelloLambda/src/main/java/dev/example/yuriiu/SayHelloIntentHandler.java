package dev.example.yuriiu;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class SayHelloIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("SayHelloIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        System.out.println("onIntent requestId={}, sessionId={} " + handlerInput.getRequest().getRequestId()
                + " - " + handlerInput.getRequestEnvelope().getSession().getSessionId());

        String speechText = "Hello how to do in java user. It's a pleasure to talk with you. "
                + "Currently I can only say simple things, "
                + "but you can educate me to do more complicated tasks later. Happy to learn.";

        return handlerInput.getResponseBuilder()
                .withSimpleCard("HelloWorld", speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .build();
    }
}
