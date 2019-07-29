package duke.learn.elibrary.view.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 * @author Kazi
 *
 */
public class Response implements CommonOutput {

    private String message;
    private Status status;

    /**
     * @param message
     * @param status
     */
    public Response(String message, Status status) {
	super();
	this.message = message;
	this.status = status;
    }

    /**
     * 
     */
    public Response() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public static enum Status {
	FAILURE(0), SUCCESS(1);

	private final int status;

	private Status(int status) {
	    this.status = status;
	}

	@JsonValue
	public Integer getStatus() {
	    return status;
	}

	@JsonCreator
	public static Status create(int status) {
	    for (Status s : values()) {
		if (s.getStatus() == status) {
		    return s;
		}
	    }
	    return null;
	}
    }

}
