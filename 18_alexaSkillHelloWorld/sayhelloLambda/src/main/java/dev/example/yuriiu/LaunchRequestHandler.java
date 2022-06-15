package dev.example.yuriiu;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        System.out.println("onLaunch requestId={}, sessionId={} " + handlerInput.getRequest().getRequestId()
                + " - " + handlerInput.getRequestEnvelope().getSession().getSessionId());

        String speechText = "Welcome to the Alexa World, you can say hello to me, I can respond." +
                "Thanks, How to do in java user.";

        return handlerInput.getResponseBuilder()
                .withSimpleCard(speechText, speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .build();
    }
}
