package javainterview.designpatterns.observer;



// Concrete observer
class User implements Observer {
    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
    private String name;

    public User(String name) {
        this.name = name;
    }

//    public void update(String message) {
//        System.out.println(name + " received: " + message);
//    }
}
