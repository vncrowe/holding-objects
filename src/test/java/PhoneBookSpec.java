import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by veronicacrowe on 5/20/16.
 */
public class PhoneBookSpec {

    PhoneBook phoneBook;


    @Before
    public void initialize(){
        phoneBook = new PhoneBook();
        phoneBook.addContact("Veronica Crowe","302-588-9907");

    }
    @Test

    public void addContactTest(){
        phoneBook.addContact("John Doe", "302-567-5678");
        String expectedValue = "302-567-5678";
        String actualValue = phoneBook.lookup("John Doe");
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void removeContactTest(){
        phoneBook.removeContact("Veronica Crowe");
        assertNull(phoneBook.lookup("Veronica Crowe"));


    }

    @Test
    public void lookupTest(){
        String expectedValue = "302-588-9907";
        String actualValue = phoneBook.lookup("Veronica Crowe");
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void listNamesTest(){
        phoneBook.addContact("John Doe", "302-567-5678");
        String expectedValue = "John Doe\nVeronica Crowe\n";
        String actualValue = phoneBook.listNames();
        assertEquals(expectedValue, actualValue);
    }

    @Test

    public void listEntriesTest(){
        phoneBook.addContact("John Doe", "302-567-5678");
        String expectedValue = "John Doe 302-567-5678\nVeronica Crowe 302-588-9907\n";
        String actualValue = phoneBook.listEntries();
        assertEquals(expectedValue, actualValue);
    }

}
