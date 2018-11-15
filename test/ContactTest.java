import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testAreUnique() {

        Contact jason1 = TestUtils.createContactWithTwoPhoneNumbers("Jason",
                new PhoneNumber("A", "1"), new PhoneNumber("B", "2"));
        Contact jason2 = TestUtils.createContactWithOnePhoneNumber("Jason",
                new PhoneNumber("A", "2"));
        Contact dorothy = TestUtils.createContactWithOnePhoneNumber("Dorothy",
                new PhoneNumber("A", "2"));

        assertTrue(jason1.areUnique(jason2));
        assertFalse(jason2.areUnique(dorothy));
    }

    @Test
    public void testPrint() {

        Contact jason = TestUtils.createContactWithTwoPhoneNumbers("Jason",
                new PhoneNumber("A", "1"), new PhoneNumber("B", "2"));

        String output = jason.print(new PrintFormat("%s: %s"), new PrintFormat("%s%s"));

        assertEquals("Jason: A1,B2", output);
    }

}
