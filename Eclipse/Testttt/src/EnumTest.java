import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;


enum Pulsanti {
	TRIANGOLO,
	CERCHIO,
	ICS,
	QUADRATO;
}


public class EnumTest {

	@Test
	public void testNotSame() {
		assertNotSame(Pulsanti.TRIANGOLO, Pulsanti.ICS);
	}
	
	@Test
	public void testClassEquals() {
		assertEquals(Pulsanti.TRIANGOLO.getClass(), 
                                      Pulsanti.TRIANGOLO.getClass());
	}

}