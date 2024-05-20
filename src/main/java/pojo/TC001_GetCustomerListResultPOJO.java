package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class TC001_GetCustomerListResultPOJO {
	
	 private int customer_id;
	 private String email;
	 private String customer_name;
	 private String mobile_phone;
	 private String photo;
	 private String status;
	 private String registered_on;
	 private String last_visit;
	 private String is_walkin;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegistered_on() {
		return registered_on;
	}
	public void setRegistered_on(String registered_on) {
		this.registered_on = registered_on;
	}
	public String getLast_visit() {
		return last_visit;
	}
	public void setLast_visit(String last_visit) {
		this.last_visit = last_visit;
	}
	public String getIs_walkin() {
		return is_walkin;
	}
	public void setIs_walkin(String is_walkin) {
		this.is_walkin = is_walkin;
	}
}
