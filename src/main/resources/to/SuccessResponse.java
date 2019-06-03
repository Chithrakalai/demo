package to;

public class SuccessResponse {
	
	private String status;
	SSNDetails ssndetails;
	bank_account bnk;
	credit_card ccd;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SSNDetails getSsndetails() {
		return ssndetails;
	}
	public void setSsndetails(SSNDetails ssndetails) {
		this.ssndetails = ssndetails;
	}
	public bank_account getBnk() {
		return bnk;
	}
	public void setBnk(bank_account bnk) {
		this.bnk = bnk;
	}
	public credit_card getCcd() {
		return ccd;
	}
	public void setCcd(credit_card ccd) {
		this.ccd = ccd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bnk == null) ? 0 : bnk.hashCode());
		result = prime * result + ((ccd == null) ? 0 : ccd.hashCode());
		result = prime * result
				+ ((ssndetails == null) ? 0 : ssndetails.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SuccessResponse other = (SuccessResponse) obj;
		if (bnk == null) {
			if (other.bnk != null)
				return false;
		} else if (!bnk.equals(other.bnk))
			return false;
		if (ccd == null) {
			if (other.ccd != null)
				return false;
		} else if (!ccd.equals(other.ccd))
			return false;
		if (ssndetails == null) {
			if (other.ssndetails != null)
				return false;
		} else if (!ssndetails.equals(other.ssndetails))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuccessResponse [status=" + status + ", ssndetails="
				+ ssndetails + ", bnk=" + bnk + ", ccd=" + ccd + "]";
	}
	
}
