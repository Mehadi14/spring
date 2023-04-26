package SpringBoot_School.BootStudent.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import SpringBoot_School.BootStudent.util.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler {
	
	
	@ExceptionHandler(IdNotFoundForStudentException.class)
	public ResponseEntity<ResponseStructure<String>> idNotfoundStudent(IdNotFoundForStudentException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getSms());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("no id for that student");
		
		return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(IdNotFoundForSchoolException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundForSchoolException(IdNotFoundForSchoolException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData(exception.getSms());
		structure.setMessage("id not found for the school");
		structure.setStatus(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK) ;
		
	}
	
}
