import java.util.LinkedList;
import java.util.List;

public class TestUtils {

    static public Contact createContactWithOnePhoneNumber(String name, PhoneNumber phoneNumber) {
        List<PhoneNumber> phoneNumberList = new LinkedList<>();
        phoneNumberList.add(phoneNumber);
        return new Contact(name, new PhoneNumbers(phoneNumberList));
    }

    static public Contact createContactWithTwoPhoneNumbers(String name, PhoneNumber phoneNumber1, PhoneNumber phoneNumber2) {
        List<PhoneNumber> phoneNumberList = new LinkedList<>();
        phoneNumberList.add(phoneNumber1);
        phoneNumberList.add(phoneNumber2);
        return new Contact(name, new PhoneNumbers(phoneNumberList));
    }

    static public AddressBook createAddressBookWithOneContact(Contact contact) {
        AddressBook result = new AddressBook();
        result.addNew(contact);
        return result;
    }

    static public AddressBook createAddressBookWithTwoContacts(Contact contact1, Contact contact2) {
        AddressBook result = new AddressBook();
        result.addNew(contact1);
        result.addNew(contact2);
        return result;
    }

    static public AddressBooks createTwoAddressBooks(String name1, AddressBook addressBook1,
                                                     String name2, AddressBook addressBook2) {
        AddressBooks result = new AddressBooks();
        result.add(name1, addressBook1);
        result.add(name2, addressBook2);
        return result;
    }
}
