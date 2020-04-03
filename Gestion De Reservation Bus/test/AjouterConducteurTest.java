import static org.junit.Assert.*;

import org.junit.Test;

public class AjouterConducteurTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	   public void testInfoMessage() {
		AjouterConducteur ac = new AjouterConducteur();
		ac.infoMessage("Parfait", "Alert");
	}*/

	@Test (timeout = 1000)
	public void testActualiser() {
		AjouterConducteur ac = new AjouterConducteur();
		ac.actualiser();
	}
	
	
	

}
