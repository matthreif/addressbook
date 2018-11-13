import org.junit.*;
import static org.junit.Assert.*;

public class AddressBooksTest {

    Contact jason = TestUtils.createContactWithOnePhoneNumber("Jason", new PhoneNumber("J", "1"));
    Contact hanna = TestUtils.createContactWithOnePhoneNumber("Hanna", new PhoneNumber("H", "2"));
    Contact steve = TestUtils.createContactWithOnePhoneNumber("Steve", new PhoneNumber("S", "3"));

    private static PrintFormat ContactPrintFormat = new PrintFormat("%s:%s");
    private static PrintFormat PhoneNumberPrintFormat = new PrintFormat("irrelevant");

    @Test
    public void testMaintainMultipleAddressBooks() {
        AddressBook addressBook1 = TestUtils.createAddressBookWithOneContact(jason);
        AddressBook addressBook2 = TestUtils.createAddressBookWithOneContact(hanna);

        AddressBooks testAddressBooks = new AddressBooks();
        testAddressBooks.add("Address Book 1", addressBook1);
        testAddressBooks.add("Address Book 2", addressBook2);

        String outputFromTwoAddressBooks = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Jason:irrelevant\nHanna:irrelevant", outputFromTwoAddressBooks);

        testAddressBooks.remove("Address Book 1");

        String outputFromOneAddressBook = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Hanna:irrelevant", outputFromOneAddressBook);
    }

    @Test
    public void testPrintAllUniqueContacts() {
        AddressBook addressBook1 = TestUtils.createAddressBookWithTwoContacts(jason, hanna);
        AddressBook addressBook2 = TestUtils.createAddressBookWithTwoContacts(steve, jason);

        AddressBooks testAddressBooks = new AddressBooks();
        testAddressBooks.add("Address Book 1", addressBook1);
        testAddressBooks.add("Address Book 2", addressBook2);

        String output = testAddressBooks.printAllUniqueContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Hanna:irrelevant\nJason:irrelevant\nSteve:irrelevant", output);
    }
}
