import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IdentificationTest {

	/*@Test
	   public void testInfoMessage() {
		Identification id = new Identification();
		id.infoMessage("Parfait", "Alert");
	}*/
    
	@Test (timeout = 1000)
	public void testActualiser() {
		Identification id = new Identification();
		id.actualiser();
	}
	
	
}
