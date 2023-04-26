package SpringBoot_School.BootStudent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot_School.BootStudent.dto.School;

public interface SchoolRepo extends JpaRepository<School, Integer> {

}
