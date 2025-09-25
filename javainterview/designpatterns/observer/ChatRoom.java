package javainterview.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

// Subject (Publisher)
class ChatRoom {
    private List<Observer> users = new ArrayList<>();

    public void join(Observer user) {
        users.add(user);
    }

    public void sendMessage(String message) {
        for (Observer user : users) {
            user.update(message);
        }
    }
}