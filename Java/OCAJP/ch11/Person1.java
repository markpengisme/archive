package ch11;
// 1. private field + getter & setter
public class Person1 {

	private int age;

	public void setAge(int age) {
		if (age >= 1 && age <= 120)
			this.age = age;
	}

	public int getAge() {
		return this.age;
	}

}