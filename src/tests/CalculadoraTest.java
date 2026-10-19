package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

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
	void test() {
		fail("Not yet implemented");
	}

	
	@Test
	void testSuma() {
		assertEquals(5, Calculadora.suma(3, 2));
	}
	
	@Test
	void testResta() {
		assertEquals(0, Calculadora.resta(3, 3));
	}
	
	@Test
	void testMultiplicacion() {
		assertEquals(6, Calculadora.multiplica(3, 2));
	}
	
	@Test
	void testDivision() {
		assertEquals(4, Calculadora.divide(8, 2));
	}
	
	
	
	
	
}
