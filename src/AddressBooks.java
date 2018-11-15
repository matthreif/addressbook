import java.util.HashMap;
import java.util.Map;

public class AddressBooks {
    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void add(String name, AddressBook addressBook) {
        addressBooks.put(name, addressBook);
    }

    public void remove(String name) {
        addressBooks.remove(name);
    }

    public String printAllUniqueContacts(PrintFormat contactFormat, PrintFormat phoneNumberFormat) {
        AddressBook merged = addressBooks
                .values()
                .stream()
                .reduce(new AddressBook(), (a,b) -> { a.mergeNonUniqueContacts(b); return a; });

        merged.sortByName();

        return merged.printAllContacts(contactFormat, phoneNumberFormat);
    }
}
