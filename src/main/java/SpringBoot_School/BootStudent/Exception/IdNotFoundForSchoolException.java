package SpringBoot_School.BootStudent.Exception;

public class IdNotFoundForSchoolException extends RuntimeException {
	
	
	String sms="id not found for school";

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	@Override
	public String toString() {
		return "IdNotFoundForSchoolException [sms=" + sms + "]";
	}

	public IdNotFoundForSchoolException(String sms) {
		super();
		this.sms = sms;
	}

	public IdNotFoundForSchoolException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
