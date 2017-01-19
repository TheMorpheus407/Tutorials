public class Blubb {
	boolean flag = false;
	boolean flag2 = true;

	public synchronized void first() {
		if (flag2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if (flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		System.out.println("ich bin der erste.");
		flag2 = true;
		flag = true;
		notify(); //DEADLOCK
	}

	public synchronized void second() {
		if (!flag2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		System.out.println("ich bin der zweite.");
		flag2 = false;
		flag = false;
		notify();
	}
}
