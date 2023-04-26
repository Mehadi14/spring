package SpringBoot_School.BootStudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot_School.BootStudent.Services.StudentServices;
import SpringBoot_School.BootStudent.dto.Student;
import SpringBoot_School.BootStudent.util.ResponseStructure;
import jakarta.websocket.server.PathParam;
@RestController
public class StudentController {

	@Autowired
    private StudentServices studentServices;
	
	@PostMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student  student ,@RequestParam int sid)
	{
		return studentServices.saveStudent(student, sid);
		
	}
	
	@PutMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id , @RequestBody Student student)
	{
		return studentServices.updateStudent(id, student);
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<Student>> getSudentById(@PathVariable int id)
	{
		return studentServices.getStudentById(id);
		
	}
	
	@GetMapping("/student")
	public ResponseEntity<ResponseStructure<Student>> findByname(@RequestParam String name)
	{
		return studentServices.findByName(name);
		
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id)
	{
		return studentServices.deleteStudnet(id);
		
	}
	@GetMapping("/fetch/{fees}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByFees(@RequestParam long fees)
	{
		return studentServices.findByfees(fees);
		
	}
}
