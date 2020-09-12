
public class User implements Cloneable {
	
	private String username;
	private String password;
	
	public User(String username, String password) {
				
		this.username = username;
		this.password = password;
	}
	
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Object clone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		}catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
