import apple.laf.JRSUIUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by veronicacrowe on 5/20/16.
 */
public class PhoneBook {
    private TreeMap<String,ArrayList<String>> phoneEntries;

    public PhoneBook(){
        phoneEntries = new TreeMap<String, ArrayList<String>>();
    }

    public void addContact(String name, String phoneNumber) {
        ArrayList<String> arrayListsOfPhoneNumbers = new ArrayList<String>();
        arrayListsOfPhoneNumbers.add(phoneNumber);
        phoneEntries.put(name, arrayListsOfPhoneNumbers);
    }

    public ArrayList<String> lookup(String name) {
        return phoneEntries.get(name);
    }

    public void removeContact(String name) {
        phoneEntries.remove(name);
    }

    public String listEntries() {
        String output = "";
        for(Map.Entry<String,ArrayList<String>> entry : phoneEntries.entrySet()){
            output += entry.getKey() + "\n";
            for(int i = 0; i < entry.getValue().size();i++){
                output += entry.getValue().get(i)+"\n";
            }

        }


        return output;
    }

    public String listNames(){
        String output = "";
        for(Map.Entry<String, ArrayList<String>> entry : phoneEntries.entrySet()){
            output += entry.getKey() + "\n";
        }
        return output;
    }

    public void addNumber(String name, String phoneNumber) {
        phoneEntries.get(name).add(phoneNumber);

    }

    public void removeNumber(String name, String phoneNumber) {
        phoneEntries.get(name).remove(phoneNumber);
    }

    public String reserveLookup(String phoneNumber){
        for(Map.Entry<String,ArrayList<String>> entry : phoneEntries.entrySet()){
            for(int i = 0; i < entry.getValue().size();i++){
                if(phoneNumber == entry.getValue().get(i)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

}
