package creationalpatterns.abstractfactory;

import java.lang.ref.Cleaner;

/**
 * Abstract factory
 */

//--- Abstract product & factory
// Represents an abstract product
interface Storage {
    String getId();
}

// Represents an abstract product
interface Instance {
    enum Capacity{micro, small, large}
    public void start();
    public void stop();
    public void attachStorage(Storage storage);
}

// Abstract factory with method defined for each objext type.
interface ResourceFactory {
    public Instance createInstance(Instance.Capacity capacity);
    public Storage creatStorage(int capMib);
}

//--- Implement product & factory

// AWS
// Implement Abstract product (Interface Storage & Interface Instance)
class S3Storage implements Storage {
    public S3Storage(int capacityInMib) {
        System.out.println("Allocated " + capacityInMib + "on S3");
    }
    @Override
    public String getId() {
        return "S3 1";
    }

    @Override
    public String toString() {
        return "S3 Storage";
    }
}

class EC2Instace implements Instance {
    public EC2Instace(Capacity capacity) {
        System.out.println("Create EC2Instace");
    }

    @Override
    public void start() {
        System.out.println("EC2Instace start");
    }

    @Override
    public void stop() {
        System.out.println("EC2Instace stop");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached "+storage+" to Ec2Instance");
    }
}

// implement Interface ResourceFactory
class AWSResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new EC2Instace(capacity);
    }
    @Override
    public Storage creatStorage(int capMib) {
        return new S3Storage(capMib);
    }
}

// GCP
// Implement Abstract product (Interface Storage & Interface Instance)
class GoogleCloudStorage implements Storage {
    public GoogleCloudStorage(int capacityInMib) {
        System.out.println("Allocated "+capacityInMib+" on Google Cloud Storage");
    }

    @Override
    public String getId() {
        return "GCP 1";
    }
    @Override
    public String toString() {
        return "Google cloud storage";
    }
}
class GoogleComputeEngineInstace implements Instance {
    public GoogleComputeEngineInstace(Capacity capacity) {
        System.out.println("Created Google Compute Engine instance");
    }

    @Override
    public void start() {
        System.out.println("Compute engine instance started");
    }

    @Override
    public void stop() {
        System.out.println("Compute engine instance stopped");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached "+storage+" to Compute engine instance");
    }
}

// implement Interface ResourceFactory
class GoogleResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstace(capacity);
    }

    @Override
    public Storage creatStorage(int capMib) {
        return new GoogleCloudStorage(10);
    }
}

// Client
class Client {
    private ResourceFactory factory;
    public Client(ResourceFactory factory) {
        this.factory = factory;
    }
    public Instance createServer(Instance.Capacity cap, int storageInMib) {
        Instance instance = factory.createInstance(cap);
        Storage storage = factory.creatStorage(storageInMib);
        instance.attachStorage(storage);
        return instance;
    }

    public static void main(String[] args) {
        // create AWS server
        Client awsClient = new Client(new AWSResourceFactory());
        Instance awsServer = awsClient.createServer(Instance.Capacity.small, 20480);
        awsServer.start();
        awsServer.stop();

        System.out.println("-----------------");
        // create GCP server
        Client gcpClient = new Client(new GoogleResourceFactory());
        Instance gcpServer = gcpClient.createServer(Instance.Capacity.micro, 20480);
        gcpServer.start();
        gcpServer.stop();
    }
}

public class AbstractFactoryDemo {
}
