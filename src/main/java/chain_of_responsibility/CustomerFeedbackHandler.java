package chain_of_responsibility;

public abstract class CustomerFeedbackHandler {
    private CustomerFeedbackHandler nextHandler;

    public void process(Message message) {
        if (nextHandler != null) {
            nextHandler.process(message);
        }
    }

    public void setNextHandler(CustomerFeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
