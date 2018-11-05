
public class Contact {
    private String name;
    private PhoneNumbers phoneNumbers;

    public Contact(String name) {
        this.name = name;
        phoneNumbers = new PhoneNumbers();
    }

    public Contact(String name, PhoneNumbers phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public boolean areUnique(Contact that) {
        return this.name.equals(that.name);
    }

    public String print(PrintFormat contactFormat, PrintFormat phoneNumberFormat) {
        return contactFormat.print(name, phoneNumbers.print(phoneNumberFormat));
    }
}
