public class Gen<T extends Super> {
	public T value;
	
	public void foofoo()
	{
		System.out.println("Gen::foo");
		value.foo();
	}
}