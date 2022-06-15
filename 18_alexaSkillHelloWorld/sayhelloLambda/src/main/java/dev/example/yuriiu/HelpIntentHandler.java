package dev.example.yuriiu;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {

        String speechText = "Hello user, You can say hello to me!";

        // Create the Simple card content.
        return handlerInput.getResponseBuilder()
                .withSimpleCard("HelloWorld", speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .build();
    }
}
