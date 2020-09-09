
public class Car extends Product {
	private int motorVolume;
	private int torque;
	private String type;
	private int numberOfDoors;
	
	
	public Car(String brand,String model, double price,int motorVolume, int torque, String type, int numberOfDoors) {
		super(brand,model,price);
		this.motorVolume = motorVolume;
		this.torque = torque;
		this.type = type;
		this.numberOfDoors = numberOfDoors;
	}


	public int getMotorVolume() {
		return motorVolume;
	}


	public void setMotorVolume(int motorVolume) {
		this.motorVolume = motorVolume;
	}


	public int getTorque() {
		return torque;
	}


	public void setTorque(int torque) {
		this.torque = torque;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNumberOfDoors() {
		return numberOfDoors;
	}


	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
}
