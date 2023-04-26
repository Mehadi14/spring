package SpringBoot_School.BootStudent.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import SpringBoot_School.BootStudent.Repo.StudentRepo;
import SpringBoot_School.BootStudent.dto.School;
import SpringBoot_School.BootStudent.dto.Student;
import SpringBoot_School.BootStudent.util.ResponseStructure;

@Repository
public class Studentdao {

	@Autowired
	private StudentRepo  studentRepo;
	@Autowired
	private Schooldao schooldao;
	
	
	
	public Student  saveStudent(Student student , int sid)
	{ 
		School school=schooldao.getSchoolById(sid);
		
		student.setSchool(school);
		return studentRepo.save(student);
	}
	
	public Student updateStudentStu(int id , Student student)
	{  if(studentRepo.findById(id).isPresent()) {
		student.setId(id);
		return studentRepo.save(student);
	}
		else {
			return null;
		}
	}
	
	
	public Student getStudentById(int id)
	{
		if(studentRepo.findById(id).isPresent())
		{
			return studentRepo.findById(id).get();
		}
		else
			return null;
	}
	
	
	public Student findByName(String name)
	{
	 return studentRepo.findByName(name);
		
		
	}
	
	public Student deleteStudent(int id)
	{
		if(studentRepo.findById(id).isPresent())
		{
			Student student=studentRepo.findById(id).get();
			studentRepo.deleteById(id);
//			studentRepo.delete(student);
			
			return student;
		}else
			return null;
	}
	
	public List<Student> findByFees(long fees)
	{
		return studentRepo.findByFees(fees);
	}
}
