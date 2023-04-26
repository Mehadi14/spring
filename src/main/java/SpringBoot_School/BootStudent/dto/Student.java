package SpringBoot_School.BootStudent.dto;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity(name = "Student_Details")
public class Student {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name = "FirstName")
	private String name ;
//	@Column(name = "Last_Name")
	private String lname;
	private long phone;
	private String email;
	private long fees;
		@ManyToOne
		private School school;
	
	
}
