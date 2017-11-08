import exia.ipc.entities.IStep1Strategy;
import exia.ipc.entities.InputDock;
import exia.ipc.entities.MachineX;
import exia.ipc.entities.Product;

public class Etape1 implements IStep1Strategy {

	@Override
	public synchronized Product  onMachineRequest(InputDock dock, MachineX machine) throws Exception {
		
		while(!dock.isProductAvailable()) {
			Thread.sleep(10);
		}
		
		return dock.accept();
	}

}
