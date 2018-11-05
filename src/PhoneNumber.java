public class PhoneNumber {
    private String title;
    private String number;

    public PhoneNumber(String title, String number) {
        this.title = title;
        this.number = number;
    }

    public String print(PrintFormat format) {
        return format.print(title, number);
    }
}
