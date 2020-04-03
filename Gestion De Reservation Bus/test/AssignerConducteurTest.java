import static org.junit.Assert.*;

import org.junit.Test;

public class AssignerConducteurTest {

	/*@Test
	public void test() {
		AssignerConducteur ac = new AssignerConducteur();
	}
	
	@Test
	   public void testInfoMessage() {
		AssignerConducteur ac = new AssignerConducteur();
		ac.infoMessage("Parfait", "Alert");
	}

	@Test (timeout = 1000)
	public void testConducteursInfo() {
		AssignerConducteur ac = new AssignerConducteur();
		ac.conducteursInfo();
	}*/
	
	@Test (timeout = 20000)
	public void testBusNoConducteur() {
		AssignerConducteur ac = new AssignerConducteur();
		ac.busNoConducteur();
	}

}
