package ch12;
// 4. test Override
class Deeper {
	public Number getDepth(Number n) {
		return 10;
	}
}

// class DeepA extends Deeper {
// 	@Override
// 	protected Integer getDepth(Number n) {
// 		return 5;
// 	}
// }

class DeepB extends Deeper {
	@Override
	public Double getDepth(Number n) {
		return 5d;
	}
}

// class DeepC extends Deeper {
// 	@Override
// 	public String getDepth(Number n) {
// 		return "";
// 	}
// }

// class DeepD extends Deeper {
// 	@Override
// 	public Long getDepth(int d) {
// 		return 5L;
// 	}
// }

// class DeepE extends Deeper {
// 	@Override
// 	public Short getDepth(Integer n) {
// 		return 5;
// 	}
// }

// class DeepF extends Deeper {
// 	@Override
// 	public Object getDepth(Object n) {
// 		return 5;
// 	}
// }

public class TestOverride {
	public static void main(String[] args) {
		DeepB b = new DeepB();
		System.out.println(b.getDepth(123));
	}
}
