package pojo;

import java.util.List;

public class TC001_GetCustomerListPOJO {
	
	private int status;
	private String message;
	private List<TC001_GetCustomerListResultPOJO> result;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<TC001_GetCustomerListResultPOJO> getResult() {
		return result;
	}
	public void setResult(List<TC001_GetCustomerListResultPOJO> result) {
		this.result = result;
	}

}
