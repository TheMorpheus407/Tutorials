import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;


public class JUnitTest {

	@Test
	public void test() {
		HelperClass h = new HelperClass();
		h.endless();
		assertTrue("i ungleich 5", h.i == 6);
		assertEquals("h not \"4\"","4", h.j);
	}

}
