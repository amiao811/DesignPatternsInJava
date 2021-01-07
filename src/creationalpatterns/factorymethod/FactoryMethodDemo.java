package creationalpatterns.factorymethod;

/**
 * Factory Method Pattern Demo
 * Definition:
 * Define an interface for creating an object,but let subclasses decide which class to
 * instantiate.Factory Method lets a class defer instantiation to subclasses
 */

// Product
abstract class Message {
    public abstract String getContent();

    public void addDefaultHeaders(){
        // Adds some default headers
    }
    public void encrypt() {
        // Has some code to encrypt the content
    }
}

class TextMessage extends Message {
    @Override
    public String getContent() {
        return "Text Message";
    }
}

class JSONMessage extends Message {
    @Override
    public String getContent() {
        return "JSON Message";
    }
}

// Creator

/**
 * This is called by clients
 */
abstract class MessageCreator {
    public Message getMessage() {
        Message msg = createMessage();
        // business logic write here
        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;
    }

    /**
     * Subclasses must provide implementation for this & return a specific Message subclass.
     * @return
     */
    protected abstract Message createMessage();
}

class TextCreator extends MessageCreator {
    @Override
    protected Message createMessage() {
        return new TextMessage();
    }
}

class JSONCreator extends MessageCreator {
    @Override
    protected Message createMessage() {
        return new JSONMessage();
    }
}

// Client
public class FactoryMethodDemo {
    public static void main(String[] args) {
        printMessage(new JSONCreator());
        printMessage(new TextCreator());
    }
    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println("content = " + msg.getContent());
    }
}
