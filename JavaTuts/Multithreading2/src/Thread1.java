
public class Thread1 implements Runnable{
	Communicator c;
	
	public Thread1(Communicator c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.q("Wie gehts dir?");
		c.q("Was ist los?");
		c.q("willst du zocken?");
	}

}
