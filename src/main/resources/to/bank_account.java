package to;

import java.util.Date;

public class bank_account {
	
	public String account_no;
	public String account_type;
	public float amount;
	public Date created_date;
	public Date last_modified_date;
	public int user_id;
	public String name;
	public String routing_no;
	public String ssn;
	public String status;
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRouting_no() {
		return routing_no;
	}
	public void setRouting_no(String routing_no) {
		this.routing_no = routing_no;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((account_no == null) ? 0 : account_no.hashCode());
		result = prime * result
				+ ((account_type == null) ? 0 : account_type.hashCode());
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result
				+ ((created_date == null) ? 0 : created_date.hashCode());
		result = prime
				* result
				+ ((last_modified_date == null) ? 0 : last_modified_date
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((routing_no == null) ? 0 : routing_no.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + user_id;
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
		bank_account other = (bank_account) obj;
		if (account_no == null) {
			if (other.account_no != null)
				return false;
		} else if (!account_no.equals(other.account_no))
			return false;
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (created_date == null) {
			if (other.created_date != null)
				return false;
		} else if (!created_date.equals(other.created_date))
			return false;
		if (last_modified_date == null) {
			if (other.last_modified_date != null)
				return false;
		} else if (!last_modified_date.equals(other.last_modified_date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (routing_no == null) {
			if (other.routing_no != null)
				return false;
		} else if (!routing_no.equals(other.routing_no))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "bank_account [account_no=" + account_no + ", account_type="
				+ account_type + ", amount=" + amount + ", created_date="
				+ created_date + ", last_modified_date=" + last_modified_date
				+ ", user_id=" + user_id + ", name=" + name + ", routing_no="
				+ routing_no + ", ssn=" + ssn + ", status=" + status + "]";
	}
	

}
