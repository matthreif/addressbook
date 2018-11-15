import org.junit.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PhoneNumbersTest {

    @Test
    public void testPrint() {
        List<PhoneNumber> phoneNumberList = new LinkedList<>();
        phoneNumberList.add(new PhoneNumber("Mobile", "123456"));
        phoneNumberList.add(new PhoneNumber("Work", "87654321"));

        PhoneNumbers testPhoneNumbers = new PhoneNumbers(phoneNumberList);

        String output = testPhoneNumbers.print(new PrintFormat("PHONE NUMBER"));

        assertEquals("PHONE NUMBER,PHONE NUMBER", output);
    }

}
