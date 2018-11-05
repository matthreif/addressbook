import java.util.LinkedList;
import java.util.List;

public class PhoneNumbers {

    private List<PhoneNumber> phoneNumbers;

    public PhoneNumbers() {
        this.phoneNumbers = new LinkedList<PhoneNumber>();
    }

    public PhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String print(PrintFormat phoneNumberFormat) {
        StringBuilder builder = new StringBuilder();

        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(phoneNumber.print(phoneNumberFormat));
        }
        return builder.toString();
    }
}
