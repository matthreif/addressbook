import java.util.Set;

public class Contact {
    private String name;
    private Set<PhoneNumber> phoneNumberSet;

    public Contact(String name, Set<PhoneNumber> phoneNumberSet) {
        this.name = name;
        this.phoneNumberSet = phoneNumberSet;
    }

    public String print() {
        return "";
    }
}
