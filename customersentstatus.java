import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;

public class SendEmailFunction {
    @FunctionName("sendemail")
    public void run(
            @EventHubTrigger(name = "event", eventHubName = "deliverystatus", connection = "EventHubConnection") String event,
            @SendGridOutput(name = "output", to = "{Email}", subject = "Delivery Status Update", apiKey = "SendGridApiKey") OutputBinding<String> output,
            final ExecutionContext context) {

        context.getLogger().info("Java Event Hub trigger function processed a message: " + event);

        // Parse the event data to extract the email and delivery status update
        String[] parts = event.split(";");
        String email = parts[0];
        String status = parts[1];

        // Send an email to the customer with the delivery status update
        output.setValue("Delivery Status Update: " + status);
    }
}
