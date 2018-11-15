import java.util.Comparator;
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
        Contact contactToRemove = new Contact(nameToRemove);
        this.contacts = contacts
                .stream()
                .filter(contact -> !contact.areUnique(contactToRemove))
                .collect(Collectors.toList());
    }

    private boolean containsByName(String name) {
        Contact reference = new Contact(name);
        return contacts
                .stream()
                .anyMatch(contact -> contact.areUnique(reference));
    }

    public void mergeNonUniqueContacts(AddressBook that) {
        that.contacts
                .stream()
                .filter(contact -> !this.containsByName(contact.getName()))
                .forEach(this::addNew);
    }

    public void sortByName() {
        this.contacts =  contacts
                .stream()
                .sorted(Comparator.comparing(Contact::getName))
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
