package headfirst.decorator.io;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

public class LowerCaseInputStreamTest {
	private String testString;
	private InputStream stream;
	
	@Before
	public void setUp() throws Exception {
		testString = "DESIGN PATTERNS";
		stream = new LowerCaseInputStream(new ByteArrayInputStream(testString.getBytes("UTF-8")));
	}

	@Test
	public void testRead1() throws IOException {
		String lower = "";
		for(int i = 0; i < testString.length(); i++){
			char c = (char)stream.read();
			lower += c;
		}
		assertEquals("design patterns", lower);
	}

	@Test
	public void testRead2() throws IOException {
		byte[] array = testString.getBytes();
		stream.read(array, 0, array.length);
		String lower = new String(array);
		assertEquals("design patterns", lower);
	}
}
