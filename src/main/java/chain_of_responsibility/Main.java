package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        CustomerFeedbackHandler primaryHandler;

        CustomerFeedbackHandler compensationHandler = new CompensationHandler();
        CustomerFeedbackHandler contactHandler = new ContactHandler();
        CustomerFeedbackHandler devSuggestionHandler = new DevSuggestionHandler();
        CustomerFeedbackHandler genFeedbackHandler = new GenFeedbackHandler();

		primaryHandler = compensationHandler;

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(devSuggestionHandler);
        devSuggestionHandler.setNextHandler(genFeedbackHandler);
        
        // Sends a compensation claim message to the handler chain
        Message compensation = new Message(MessageType.COMPENSATION_CLAIM, "This is a compensation claim for damage", "test@test.com");
        primaryHandler.process(compensation);

        // Sends a contact request message to the handler chain
        Message contact = new Message(MessageType.CONTACT_REQUEST, "This is a contact request", "test@test.com");
        primaryHandler.process(contact);

        // Sends a development suggestion message to the handler chain
        Message devSuggestion = new Message(MessageType.DEVELOPMENT_SUGGESTION, "This is a development suggestion about a bug", "test@test.com");
        primaryHandler.process(devSuggestion);

        // Sends general feedback message to the handler chain
        Message genFeedback = new Message(MessageType.GENERAL_FEEDBACK, "This is general feedback. Thank you!", "test@test.com");
        primaryHandler.process(genFeedback);
    }
}
