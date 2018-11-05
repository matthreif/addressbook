import java.util.LinkedList;
import java.util.List;

public class TestUtils {

    static public Contact createContactWithTwoPhoneNumbers(String name, PhoneNumber phoneNumber1, PhoneNumber phoneNumber2) {
        List<PhoneNumber> phoneNumberList = new LinkedList<>();
        phoneNumberList.add(phoneNumber1);
        phoneNumberList.add(phoneNumber2);
        return new Contact(name, new PhoneNumbers(phoneNumberList));
    }
}
