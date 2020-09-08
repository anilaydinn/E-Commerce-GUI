
public class Customer extends User {

	private String name;
	private String surname;
	private int age;
	private String gender;
	private String address;
	private String phone;
	private String city;
	private String country;
	
	public Customer(String username, String password, String name, String surname, int age, String gender, String address, String phone, String city, String country) {
		super(username, password);
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer " + name + " " + surname + " " + age + " " + gender + " " + address + " " + phone + " " + city + " " + country;
	}
	
	

}
