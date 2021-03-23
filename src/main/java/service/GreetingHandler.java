package service;

import java.io.IOException;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GreetingHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        try {
            Thread.sleep(3000); // simulated delay
            TextMessage msg = new TextMessage("Hello, " + message.getPayload() + "!");
            session.sendMessage(msg);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
