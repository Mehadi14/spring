package SpringBoot_School.BootStudent.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringBoot_School.BootStudent.Repo.SchoolRepo;
import SpringBoot_School.BootStudent.dto.School;

@Repository
public class Schooldao {
	
	@Autowired
	private SchoolRepo schoolRepo;
	
	public School saveSchool(School school)
	{
		return schoolRepo.save(school);
	}

	public School getSchoolById(int sid) {
		
		return schoolRepo.findById(sid).get();
	}
	
	
	
	
	
	

}
