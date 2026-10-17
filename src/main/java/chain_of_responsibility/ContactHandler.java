package chain_of_responsibility;

public class ContactHandler extends CustomerFeedbackHandler {
    @Override
	// Contact requests can be forwarded to the appropriate department
    public void process(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Type: " + message.getType());
            System.out.println("Email: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
			
            System.out.println("Handler: forwarded to customer service");
        } else {
            super.process(message);
        }
    }
}
