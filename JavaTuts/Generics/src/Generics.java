public class Generics {

	public static void main(String[] args) {
		Gen<Sub> gens = new Gen<>();
		gens.value = new Sub();
		gens.foofoo();
		Gen<Super> g = new Gen<>();
		f(g);
	}

	public static void f(Gen<? super Super> g)
	{
		g.foofoo();
		Super s = g.value;
		g.value = new Sub();
	}
	
	public static <X extends Super> X foo(X x)
	{
		x.foo();
		return x;
	}
}
