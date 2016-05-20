import apple.laf.JRSUIUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by veronicacrowe on 5/20/16.
 */
public class PhoneBook {
    private TreeMap<String,String> phoneEntries;

    public PhoneBook(){
        phoneEntries = new TreeMap<String, String>();
    }

    public void addContact(String name, String phoneNumber) {
        phoneEntries.put(name, phoneNumber);
    }

    public String lookup(String name) {
        return phoneEntries.get(name);
    }

    public void removeContact(String name) {
        phoneEntries.remove(name);
    }

    public String listEntries() {
        String output = "";
        for(Map.Entry<String,String> entry : phoneEntries.entrySet()){
            output += entry.getKey() + " " + entry.getValue() +"\n";
        }


        return output;
    }

    public String listNames(){
        String output = "";
        for(Map.Entry<String, String> entry : phoneEntries.entrySet()){
            output += entry.getKey() + "\n";
        }
        return output;
    }

    public String reserveLookup(String phoneNumber){
        for(Map.Entry<String,String> entry : phoneEntries.entrySet()){
            if(phoneNumber == entry.getValue()){
                return entry.getKey();
            }
        }
        return null;
    }
}
