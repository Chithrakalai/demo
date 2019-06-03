package to;

import java.util.Date;

public class credit_card {
	public String cc_no;
	public String account_type;
	public String cc_type;
	public float available_limit;
	public float cash_limit;
	public String created_date;
	public float credit_limit;
	public String cvv;
	public String expiry_date;
	public String last_modified_date;
	public String name;
	public String ssn;
	public String status;
	public int user_id;
	public String getCc_no() {
		return cc_no;
	}
	public void setCc_no(String cc_no) {
		this.cc_no = cc_no;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getCc_type() {
		return cc_type;
	}
	public void setCc_type(String cc_type) {
		this.cc_type = cc_type;
	}
	public float getAvailable_limit() {
		return available_limit;
	}
	public void setAvailable_limit(float available_limit) {
		this.available_limit = available_limit;
	}
	public float getCash_limit() {
		return cash_limit;
	}
	public void setCash_limit(float cash_limit) {
		this.cash_limit = cash_limit;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public float getCredit_limit() {
		return credit_limit;
	}
	public void setCredit_limit(float credit_limit) {
		this.credit_limit = credit_limit;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(String last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((account_type == null) ? 0 : account_type.hashCode());
		result = prime * result + Float.floatToIntBits(available_limit);
		result = prime * result + Float.floatToIntBits(cash_limit);
		result = prime * result + ((cc_no == null) ? 0 : cc_no.hashCode());
		result = prime * result + ((cc_type == null) ? 0 : cc_type.hashCode());
		result = prime * result
				+ ((created_date == null) ? 0 : created_date.hashCode());
		result = prime * result + Float.floatToIntBits(credit_limit);
		result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
		result = prime * result
				+ ((expiry_date == null) ? 0 : expiry_date.hashCode());
		result = prime
				* result
				+ ((last_modified_date == null) ? 0 : last_modified_date
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		credit_card other = (credit_card) obj;
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (Float.floatToIntBits(available_limit) != Float
				.floatToIntBits(other.available_limit))
			return false;
		if (Float.floatToIntBits(cash_limit) != Float
				.floatToIntBits(other.cash_limit))
			return false;
		if (cc_no == null) {
			if (other.cc_no != null)
				return false;
		} else if (!cc_no.equals(other.cc_no))
			return false;
		if (cc_type == null) {
			if (other.cc_type != null)
				return false;
		} else if (!cc_type.equals(other.cc_type))
			return false;
		if (created_date == null) {
			if (other.created_date != null)
				return false;
		} else if (!created_date.equals(other.created_date))
			return false;
		if (Float.floatToIntBits(credit_limit) != Float
				.floatToIntBits(other.credit_limit))
			return false;
		if (cvv == null) {
			if (other.cvv != null)
				return false;
		} else if (!cvv.equals(other.cvv))
			return false;
		if (expiry_date == null) {
			if (other.expiry_date != null)
				return false;
		} else if (!expiry_date.equals(other.expiry_date))
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
		return "credit_card [cc_no=" + cc_no + ", account_type=" + account_type
				+ ", cc_type=" + cc_type + ", available_limit="
				+ available_limit + ", cash_limit=" + cash_limit
				+ ", created_date=" + created_date + ", credit_limit="
				+ credit_limit + ", cvv=" + cvv + ", expiry_date="
				+ expiry_date + ", last_modified_date=" + last_modified_date
				+ ", name=" + name + ", ssn=" + ssn + ", status=" + status
				+ ", user_id=" + user_id + "]";
	}
	
	
}
