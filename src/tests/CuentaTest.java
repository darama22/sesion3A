package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sesion3A.Cuenta;

class CuentaTest {

	static Cuenta cuenta;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
        cuenta = new Cuenta("11111", "Daniel", 0);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	 @Test
	    void testIngresar() {
	        cuenta.ingresar(500);
	        assertEquals(500, cuenta.getSaldo(), 0.001);
	        assertEquals(1, cuenta.getMovimientos().size());
	    }

	    @Test
	    void testRetirar() {
	        cuenta.retirar(500);                     // justo en el límite: permitido
	        assertEquals(-500, cuenta.getSaldo(), 0.001);
	        assertEquals(1, cuenta.getMovimientos().size());
	    }

	    @Test
	    void testRetirarSuperandoLimite() {
	        cuenta.retirar(501);                     // se pasa del descubierto: rechazado
	        assertEquals(0, cuenta.getSaldo(), 0.001);
	        assertTrue(cuenta.getMovimientos().isEmpty());
	    }

	    // --- Caso de prueba de clase ---

	    @Test
	    void test0014() {
	        // Inicialización
	        Cuenta c12345 = new Cuenta("12345", "Titular 1", 50);
	        Cuenta c67890 = new Cuenta("67890", "Titular 2", 0);

	        // Instrucciones
	        c12345.retirar(200);   // 1 -> -150
	        c67890.retirar(350);   // 2 -> -350
	        c12345.ingresar(100);  // 3 -> -50
	        c67890.retirar(200);   // 4 -> ERROR (quedaría -550)
	        c67890.retirar(150);   // 5 -> -500
	        c12345.retirar(200);   // 6 -> -250
	        c67890.ingresar(50);   // 7 -> -450
	        c67890.retirar(100);   // 8 -> ERROR (quedaría -550)

	        // Resultados esperados
	        assertEquals(-250, c12345.getSaldo(), 0.001);
	        assertEquals(-450, c67890.getSaldo(), 0.001);

	        // 12345: movimientos 1, 3 y 6
	        assertEquals(3, c12345.getMovimientos().size());
	        // 67890: movimientos 2, 5 y 7 (el 4 y el 8 no se registran)
	        assertEquals(3, c67890.getMovimientos().size());
	    }

}
