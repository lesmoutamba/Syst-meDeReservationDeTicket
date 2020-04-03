import static org.junit.Assert.*;

import org.junit.Test;

public class AjoutBusTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	   public void testInfoMessage() {
		AjoutBus ab = new AjoutBus();
		ab.infoMessage("Parfait", "Alert");
	}

	@Test (timeout = 1000)
	public void testActualiser() {
		AjoutBus ab = new AjoutBus();
		ab.actualiser();
	}

}
