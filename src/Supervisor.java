import java.util.concurrent.locks.*;


public class Supervisor {

	/**
	 * @param args
	 */
	
	static boolean isHere=true;
	
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition workerCondition = lock.newCondition();
		
		Worker worker = new Worker(lock, workerCondition);
		Manager manager = new Manager(lock, workerCondition);
		
		new Thread(worker).start();
		new Thread(manager).start();
	}

}
