import java.util.concurrent.Semaphore;

import exia.ipc.entities.IStep3Strategy;
import exia.ipc.entities.MachineZ;
import exia.ipc.entities.Product;

public class Etape3 implements IStep3Strategy {

	private final Semaphore available_target1 = new Semaphore(1,true);
	private final Semaphore available_target2 = new Semaphore(1,true);
	
	@Override
	public MachineZ chooseMachine(MachineZ target1, MachineZ target2) throws Exception {
		
		while(true) {
			if(available_target1.tryAcquire()) {
			return target1;
		}
		else if(available_target2.tryAcquire()) {
			return target2;
		}
			Thread.sleep(10);
		}
	}	

	@Override
	public void onMachineRequest(Product product, MachineZ m1, MachineZ m2, MachineZ m3) throws Exception {
		Semaphore target =  which_machine(m1.getName());
		Parralelopipede threads = new Parralelopipede(m1, m2, m3, product);
		threads.init();
		while(threads.is_alive()) {
			Thread.sleep(10);
		}
		product.makeFinished();
		target.release();
	}
	
	private Semaphore which_machine(String machine_name) {
		Semaphore return_machine = null;
		switch (machine_name) {
		case "Z3":
			return_machine = available_target1;
			break;
		case "Z0":
			return_machine = available_target2;
			break;
		default:
			break;
		}
		return return_machine;
	}

}


