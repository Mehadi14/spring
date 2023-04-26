package SpringBoot_School.BootStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot_School.BootStudent.Services.SchoolService;
import SpringBoot_School.BootStudent.dto.School;
import SpringBoot_School.BootStudent.util.ResponseStructure;

@RestController
public class SchoolContoller {
@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/school")
	public ResponseEntity<ResponseStructure<School>> saveSchool( @RequestBody School school)
	{
		return schoolService.saveSchool(school);
		
	}
	
	@GetMapping("/school")
	public ResponseEntity<ResponseStructure<School>> getByIdSchool(@PathVariable int sid)
	{
		return schoolService.getByIdSchool(sid);
	}
	
}
