package chain_of_responsibility;

public class GenFeedbackHandler extends CustomerFeedbackHandler {
    @Override
	// General feedback can be analyzed and responded to
    public void process(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Type: " + message.getType());
            System.out.println("Email: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());

            if (message.getContent().toLowerCase().contains("thank")) {
                System.out.println("Handler: Positive feedback. Thank you for your feedback!");
            } else {
                System.out.println("Handler: Feedback received. Thank you for your feedback!");
            }
        } else {
            super.process(message);
        }
    }
}
