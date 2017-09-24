package com.sofrecom.hackathon;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.sofrecom.hackathon.model.Article;

@Component
public class ArticleNotificationHandler extends TextWebSocketHandler {

    WebSocketSession session;

    public void createArticleCallback(Article article) {
        System.out.println("Trying to send:" + article.getTitle());
        if (session != null && session.isOpen()) {
            try {
                System.out.println("Now sending:" + article.getTitle());
                session.sendMessage(new TextMessage("{\"title\": \"" + article.getTitle() + "\","
                		+ " \"summary\" : \""+article.getSummary()+"\"}"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Don't have open session to send");
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection established");
        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
            session.close();
        } else {
            System.out.println("Received:" + message.getPayload());
        }
    }
}
