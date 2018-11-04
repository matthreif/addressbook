import java.util.Formatter;
import java.util.Locale;

public class PrintFormat {
    private String format;

    public PrintFormat(String format) {
        this.format = format;
    }

    public String print(String... args) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());

        formatter.format(format, args);

        return formatter.toString();
    }
}
