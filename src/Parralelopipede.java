import exia.ipc.entities.MachineZ;
import exia.ipc.entities.Product;

public class Parralelopipede {

	public Machine_Thread m1_thread;
	public Machine_Thread m2_thread;
	public Machine_Thread m3_thread;
	
	public Parralelopipede(MachineZ m1, MachineZ m2, MachineZ m3, Product product) 
	{
		this.m1_thread = new Machine_Thread(m1, product);
		this.m2_thread = new Machine_Thread(m2, product);
		this.m3_thread = new Machine_Thread(m3, product);
	}
	
	public void init() {
		m1_thread.start();
		m2_thread.start();
		m3_thread.start();
	}
	
	public boolean is_alive() {
		
		if(isTerminated(m1_thread) && isTerminated(m2_thread) && isTerminated(m3_thread)) {
			return false;
		}
		else 
			return true;
	}
	
	private boolean isTerminated(Machine_Thread machine) {
		if(machine.isAlive()) {
			return false;
		}
		else
			return true;
		
	}
	
	
	
}
