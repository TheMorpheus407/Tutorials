
public class Main {

	public static void main(String[] args) {
		Fifo f = new Fifo();
		f.push("dsa");
		f.push("wasd");
		System.out.println(f.pop());
		System.out.println(f.pop());
		System.out.println(f.pop());
	}

}
