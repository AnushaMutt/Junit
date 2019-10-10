package junitexample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {

	@Test
	void testTruncateAInFirstPositions() {
		StringHelper stringHelper = new StringHelper();
		
		assertEquals("CD", stringHelper.truncateAInFirstPositions("AACD"));
		assertEquals("CD", stringHelper.truncateAInFirstPositions("ACD"));

	}

}
