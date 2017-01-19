public class Sub {
	
	public static void main(String args[])
	{
		Super s = new Super();
		Super.B b = s.new B();
		System.out.println(b.getX());
		b.foo();
		
		System.out.println(b.getX());
	}

}
