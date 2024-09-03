package Miniproj;

public class ContactService {
	
	
	private Contact[] contacts;
    private int contactCount;

    public ContactService(int initialSize) {
        this.contacts = new Contact[initialSize];
        this.contactCount = 0;
    }

    public void createContact(String name, String phoneNumber, String countryCode) {
        if (contactCount < contacts.length) {
            contacts[contactCount++] = new Contact(name, phoneNumber, countryCode);
        } else {
            System.out.println("No more contacts can be added.");
        }
    }

    public Contact getContact(String phoneNumber) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
                return contacts[i];
            }
        }
        return null;
    }

    public void updateContact(String phoneNumber, String newName, String newCountryCode) {
        Contact contact = getContact(phoneNumber);
        if (contact != null) {
            contact.setName(newName);
            contact.setCountryCode(newCountryCode);
        }
    }

    public void deleteContact(String phoneNumber) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
                contacts[i] = contacts[contactCount - 1]; // Replace with the last contact
                contacts[contactCount - 1] = null;
                contactCount--;
                break;
            }
        }
    }

    public void addContactToGroup(String phoneNumber, Group group) {
        Contact contact = getContact(phoneNumber);
        if (contact != null) {
            group.addContact(contact);
            contact.addGroup(group);
        }
    }

    public void removeContactFromGroup(String phoneNumber, Group group) {
        Contact contact = getContact(phoneNumber);
        if (contact != null) {
            group.removeContact(contact);
            contact.removeGroup(group);
        }
    }

    public Contact[] getAllContacts() {
        return contacts;
    }
 
    
    //bubble sort for phonenumber
    //PhoneNumberComparator phoneNumberComparator = new PhoneNumberComparator();

    public Contact[] getAllContactSortedByPhoneNumber() {
    	Contact[] sortedContacts = new Contact[contactCount];
        // Copying
        for (int i = 0; i < contactCount; i++) {
            sortedContacts[i] = contacts[i];
        }
        
        
        //  sorting the copied array
        boolean swapped;
        for (int i = 0; i < contactCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (new PhoneNumberComparator().compare(sortedContacts[j], sortedContacts[j + 1]) > 0) {
                    // Swap sortedContacts[j] and sortedContacts[j + 1]
                    Contact temp = sortedContacts[j];
                    sortedContacts[j] = sortedContacts[j + 1];
                    sortedContacts[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return sortedContacts;
        
    }
    
    
    
    
    // bubble sort for name
    public Contact[] getAllContactSortedByName() {
    	Contact[] sortedContacts1 = new Contact[contactCount];
        // Copying
        for (int i = 0; i < contactCount; i++) {
            sortedContacts1[i] = contacts[i];
        }
        
        
        //  sorting the copied array
        boolean swapped;
        for (int i = 0; i < contactCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (new NameComparator().compare(sortedContacts1[j], sortedContacts1[j + 1]) > 0) {
                    // Swap sortedContacts[j] and sortedContacts[j + 1]
                    Contact temp = sortedContacts1[j];
                    sortedContacts1[j] = sortedContacts1[j + 1];
                    sortedContacts1[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return sortedContacts1;
        
    }
    
    
    
 
    
	
}
