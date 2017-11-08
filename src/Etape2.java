import java.util.concurrent.Semaphore;

import exia.ipc.entities.IStep2Strategy;
import exia.ipc.entities.MachineX;
import exia.ipc.entities.MachineY;

public class Etape2 implements IStep2Strategy {
	private final Semaphore available = new Semaphore(2,true);
	
	@Override
	public void onMachineRequest(MachineX applicant, MachineY executor) throws Exception {

			available.acquire();
	
	}

	@Override
	public  void onMachineExecute(MachineX applicant, MachineY executor) throws Exception {
			executor.executeJob();
			available.release();
	}
}

	