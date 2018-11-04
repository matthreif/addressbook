import org.junit.*;
import static org.junit.Assert.*;

public class PrintFormatTest {

    @Test
    public void testPrintWithSingleArgument() {

        PrintFormat format = new PrintFormat("PREFIX %s SUFFIX");

        String output = format.print("hello");

        assertEquals("PREFIX hello SUFFIX", output);
    }

    @Test
    public void testPrintWithMultipleArguments() {

        PrintFormat format = new PrintFormat("PREFIX %s %s SUFFIX");

        String output = format.print("arg1", "arg2");

        assertEquals("PREFIX arg1 arg2 SUFFIX", output);
    }

    @Test
    public void testPrintWithoutArguments() {

        PrintFormat format = new PrintFormat("PREFIX SUFFIX");

        String output = format.print();

        assertEquals("PREFIX SUFFIX", output);
    }

    @Test
    public void testPrintWithExcessiveArguments() {

        PrintFormat format = new PrintFormat("PREFIX SUFFIX");

        String output = format.print("arg1", "arg2");

        assertEquals("PREFIX SUFFIX", output);
    }
}
