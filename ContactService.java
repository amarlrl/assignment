package Miniproj;

import java.util.Comparator;

public class ContactService {

	private Contact[] contacts;
	private int contactCount;

	public ContactService(int initialSize) {
		this.contacts = new Contact[initialSize];
		this.contactCount = 0;
	}

	public void createContact(String name, String phoneNumber, String countryCode) throws  LimitExceededException, DuplicateContactException, InvalidPhoneNumberException {

		//phoneno. length
		if (phoneNumber.length() != 10) {
			throw new InvalidPhoneNumberException("Phone number must be 10 digits.");
	    }	
		// checking for array index
		if (contactCount >= contacts.length) {
			throw new LimitExceededException(" Array is full.");
		}

		  // Checking for duplicate contact
	    for (int i = 0; i < contactCount; i++) {
	        if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
	            throw new DuplicateContactException("Duplicate contact found.");
	        }
	    }

	    // Adding contact if no issues
	    contacts[contactCount++] = new Contact(name, phoneNumber, countryCode);

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

	public void addContactToGroup(String phoneNumber, Group group) throws GroupLimitExceededException, DuplicateGroupException, DuplicateContactException  {
		Contact contact = getContact(phoneNumber);
		if (contact != null) {
			group.addContact(contact);
			contact.addGroup(group);
		}
	}

	public void removeContactFromGroup(String phoneNumber, Group group) throws GroupNotFoundException, ContactNotFoundException {
		Contact contact = getContact(phoneNumber);
		if (contact != null) {
			group.removeContact(contact);
			contact.removeGroup(group);
		}
	}

	public Contact[] getAllContacts() {
		return contacts;
	}



	private Contact[] sort(Comparator<Contact> comp) {
		Contact[] sortedContacts = new Contact[contactCount];
		// Copying
		for (int i = 0; i < contactCount; i++) {
			sortedContacts[i] = contacts[i];
		}
		boolean swapped;
		for (int i = 0; i < contactCount - 1; i++) {
			swapped = false;
			for (int j = 0; j < contactCount - i - 1; j++) {
				if (comp.compare(sortedContacts[j], sortedContacts[j + 1]) > 0) {
					// Swap sortedContacts[j] and sortedContacts[j + 1]
					Contact temp = sortedContacts[j];
					sortedContacts[j] = sortedContacts[j + 1];
					sortedContacts[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}

		return sortedContacts;

	}

	public Contact[] getAllContactSortedByPhoneNumber() {
		PhoneNumberComparator phoneNumberComparator = new PhoneNumberComparator();
		return sort(phoneNumberComparator);
	}

	public Contact[] getAllContactSortedByName() {
		NameComparator nameComparator = new NameComparator();
		return sort(nameComparator);
	}

}
