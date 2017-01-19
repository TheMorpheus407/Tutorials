
public class MyComparable implements Comparable<MyComparable>
{
	int a = 42;
	int b = 123;
	@Override
	public int compareTo(MyComparable o) {
		return this.a - o.a;
	}

}
