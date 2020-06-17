import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
/*
 * Name: Jiayi Xu
 * Project: JUnit 5 test
 * Date: 06/11/2020
 */
public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @BeforeEach
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @AfterEach
    public void tearDown() {
        mycustomstring = null;
    }
    /*
     * returns how many numbers on a string
     */
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }
    /*
     * returns 0 if the string is empty
     */
    @Test
    public void testCountNumbers2() {
    	mycustomstring.setString("");
    	assertEquals(0, mycustomstring.countNumbers());
    }
    /*
     * returns 0 if string is null
     */
    @Test
    public void testCountNumbers3() {
    	mycustomstring.setString(null);
    	assertEquals(0, mycustomstring.countNumbers());
    }
    /*
     * Extra test to confirm 
     */
    @Test
    public void testCountNumbers4() {
    	mycustomstring.setString("C0mput3r S3c13nc3");
    	assertEquals(5, mycustomstring.countNumbers());
    }
    /*
     * to test the " - " within numbers
     */
    @Test
    public void testCountNumbers5() {
    	mycustomstring.setString("There have 1-100 random numbers");
    	assertEquals(2, mycustomstring.countNumbers());
    }
    /*
     * Remove every a*nth ... character from string (a=1,2,3,...)
     */
    @Test
    public void testremoveEveryNthCharacter1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", mycustomstring.removeEveryNthCharacter(3, false));
    }
    /*
     * replace every a*nth character with space (a=1,2,3,....)
     */
    @Test
    public void testremoveEveryNthCharacter2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", mycustomstring.removeEveryNthCharacter(3, true));
    }
    /*
     * Extra test for remove
     */
    @Test
    public void testremoveEveryNthCharacter3() {
    	 mycustomstring.setString("Soft ware@ Eng!ineeRring");
         assertEquals("Software Engineering", mycustomstring.removeEveryNthCharacter(5, false));
    }
    /*
     * Extra test for replace
     */
    @Test
    public void testremoveEveryNthCharacter4() {
    	 mycustomstring.setString("Soft ware@ Eng!ineeRring");
         assertEquals("Soft ware  Eng inee ring", mycustomstring.removeEveryNthCharacter(5, true));
    }
    /*
     * Returns "IndexOutOfBoundsException" if n greater than string's length when the condition is true
     */
    @Test
    public void testremoveEveryNthCharacter5() {
    	 mycustomstring.setString("Soft ware@ Eng!ineeRring");
         assertThrows(IndexOutOfBoundsException.class,()-> {mycustomstring.removeEveryNthCharacter(50, true);});
    }
    /*
     * Returns "IndexOutOfBoundsException" if n greater than string's length when the condition is false
     */
    @Test
    public void testremoveEveryNthCharacter6() {
    	 mycustomstring.setString("Soft ware@ Eng!ineeRring");
         assertThrows(IndexOutOfBoundsException.class,()-> {mycustomstring.removeEveryNthCharacter(50, false);});
    }
    /*
     * Returns "IllegalArgumentException" if n equals 0 when the condition is false
     */
    @Test
    public void testremoveEveryNthCharacter7() {
    	 mycustomstring.setString("Soft ware@ Eng!ineeRring");
         assertThrows(IllegalArgumentException.class,()-> {mycustomstring.removeEveryNthCharacter(0, false);});
    
    }
    /*
     * Returns "IllegalArgumentException" if n less than zero when the condition is true
     */
    @Test
    public void testremoveEveryNthCharacter8() {
    	 mycustomstring.setString("Soft ware@ Eng!ineeRring");
         assertThrows(IllegalArgumentException.class,()-> {mycustomstring.removeEveryNthCharacter(-2, true);});
    }

    /*
     *Replace the individual digits in the current string, between startPosition and endPosition
     */
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put szerome done-six1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /*
     * Replace the individual digits in the current string, between startPosition and endPosition
     */
    @Test
    public void testConvertDigitsToNamesInSubstring2() {
    	 mycustomstring.setString("One byte has 8 bits, and 2 bytes have 16 bits");
         mycustomstring.convertDigitsToNamesInSubstring(11, 44);
         assertEquals("One byte has eight bits, and two bytes have one-six bits", mycustomstring.getString());
    }
    /*
     * Returns "NullPointerException" if string is null
     */
    @Test
    public void testConvertDigitsToNamesInSubstring3() {
    	 mycustomstring.setString(null);
         assertThrows(NullPointerException.class,()->{mycustomstring.convertDigitsToNamesInSubstring(2, 4);});
    }
    /*
     * Returns "IndexOutOfBoundsException" if startPositon greater than endPosition
     */
    @Test
    public void testConvertDigitsToNamesInSubstring4() {
    	 mycustomstring.setString("One byte has 8 bits, and 2 bytes have 168 bits");
         assertThrows(IndexOutOfBoundsException.class,()->{mycustomstring.convertDigitsToNamesInSubstring(22, 4);});
    }
    /*
     *  Returns "IndexOutOfBoundsException" if endPosition greater than string's length
     */
    @Test
    public void testConvertDigitsToNamesInSubstring5() {
    	 mycustomstring.setString("One byte has 8 bits, and 2 bytes have 168 bits");
         assertThrows(IndexOutOfBoundsException.class,()->{mycustomstring.convertDigitsToNamesInSubstring(22, 48);});
    }
    /*
     * Returns "IllegalArgumentException" if "startPosition" <= "endPosition", and "startPosition" is less than 1 
     */
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
    	 mycustomstring.setString("One byte has 8 bits, and 2 bytes have 168 bits");
         assertThrows(IllegalArgumentException.class,()->{mycustomstring.convertDigitsToNamesInSubstring(0, 0);});
    }



}
