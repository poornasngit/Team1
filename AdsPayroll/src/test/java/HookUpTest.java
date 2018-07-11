import static org.junit.Assert.*;

import org.junit.Test;


public class HookUpTest {

	@Test
	public void hookUp() {
		assertTrue(true);
	}
	
	@Test
	public void roundTrip()  {
		NameMerger merger = new NameMerger();
		String result = merger.merge("Steve", "McQueen");
		assertEquals("Steve McQueen", result);
		
	}

}
