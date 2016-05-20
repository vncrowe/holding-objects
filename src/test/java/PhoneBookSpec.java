import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        ArrayList<String> expectedValue = new ArrayList<String>();
       expectedValue.add("302-567-5678");
        ArrayList<String> actualValue = phoneBook.lookup("John Doe");
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void removeContactTest(){
        phoneBook.removeContact("Veronica Crowe");
        assertNull(phoneBook.lookup("Veronica Crowe"));


    }

    @Test
    public void lookupTest(){
        ArrayList<String> expectedValue = new ArrayList<String>();
        expectedValue.add("302-588-9907");
        ArrayList<String> actualValue = phoneBook.lookup("Veronica Crowe");
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
        phoneBook.addNumber("John Doe","666-666-6666");
        String expectedValue = "John Doe\n302-567-5678\n666-666-6666\nVeronica Crowe\n302-588-9907\n";
        String actualValue = phoneBook.listEntries();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void reverseLookupTest(){
        phoneBook.addContact("John Doe", "302-567-5678");
        phoneBook.addNumber("Veronica Crowe", "555-555-5555");
        phoneBook.addNumber("John Doe", "666-555-5555");
        String expectedValue = "John Doe";
        String actualValue = phoneBook.reserveLookup("666-555-5555");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addNumberTest(){
        phoneBook.addNumber("Veronica Crowe", "555-555-5555");
        ArrayList<String> expectedValue = new ArrayList<String>();
        expectedValue.add("302-588-9907");
        expectedValue.add("555-555-5555");
        ArrayList<String> actualValue = phoneBook.lookup("Veronica Crowe");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void removePhoneNumberTest(){
        phoneBook.removeNumber("Veronica Crowe", "302-588-9907");
        ArrayList<String> expectedValue = new ArrayList<String>();
        ArrayList<String> actualValue = phoneBook.lookup("Veronica Crowe");
        assertEquals(expectedValue,actualValue);
        phoneBook.addNumber("Veronica Crowe", "555-555-5555");
        expectedValue.add("555-555-5555");
        assertEquals(expectedValue,actualValue);

    }
}
