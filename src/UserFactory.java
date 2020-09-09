
public class UserFactory {

	public IUser getUser(String userType) {
		if(userType == null) {
			return null;
		}
		if(userType.equalsIgnoreCase("ADMIN")) {
			return new Admin();
		}
		else if(userType.equalsIgnoreCase("CUSTOMER")) {
			return new Customer();
		}
		return null;
	}
}
