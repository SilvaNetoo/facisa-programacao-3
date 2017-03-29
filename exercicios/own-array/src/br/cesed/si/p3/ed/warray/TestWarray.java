package br.cesed.si.p3.ed.warray;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class TestWarray {
	/**
	 * Comments for this test
	 */
	@Test
	public void testInitialList() {
		SArray s = new SArray(1);
		Assert.assertEquals(s.size(), 0);
	}
	@Test(expected=NegativeArraySizeException.class)
	public void testeInitialList2() throws NegativeArraySizeException{
		SArray s = new SArray(-10);
		Assert.assertEquals(s.size(), 0);
	}

	/**
	 * Comments for this test
	 */
	@Test
	public void testAdd1() {
		try {
			SArray s = new SArray(3);
			s.adiciona("Element 1");
			s.adiciona("element 2");
			s.adiciona("element 3");
			Assert.assertEquals(s.size(), 3);

		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Comments for this test
	 * @throws InvalidValueException 
	 */
	@Test(expected=InvalidValueException.class)
	public void testAdd2() throws InvalidValueException {
		SArray s = new SArray(1);
		s.adiciona(null);
	}
	@Test
	public void testRemove() {
		try {
			SArray s = new SArray(3);
			s.adiciona("Element 1");
			s.adiciona("Element 2");
			s.remove("Element 1");
			Assert.assertEquals(s.size(), 1);

		} catch (InvalidValueException e) {
			e.printStackTrace();
		} catch (InvalidIndexException e){
			e.printStackTrace();
		} catch (ValueNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = ValueNotFoundException.class)
	public void testRemove2() throws ValueNotFoundException, InvalidValueException, InvalidIndexException{
		SArray s = new SArray(3);
		s.remove("Element 1");
		Assert.assertEquals(s.size(), 1);
	}
	@Test
	public void testRemovePosicao() {
		try {
			SArray s = new SArray(3);
			s.adiciona("Element 1");
			s.adiciona("Element 2");
			s.removePosicao(1);
			Assert.assertEquals(s.size(), 1);

		} catch (InvalidValueException e) {
			e.printStackTrace();
		} catch (InvalidIndexException e){
			e.printStackTrace();
		}
	}

	@Test(expected = InvalidIndexException.class)
	public void testRemovePosicao2() throws  InvalidValueException, InvalidIndexException{
		SArray s = new SArray(3);
		s.removePosicao(0);
		Assert.assertEquals(s.size(), 0);
	}
}