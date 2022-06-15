package dev.example.yuriiu;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class SessionEndedHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(requestType(SessionEndedRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        System.out.println("onSessionEnded requestId={}, sessionId={} " + handlerInput.getRequest().getRequestId()
                + " - " + handlerInput.getRequestEnvelope().getSession().getSessionId());
        return Optional.empty();
    }
}
