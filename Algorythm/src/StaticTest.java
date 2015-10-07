
public class StaticTest {
	
	public StaticTest() {
		System.out.println("1");
	}
	
	public static void main(String[] args) {
		Child c = new Child();
	}
	
}

class Child extends StaticTest {
	public Child() {
		// TODO Auto-generated constructor stubs
		super();
		System.out.println("asdfadsf");
	}
}

