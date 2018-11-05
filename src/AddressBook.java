import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
    private List<Contact> contacts = new LinkedList<>();

    public void addNew(Contact contact) {
        contacts.add(contact);
    }

    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    public void removeByName(String nameToRemove) {
        this.contacts = contacts
                .stream()
                .filter(contact -> !contact.areUnique(new Contact(nameToRemove)))
                .collect(Collectors.toList());
    }

    public String printAllContacts(PrintFormat contactFormat, PrintFormat phoneNumberFormat) {
        StringBuilder builder = new StringBuilder();

        for (Contact contact : contacts) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(contact.print(contactFormat, phoneNumberFormat));
        }
        return builder.toString();    }
}
