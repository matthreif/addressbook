import org.junit.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private static PrintFormat ContactPrintFormat = new PrintFormat("%s:%s");
    private static PrintFormat PhoneNumberPrintFormat = new PrintFormat("%s%s");

    @Test
    public void testAddNewContact() {
        AddressBook testAddressBook = TestUtils.createAddressBookWithOneContact(
                TestUtils.createContactWithTwoPhoneNumbers("Jason",
                        new PhoneNumber("A", "1"), new PhoneNumber("B", "2"))
        );

        String output = testAddressBook.printAllContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Jason:A1,B2", output);
    }

    @Test
    public void testRemoveContact() {
        Contact jason = TestUtils.createContactWithTwoPhoneNumbers("Jason",
                new PhoneNumber("A", "1"), new PhoneNumber("B", "2"));
        AddressBook testAddressBook = TestUtils.createAddressBookWithOneContact(jason);

        testAddressBook.remove(jason);

        assertEquals("", testAddressBook.printAllContacts(ContactPrintFormat, PhoneNumberPrintFormat));
    }

    @Test
    public void testRemoveContactByNameWhereContactExists() {

        AddressBook testAddressBook = TestUtils.createAddressBookWithTwoContacts(
                TestUtils.createContactWithTwoPhoneNumbers("Jason",
                        new PhoneNumber("A", "1"), new PhoneNumber("B", "2")),
                TestUtils.createContactWithTwoPhoneNumbers("Natasha",
                        new PhoneNumber("M", "4"), new PhoneNumber("W", "46"))
        );

        testAddressBook.removeByName("Jason");

        assertEquals("Natasha:M4,W46", testAddressBook.printAllContacts(ContactPrintFormat, PhoneNumberPrintFormat));
    }

    @Test
    public void testRemoveContactByNameWhereContactDoesNotExist() {
        AddressBook testAddressBook = TestUtils.createAddressBookWithOneContact(
                TestUtils.createContactWithTwoPhoneNumbers("Jason",
                        new PhoneNumber("A", "1"), new PhoneNumber("B", "2"))
        );

        testAddressBook.removeByName("Hugo");

        assertEquals("Jason:A1,B2", testAddressBook.printAllContacts(ContactPrintFormat, PhoneNumberPrintFormat));
    }

    @Test
    public void testPrintAllContacts() {
        AddressBook testAddressBook = TestUtils.createAddressBookWithTwoContacts(
                TestUtils.createContactWithTwoPhoneNumbers("Jason",
                        new PhoneNumber("A", "1"), new PhoneNumber("B", "2")),
                TestUtils.createContactWithTwoPhoneNumbers("Janet",
                        new PhoneNumber("C", "3"), new PhoneNumber("D", "4"))

        );

        String output = testAddressBook.printAllContacts(ContactPrintFormat, PhoneNumberPrintFormat);

        assertEquals("Jason:A1,B2\nJanet:C3,D4", output);

    }
}
