package digytal.myfriends.restapi.infra.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Response {
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	LocalDateTime dateTime = LocalDateTime.now();
	boolean success;
	String message;
	Serializable code;
	Object body;
	String suggestion;
	Response() {
		
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Serializable getCode() {
		return code;
	}

	public Object getBody() {
		return body;
	}

	public String getSuggestion() {
		return suggestion;
	}


}
