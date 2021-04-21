package de.luleu.bankoedit.exeptions;


public abstract class EditException extends Exception {

    private final String message;

    protected EditException() {
        this.message = "";
    }

    /**
     * Create a new exception with a message.
     *
     * @param message the message
     */
    protected EditException(String message) {
        super(message);

        this.message = message;
    }

    /**
     * Create a new exception with a cause.
     *
     * @param cause the cause
     */
    protected EditException(Throwable cause) {
        super(cause);

        this.message = "";
    }

}
