import org.junit.*;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testAreUnique() {

    }

    @Test
    public void testPrint() {

        Contact jason = TestUtils.createContactWithTwoPhoneNumbers("Jason",
                new PhoneNumber("A", "1"), new PhoneNumber("B", "2"));

        String output = jason.print(new PrintFormat("%s: %s"), new PrintFormat("%s%s"));

        assertEquals("Jason: A1,B2", output);
    }

}
