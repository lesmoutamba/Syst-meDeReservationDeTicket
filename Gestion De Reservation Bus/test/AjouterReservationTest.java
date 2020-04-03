import static org.junit.Assert.*;

import org.junit.Test;

public class AjouterReservationTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	   public void testInfoMessage() {
		AjouterReservation ar = new AjouterReservation();
		ar.infoMessage("Parfait", "Alert");
	}

	@Test
	public void testDepartInfo() {
		AjouterReservation ar = new AjouterReservation();
		ar.departInfo();
	}*/
	
	@Test (timeout = 20000)
	public void testDestinationInfo() {
		AjouterReservation ar = new AjouterReservation();
		ar.destinationInfo();
	}

}
