package to;



public class SSNDetails {
	private int id;
	private String first_name;
	private String last_name;
	private String created_date;
	private String email;
	private String last_modified_date;
	private String license;
	private String mobile_number;
	private String ssn;
	private int score_equifax;
	private int score_experian;
	private int score_transunion;
	private String msg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCreated_date() {
		return created_date;
	}
	public String getmsg() {
		return msg;
	}
	public void setmsg(String msg) {
		msg = msg;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(String last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getScore_equifax() {
		return score_equifax;
	}
	public void setScore_equifax(int score_equifax) {
		this.score_equifax = score_equifax;
	}
	public int getScore_experian() {
		return score_experian;
	}
	public void setScore_experian(int score_experian) {
		this.score_experian = score_experian;
	}
	public int getScore_transunion() {
		return score_transunion;
	}
	public void setScore_transunion(int score_transunion) {
		this.score_transunion = score_transunion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SSNDetails other = (SSNDetails) obj;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SSNDetails [id=" + id + ", first_name=" + first_name + "]";
	}
	
	
	
	
	
	
}