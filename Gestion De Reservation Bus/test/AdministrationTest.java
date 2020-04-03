import static org.junit.Assert.*;

import org.junit.Test;

public class AdministrationTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	   public void testInfoMessage() {
		Administration admin = new Administration();
		admin.infoMessage("Parfait", "Alert");
	}

	@Test (timeout = 1000)
	public void testActualiser() {
		Administration admin = new Administration();
		admin.actualiser();
	}

}
