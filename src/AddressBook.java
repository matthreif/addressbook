import java.util.Set;

public class AddressBook {
    private Set<Contact> contacts;

    public void addNew(Contact contact) {
        contacts.add(contact);
    }

    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    public String printAllContacts() {
        return"";
    }
}
