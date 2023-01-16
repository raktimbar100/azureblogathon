import com.microsoft.azure.servicebus.*;
import com.microsoft.azure.servicebus.primitives.*;

public class SendDeliveryStatus {
    public static void main(String[] args) throws Exception {
        // Create a connection string to the Service Bus
        String connectionString = "Endpoint=sb://<your-namespace>.servicebus.windows.net/;SharedAccessKeyName=<your-key-name>;SharedAccessKey=<your-key>";

        // Create a queue client
        QueueClient queueClient = new QueueClient(new ConnectionStringBuilder(connectionString, "<your-queue-name>"));

        // Create a message
        String message = "customer@email.com;Order Placed";

        // Send the message to the queue
        queueClient.send(new Message(message.getBytes("UTF-8")));

        // Close the queue client
        queueClient.close();
    }
}

