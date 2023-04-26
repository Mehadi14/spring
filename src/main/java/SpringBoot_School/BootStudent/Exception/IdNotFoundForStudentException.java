package SpringBoot_School.BootStudent.Exception;

public class IdNotFoundForStudentException extends RuntimeException {

	
	String sms="Id not found for Student";

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public IdNotFoundForStudentException(String sms) {
		super();
		this.sms = sms;
	}

	public IdNotFoundForStudentException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
