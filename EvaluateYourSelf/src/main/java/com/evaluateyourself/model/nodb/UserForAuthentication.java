package com.evaluateyourself.model.nodb;

public class UserForAuthentication {
	private String usemail;
	private String password;
	
	public UserForAuthentication(){
		
	}

	public String getUsemail() {
		return usemail;
	}

	public void setUsemail(String usemail) {
		this.usemail = usemail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserForAuthentication [usemail=" + usemail + ", password=" + password + "]";
	}
	
}
