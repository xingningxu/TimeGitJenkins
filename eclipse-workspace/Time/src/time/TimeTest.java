package time;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		//show error message "not calculated properly" if answer is not exactly 18305
		assertTrue("The seconds were not calculated properly",seconds==18305);

	}

	@Test
	public void testGetTotalSecondsBad() 
	{
		assertThrows(
	 	StringIndexOutOfBoundsException.class, 
	 	()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	public void testGetTotalSecondsBoundary() 
	{
		int seconds = Time.getTotalSeconds("00:00:00");
		assertTrue("The seconds were not calculated properly",seconds==0);
		seconds = Time.getTotalSeconds("00:00:01");
		assertTrue("The seconds were not calculated properly",seconds==1);
		seconds = Time.getTotalSeconds("59:59:59");
		assertTrue("The seconds were not calculated properly",seconds==215999);
		
	}
	
	@ParameterizedTest
	//boundary cases and good case for 5 hours
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours ==5);
	}

	@Test
	void testGetTotalHoursBad() {
		assertThrows(
			 	NumberFormatException.class, 
			 	()-> {Time.getTotalHours("1:00:00");});
	}
	
	@ParameterizedTest
	//boundary cases and good case for 59 minutes
	@ValueSource(strings = { "00:59:00", "05:59:30", "59:59:59" })
	void testGetTotalMinutes (String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes == 59);
	}
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				NumberFormatException.class,
				() -> {
					Time.getTotalMinutes("333:33:33");
				});
	}

	@ParameterizedTest
	//boundary cases and good case for 59 seconds
	@ValueSource(strings = { "00:00:59", "05:05:59", "59:59:59" })
	void testGetSeconds (String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds ==59);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class, () -> {
					Time.getTotalSeconds("05:00:1");
				});
	}

	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliseconds("12:05:05:005");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 5);
	}

	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getMilliseconds("00:00:1");
		});
	}

	@Test
	void testGetMillisecondsBoundary() {
		int milliseconds = Time.getMilliseconds("00:00:00:999");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 999);
	}

	@Test
	void testGetTotalMillisecondsGood() {
		int milliseconds = Time.getTotalMilliseconds("05:05:05:005");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 18305005);
	}

	@Test
	void testGetTotalMillisecondsBoundary() {
		int milliseconds = Time.getTotalMilliseconds("09:59:59:999");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 35999999);
	}

	@Test
	void testGetTotalMillisecondsBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getTotalMilliseconds("1:11:111");
		});
	}
}
