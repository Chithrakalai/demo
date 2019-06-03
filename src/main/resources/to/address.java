package to;

public class address {

	private String id;
	private String city;
	private String state;
	private String street;
	private int user_id;
private String	zip;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	result = prime * result + ((street == null) ? 0 : street.hashCode());
	result = prime * result + user_id;
	result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
	address other = (address) obj;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (street == null) {
		if (other.street != null)
			return false;
	} else if (!street.equals(other.street))
		return false;
	if (user_id != other.user_id)
		return false;
	if (zip == null) {
		if (other.zip != null)
			return false;
	} else if (!zip.equals(other.zip))
		return false;
	return true;
}
@Override
public String toString() {
	return "address [id=" + id + ", city=" + city + ", state=" + state
			+ ", street=" + street + ", user_id=" + user_id + ", zip=" + zip
			+ "]";
}

	
}
