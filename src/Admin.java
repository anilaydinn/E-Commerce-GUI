
public class Admin extends User implements IUser {
	
	public Admin(String username, String password) {
		
		super(username, password);
	}
	
	public Admin() {}

	@Override
	public String writeInformation() {
		return getUsername() + " is admin.";
	}
}
