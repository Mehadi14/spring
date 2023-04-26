package SpringBoot_School.BootStudent.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SpringBoot_School.BootStudent.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {


	@Query("select c from Student c where c.Fees>?1")
	public List<Student> findByFees(long fee);

	public Student findByName(String name);

}
