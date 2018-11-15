# addressbook

## Requirements

### Address book will hold name and phone numbers of contact entries

User interface:

    new Contact(String name, PhoneNumbers phoneNumbers)

Relevant tests:

    ContactTest.testPrint()

### Users should be able to add new contact entries

User interface:

    AddressBook.addNew(Contact contact)

Relevant tests:

    AddressBookTest.testAddNewContact()


### Users should be able to remove existing contact entries

User interface:

    AddressBook.remove(Contact contact)
    AddressBook.removeByName(String nameToRemove)

Relevant tests:

    AddressBookTest.testRemoveContact()
    AddressBookTest.testRemoveContactByNameWhereContactExists()
    AddressBookTest.testRemoveContactByNameWhereContactDoesNotExist()


### Users should be able to print all contacts in an address book

User interface:

    AddressBook.printAllContacts(PrintFormat contactFormat, PrintFormat phoneNumberFormat)

Relevant tests:

    AddressBookTest.testPrintAllContacts()
    AddressBookTest.testPrintAllContactsWhenEmpty()


### Users should be able to maintain multiple address books

User interface:

    new AddressBooks()
    AddressBooks.add(String name, AddressBook addressBook)
    AddressBooks.remove(String name)

Relevant tests:

    AddressBooksTest.testMaintainMultipleAddressBooks()


### Users should be able to print a unique set of all contacts across multiple address books

User interface:

    AddressBooks.printAllUniqueContacts(PrintFormat contactFormat, PrintFormat phoneNumberFormat)

Relevant tests:

    AddressBooksTest.testPrintAllUniqueContacts()
    AddressBooksTest.testPrintAllUniqueContactsWhenEmpty()
    AddressBookTest.testMergeUniqueContacts()
    ContactTest.testAreUnique()

## Notes

* "Maintain multiple address books" is assumed to mean the ability to create a new set of address books and to add and remove named address books.
* Two contacts are assumed to be unique if their names are identical. **Limitation**: If two unique contact entries define differing phone numbers, one set of phone numbers will be discarded when printing.
* The implementation of a user-defined print format is rudimentary and was primarily intended to decouple formatting from tests.
* When printing all unique contacts, contacts are printed in alphabetical order to produce predictable output in tests.
