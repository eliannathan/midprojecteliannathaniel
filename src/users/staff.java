package users;

public class staff extends user{
	
	protected String staff_id,staff_job;

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_job() {
		return staff_job;
	}

	public void setStaff_job(String staff_job) {
		this.staff_job = staff_job;
	}

	public staff(String name, String password, String staff_id, String staff_job) {
		super(name, password);
		this.staff_id = staff_id;
		this.staff_job = staff_job;
	}
	
	
		
}
