import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class Manager implements Runnable{

	private final Lock lock;
	private final Condition condition;
	
	Manager(Lock lock, Condition condition){
		this.lock=lock;
		this.condition=condition;
	}
	
	@Override
	public void run() {
		lock.lock();
		try{
			System.out.println("MANAGER : Creo que necesito a mi supervisor, lo llamare...");
			Thread.sleep(3000);
			Supervisor.isHere=false;
			condition.signal();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}
