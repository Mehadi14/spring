package SpringBoot_School.BootStudent.util;

import org.springframework.http.ResponseEntity;


import lombok.Data;

@Data
public class ResponseStructure<T> {
	

	private String message;
	private int status;
	private T data;
	

}
