import org.junit.*;
import static org.junit.Assert.*;

public class AddressBooksTest {

    private static Contact jason = TestUtils.createContactWithOnePhoneNumber("Jason", new PhoneNumber("J", "1"));
    private static Contact hanna = TestUtils.createContactWithOnePhoneNumber("Hanna", new PhoneNumber("H", "2"));
    private static Contact steve = TestUtils.createContactWithOnePhoneNumber("Steve", new PhoneNumber("S", "3"));

    private static PrintFormat ContactPrintFormat = new PrintFormat("%s:%s");
    private static PrintFormat PhoneNumberPrintFormat = new PrintFormat("PHONE");

    @Test
    public void testMaintainMultipleAddressBooks() {
        AddressBook addressBook1 = TestUtils.createAddressBookWithOneContact(jason);
        AddressBook addressBook2 = TestUtils.createAddressBookWithOneContact(hanna);

        AddressBooks testAddressBooks = new AddressBooks();
        testAddressBooks.add("Address Book 1", addressBook1);
        testAddressBooks.add("Address Book 2", addressBook2);

        String outputFromTwoAddressBooks = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Hanna:PHONE\nJason:PHONE", outputFromTwoAddressBooks);

        testAddressBooks.remove("Address Book 1");

        String outputFromOneAddressBook = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Hanna:PHONE", outputFromOneAddressBook);
    }

    @Test
    public void testPrintAllUniqueContactsWhenEmpty() {
        AddressBook addressBook1 = new AddressBook();
        AddressBook addressBook2 = new AddressBook();

        AddressBooks testAddressBooks = new AddressBooks();
        testAddressBooks.add("Address Book 1", addressBook1);
        testAddressBooks.add("Address Book 2", addressBook2);

        String output = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("", output);
    }

    @Test
    public void testPrintAllUniqueContacts() {
        AddressBook addressBook1 = TestUtils.createAddressBookWithTwoContacts(jason, hanna);
        AddressBook addressBook2 = TestUtils.createAddressBookWithTwoContacts(steve, jason);

        AddressBooks testAddressBooks = new AddressBooks();
        testAddressBooks.add("Address Book 1", addressBook1);
        testAddressBooks.add("Address Book 2", addressBook2);

        String output = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Hanna:PHONE\nJason:PHONE\nSteve:PHONE", output);
    }
}
