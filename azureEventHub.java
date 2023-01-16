import com.microsoft.azure.eventhubs.*;
import com.microsoft.azure.eventhubs.lib.*;

public class SendDeliveryStatus {
    public static void main(String[] args) throws Exception {
        // Create a connection string to the Event Hub
        String connectionString = "Endpoint=sb://<your-namespace>.servicebus.windows.net/;SharedAccessKeyName=<your-key-name>;SharedAccessKey=<your-key>";

        // Create an Event Hub client
        EventHubClient client = EventHubClient.createFromConnectionStringSync(connectionString);

        // Create a message
        String message = "customer@email.com;Order Placed";

        // Send the message to the Event Hub
        client.sendSync(EventData.create(message.getBytes("UTF-8")));

        // Close the Event Hub client
        client.closeSync();
    }
}

