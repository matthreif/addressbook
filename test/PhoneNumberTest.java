import org.junit.*;
import static org.junit.Assert.*;

public class PhoneNumberTest {

    @Test
    public void testPrint() {
        PhoneNumber testPhoneNumber = new PhoneNumber("Mobile", "123456");

        String printed = testPhoneNumber.print(new PrintFormat("%s: %s"));

        assertEquals("Mobile: 123456", printed);
    }
}
