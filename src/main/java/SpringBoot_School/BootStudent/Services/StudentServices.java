package SpringBoot_School.BootStudent.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringBoot_School.BootStudent.Exception.IdNotFoundForStudentException;
import SpringBoot_School.BootStudent.dao.Studentdao;
import SpringBoot_School.BootStudent.dto.Student;
import SpringBoot_School.BootStudent.util.ResponseStructure;

@Service
public class StudentServices {

	@Autowired
	private Studentdao dao;

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student, int sid) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setMessage("succesfully details svaed");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student, sid));

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Student student2 = dao.updateStudentStu(id, student);
		if (student2 != null) {
			structure.setMessage("successfully saved");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student2);

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else

			throw new IdNotFoundForStudentException();
	}

	public ResponseEntity<ResponseStructure<Student>> getStudentById(int id) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Student student = dao.getStudentById(id);
		if (student != null) {
			structure.setMessage("student found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND.OK);
		} else

			throw new IdNotFoundForStudentException("id not found for std to fetch");
	}

	public ResponseEntity<ResponseStructure<Student>> findByName(String name) {
		ResponseStructure<Student> structure = new ResponseStructure<>();

		Student student = dao.findByName(name);

		if (student != null) {
			structure.setMessage("fetched student by name succ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		} else {

			structure.setMessage("name not found std");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.NOT_FOUND.OK);

		}
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudnet(int id) {

		ResponseStructure<Student> structure = new ResponseStructure<>();
		Student student = dao.deleteStudent(id);
		if (student != null) {
			structure.setMessage("std deleted sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			structure.setMessage("id  not found std for dele");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.NOT_FOUND.OK);

		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByfees(long fees) {
		ResponseStructure<List<Student>> structure1 = new ResponseStructure<>();
		List<Student> student =dao.findByFees(fees);

		structure1.setMessage("all feched based on fees");
		structure1.setStatus(HttpStatus.OK.value());
		structure1.setData(student);

		return new ResponseEntity<ResponseStructure<List<Student>>>(structure1, HttpStatus.OK);
	}
	
	

}
