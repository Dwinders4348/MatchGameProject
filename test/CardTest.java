import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;


/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Damion Winders
 */
public class CardTest {

    /** card two of hearts for testing */
    private Card twoOfHearts;

    /** card three of spades for testing */
    private Card threeOfSpades;

    /**
     * Create cards for testing
     */
    @BeforeEach
    public void setUp() {
        twoOfHearts = new Card('h', 2);

        threeOfSpades = new Card('s', 3);
    }

    /**
     * Tests constants
     */
    @Test
    public void testConstants() {
        assertEquals('c', Card.CLUBS, "CLUBS");
        assertEquals('d', Card.DIAMONDS, "DIAMONDS");
        assertEquals('s', Card.SPADES, "SPADES");
        assertEquals('h', Card.HEARTS, "HEARTS");
        assertEquals(2, Card.LOWEST_VALUE, "LOWEST_VALUE");
        assertEquals(14, Card.HIGHEST_VALUE, "HIGHEST_VALUE]");
    }

    /**
     * Tests constructor preconditions
     */
    @Test
    public void testConstructorPreConditions() {
        // Testing constructor with low invalid value
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('h', 1), "Constructor value 1");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 1 message");
                
        // Testing constructor with high invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('s', 15), "Constructor value 15");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 15 message");
                
        // Testing constructor with invalid suit and invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('w', 0), "Constructor suit w value 0");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit w value 0 message");
                
        // Testing constructor with invalid lowercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('x', 5), "Constructor suit x");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit x message");
                
