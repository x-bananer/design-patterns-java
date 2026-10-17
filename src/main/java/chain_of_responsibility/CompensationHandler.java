package chain_of_responsibility;

public class CompensationHandler extends CustomerFeedbackHandler {
    @Override
	// Compensation claims can be reviewed and approved or rejected
    public void process(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Type: " + message.getType());
            System.out.println("Email: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());

            // Example rule: a claim must mention damage to be approved.
            if (message.getContent().toLowerCase().contains("damage")) {
                System.out.println("Handler: claim approved");
            } else {
                System.out.println("Handler: claim rejected");
            }
        } else {
            super.process(message);
        }
    }
}
