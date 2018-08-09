package headfirst.designpatterns.proxy.gumball;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class GumballMachineTestDrive {
 
	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		int count;

		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
 			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);

			gumballMachine = 
				new GumballMachine(args[0], count);

            System.out.println("正在创建接口");
            LocateRegistry.createRegistry(8888);
            System.out.println("创建端口成功");

			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
