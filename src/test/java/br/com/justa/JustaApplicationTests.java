package br.com.justa;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.json.JSONObject;

@SpringBootTest
class JustaApplicationTests {

	@Autowired
	private JustaController controller;

	@Test
	void testCase1() throws Exception {
		JSONObject test = new JSONObject();
		test.put("unit_name", "rad");
		test.put("multiplication_factor", 0.017453292519943295);

		assertEquals(controller.convertUnits("degree"), test.toString(4));
	}

	@Test
	void testCase2() throws Exception {
		JSONObject test = new JSONObject();
		test.put("unit_name", "rad/s");
		test.put("multiplication_factor", 2.908882086657216E-4);

		assertEquals(controller.convertUnits("degree/minute"), test.toString(4));
	}

	@Test
	void testCase3() throws Exception {
		JSONObject test = new JSONObject();
		test.put("unit_name", "(rad/(s*m²))");
		test.put("multiplication_factor", 2.908882086657216E-8);

		assertEquals(controller.convertUnits("(degree/(minute*hectare))"), test.toString(4));
	}

	@Test
	void testCase4() throws Exception {
		JSONObject test = new JSONObject();
		test.put("unit_name", "m²*rad");
		test.put("multiplication_factor", 174.53292519943295);

		assertEquals(controller.convertUnits("ha*°"), test.toString(4));
	}

	@Test
	void testCase5() throws Exception {
		JSONObject test = new JSONObject();
		test.put("unit_name", "rad*s");
		test.put("multiplication_factor", 1.0471975511965976);

		assertEquals(controller.convertUnits("degree*minute"), test.toString(4));
	}

	@Test
	void testCase6() throws Exception {
		JSONObject test = new JSONObject();
		test.put("unit_name", "(rad*s)/s");
		test.put("multiplication_factor", 1.0471975511965976);

		assertEquals(controller.convertUnits("(degree*min)/s"), test.toString(4));
	}

}