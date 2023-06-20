package lambda.stream;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-03 Time: 02:48
 * Description:
 */
public class Student {
	private int id;
	private int age;
	private String name;
	private String address;

	public Student() {
	}

	public Student(int id, int age, String name, String address) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		System.out.println(name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