        // Testing constructor with invalid uppercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('D', 5), "Constructor suit D");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit D message");
    }
    
    /**
     * Test getSuit() for two of hearts
     */
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals('h', twoOfHearts.getSuit(), "twoOfHearts suit");
    }
    // TODO: Test getSuit for added Card. Test should be in its own method.

    /**
     * Test getValue() for two of hearts
     */
    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals( 2, twoOfHearts.getValue(), "twoOfHearts value");
    }

    /**
     * Test getValue() for three of spades
     */
    @Test
    public void testGetValueThreeOfSpades() {
        assertEquals( 3, threeOfSpades.getValue(), "threeOfSpades value");
    }


    /**
     * Test getColor() for two of hearts
     */
    @Test
    public void testGetColorTwoOfHearts() {
        assertEquals(Color.RED, twoOfHearts.getColor(), "twoOfHearts color");
    }
    
    /**
     * test getColor() for three of spades
     */
    @Test
    public void testGetColorThreeOfSpades() {
        assertEquals(Color.BLACK, threeOfSpades.getColor(), "threeOfSpades color");
    }

    /**
     * Test toString() for two of hearts
     */
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("h2", twoOfHearts.toString(), "twoOfHearts toString");
    }

    /**
     * Test toString() for three of spades
     */
    @Test
    public void testToStringThreeOfSpades() {
        assertEquals("s3", threeOfSpades.toString(), "threeOfSpades toString");
    }

    /**
     * Test hasBeenFound() for two of hearts
     */
    @Test
    public void testHasBeenFoundTwoOfHearts() {
        assertFalse(twoOfHearts.hasBeenFound(), "twoOfHearts hasBeenFound");
    }
    
    /**
     * Test hasBeenFound() for three of spades
     */
    @Test
    public void testHasBeenFoundThreeOfSpades(){
        assertFalse(threeOfSpades.hasBeenFound(), "threeOfSpades hasBeenFound");
    }
    /**
     * Test setHasBeenFound() for two of hearts
     */
    @Test
    public void testSetHasBeenFoundTwoOfHearts() {
        twoOfHearts.setHasBeenFound(true);
        assertTrue(twoOfHearts.hasBeenFound(), "twoOfHearts setHasBeenFound true");
        twoOfHearts.setHasBeenFound(false);
        assertFalse(twoOfHearts.hasBeenFound(), "twoOfHearts setHasBeenFound false");
    }
    /**
     * Test setHasBeenFound() for three of spades
     */
    @Test
    public void testSetHasBeenFoundThreeOfSpades(){
        threeOfSpades.setHasBeenFound(true);
        assertTrue(threeOfSpades.hasBeenFound(), "threeOfSpades setHasBeenFound true");
        threeOfSpades.setHasBeenFound(false);
        assertFalse(threeOfSpades.hasBeenFound(), "threeOfSpades setHasBeenFound false");
    }

    /**
     * Test hasSameValue() for two of hearts
     */
    @Test
    public void testHasSameValue() {
        assertTrue(twoOfHearts.hasSameValue(new Card('c', 2)), "twoOfHearts has same value");
        assertFalse(twoOfHearts.hasSameValue(new Card('s', 3)), "twoOfHearts has different value");
    }
    /**
     * test hasSameValue for three of spades
     */
    @Test
    public void testHasSameValueThreeOfSpades() {
        assertTrue(threeOfSpades.hasSameValue(new Card('d', 3)), "threeOfSpades has same value");
        assertFalse(threeOfSpades.hasSameValue(new Card('c', 9)), "threeOfSpades has different value");
    }

    /**
     * Test hasSameValueAndColor() for two of hearts
     */
    @Test
    public void testHasSameValueAndColor() {
        assertTrue(twoOfHearts.hasSameValueAndColor(new Card('d', 2)),
                   "twoOfHearts has same value and color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('s', 3)),
                    "twoOfHearts has different value and color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('d', 8)),
                    "twoOfHearts has different value and same color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('s', 2)), 
                    "twoOfHearts has same value and different color");
    }
    
    /**
     * test hasSameValueAndColor for three of spades
     */
    @Test
    public void testHasSameValueAndColorThreeOfSpades(){
        assertTrue(threeOfSpades.hasSameValueAndColor(new Card('c', 3)),
        "twoOfHearts has same value and color");
        assertFalse(threeOfSpades.hasSameValueAndColor(new Card('d', 4)),
         "twoOfHearts has different value and color");
        assertFalse(threeOfSpades.hasSameValueAndColor(new Card('c', 8)),
         "twoOfHearts has different value and same color");
         assertFalse(twoOfHearts.hasSameValueAndColor(new Card('h', 3)), 
                     "twoOfHearts has same value and different color");
    }
    /**
     * Test equals() for two of hearts
     */
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue(twoOfHearts.equals(twoOfHearts), "twoOfHearts equals with same instance");
        assertTrue(twoOfHearts.equals(new Card('h', 2)), 
                   "twoOfHearts equals with different instances");
        assertFalse(twoOfHearts.equals(new Card('h', 4)), "twoOfHearts with different value");
        assertFalse(twoOfHearts.equals(new Card('s', 2)), "twoOfHearts with different suit");
        assertFalse(twoOfHearts.equals(new Card('c', 5)), 
                    "twoOfHearts with different value and suit");
        assertFalse(twoOfHearts.equals(null), "twoOfHearts compared to null object");
        assertFalse(twoOfHearts.equals("twoOfHearts"), "twoOfHearts compared to String");
    }
    
    /**
     * Test equals() for three of spades
     */
    @Test
    public void testEqualsThreeOfSpades() {
        assertTrue(threeOfSpades.equals(threeOfSpades), "threeOfSpades equals with the same instance");
        assertTrue(threeOfSpades.equals(new Card('s', 3)), "threeOfSpades equals with different instances");
        
        assertFalse(threeOfSpades.equals(new Card('s', 8)), "threeOfSpades with different value");
        assertFalse(threeOfSpades.equals(new Card('c', 3)), "threeOfSpades with different suit");
        assertFalse(threeOfSpades.equals(new Card('d', 6)), "threeOfSpades with different value and suit");

        assertFalse(threeOfSpades.equals(null), "threeOfSpades compared to null object");
        assertFalse(threeOfSpades.equals("threeOfSpades"), "threeOfSpades compared to String");
    }
   

}