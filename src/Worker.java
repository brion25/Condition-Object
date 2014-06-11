import java.util.concurrent.locks.*;


public class Worker implements Runnable{

	private final Lock lock;
	private final Condition condition;
	
	Worker(Lock lock, Condition condition){
		this.lock=lock;
		this.condition=condition;
	}
	
	@Override
	public void run() {
		lock.lock();
		try{
			System.out.println("TRABAJADOR : Demonios! mi jefe todavia no se va!");
			while(Supervisor.isHere){
				condition.await();
			}
			System.out.println("TRABAJADOR : Bien! Ya no esta mi jefe, ya me puedo dormir!");
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}
