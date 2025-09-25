package javainterview.designpatterns.observer;

import javainterview.designpatterns.factory.Shape;

// Concrete observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}
