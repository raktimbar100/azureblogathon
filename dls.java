import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.storage.queue.*;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.queue.QueueRequestOptions;

public class DeliveryStatusFunction {
    @FunctionName("deliverystatus")
    public void run(
            @QueueTrigger(name = "message", queueName = "deliverystatus", connection = "StorageConnection") String message,
            @QueueOutput(name = "output", queueName = "deliverystatus", connection = "StorageConnection") OutputBinding<String> output,
            final ExecutionContext context) {

        context.getLogger().info("Java Queue trigger function processed a message: " + message);

        String[] parts = message.split(";");
        String email = parts[0];
        String status = parts[1];

        // Use the Azure SDK for Java to send an email using Azure SendGrid or Azure Email service
        // code to send email

        output.setValue(status);
    }
}
