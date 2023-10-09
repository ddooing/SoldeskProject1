package artDB;

public class MyGallery {
	String aName;
	String time;
	String car;	// 캘린더

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public MyGallery() {
		// TODO Auto-generated constructor stub
	}
	
	public MyGallery(String aName, String time, String car) {
		this.aName = aName;
		this.time = time;
		this.car = car;
	}
	
}
