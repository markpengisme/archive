package ch12;
// 5. Test Abstract
abstract class AbstractFactory {
	abstract String getProductName();
	void createProduct() {
		System.out.println(getProductName() + " is created!!");
	}
}

class SubFactory1 extends AbstractFactory {
	@Override
	String getProductName() {
		return "computer";
	}
}

class SubFactory2 extends AbstractFactory {
	@Override
	String getProductName() {
		return "television";
	}
}

public class TestAbstract {

	public static void main(String[] args) {
		SubFactory1 f1 = new SubFactory1();
		f1.createProduct();
		SubFactory2 f2 = new SubFactory2();
		f2.createProduct();
	}

}
