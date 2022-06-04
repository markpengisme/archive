package ch12.interfaceExample;
// 8. interface example
public class ReturnClothing {

	public static void main(String[] args) {
		Returnable r;
		r = new Shirt('L', 1, "my shirt", 'B', 1000.5);
		r.doReturn();

		r = new Trousers('M', 1, "my trouser", 'B', 1200.5);
		r.doReturn();

	}

}
