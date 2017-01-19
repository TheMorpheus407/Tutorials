public class Communicator {
	volatile boolean flag = false;
	volatile String s = "";

	public void q(String msg) {
		while (flag) {
		}
		System.out.println(msg);
		flag = true;

	}

	public void a(String msg) {
		while (!flag) {
		}
		System.out.println(msg);
		flag = false;

	}

	public static void main(String[] args) {
		Communicator c = new Communicator();

		new Thread(new Thread2(c)).start();
		new Thread(new Thread1(c)).start();
	}
}
