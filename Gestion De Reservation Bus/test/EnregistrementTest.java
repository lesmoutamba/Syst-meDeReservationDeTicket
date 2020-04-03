import static org.junit.Assert.*;

import org.junit.Test;

public class EnregistrementTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	   public void testInfoMessage() {
		Enregistrement enregistre = new Enregistrement();
		enregistre.infoMessage("Parfait", "Alert");
	}*/
 
	@Test (timeout = 1000)
	public void testActualiser() {
		Enregistrement enregistre = new Enregistrement();
		enregistre.actualiser();
	}

}
