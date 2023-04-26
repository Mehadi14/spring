package SpringBoot_School.BootStudent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringBoot_School.BootStudent.Exception.IdNotFoundForSchoolException;
import SpringBoot_School.BootStudent.dao.Schooldao;
import SpringBoot_School.BootStudent.dto.School;
import SpringBoot_School.BootStudent.util.ResponseStructure;

@Service
public class SchoolService {

	@Autowired
	private Schooldao schooldao;

	public ResponseEntity<ResponseStructure<School>> saveSchool(School school) {
		ResponseStructure<School> structure = new ResponseStructure<>();
		School school2 = schooldao.saveSchool(school);

		structure.setMessage("saved school");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(school2);

		return new ResponseEntity<ResponseStructure<School>>(structure, HttpStatus.CREATED);
	}

public ResponseEntity<ResponseStructure<School>> getByIdSchool(int sid)
{
	ResponseStructure<School> structure=new ResponseStructure<>();
	School school=schooldao.getSchoolById(sid);
	if(school!=null)
	{
	structure.setMessage("Successfully school fetched");
	structure.setData(school);
	structure.setStatus(HttpStatus.OK.value());
	
	return new ResponseEntity<ResponseStructure<School>>(HttpStatus.OK.FOUND);
	}
	
else

	{
		throw new IdNotFoundForSchoolException("id not present for that input "+ sid);
	}
}
}
