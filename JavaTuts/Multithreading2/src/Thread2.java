
public class Thread2 implements Runnable{
	Communicator c;
	
	public Thread2(Communicator c) {
		this.c = c;
	}

	@Override
	public void run() {
		c.a("gut");
		c.a("langeweile");
		c.a("UT3");
	}
}
