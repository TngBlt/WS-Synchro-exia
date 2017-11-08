import exia.ipc.entities.MachineZ;
import exia.ipc.entities.Product;
import exia.ipc.exceptions.MachineAllreadyUsedException;
import exia.ipc.exceptions.OperationAllreadyDoneException;

public class Machine_Thread  extends Thread{
	private MachineZ machine;
	private Product product;
	
	public Machine_Thread(MachineZ machine, Product product) {
		this.machine = machine;
		this.product = product;
	}
	
	public void run() {
		try {
			machine.executeJob(product);
		} catch (MachineAllreadyUsedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationAllreadyDoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
