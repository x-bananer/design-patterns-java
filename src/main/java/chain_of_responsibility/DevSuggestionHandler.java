package chain_of_responsibility;

public class DevSuggestionHandler extends CustomerFeedbackHandler {
    @Override
	// Development suggestions can be logged and prioritized
    public void process(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Type: " + message.getType());
            System.out.println("Email: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());

            // Example rule: suggestions mentioning a bug have high priority.
            if (message.getContent().toLowerCase().contains("bug")) {
                System.out.println("Handler: suggestion logged, high priority");
            } else {
                System.out.println("Handler: suggestion logged, normal priority");
            }
        } else {
            super.process(message);
        }
    }
}
