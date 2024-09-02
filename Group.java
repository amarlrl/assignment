package Miniproj;

public class Group {
	
	private static  int contactArraySize=25;
	 private String groupName;
	    private String groupDescription;
	    private Contact[] contacts=new Contact[contactArraySize];
	    private int contactCount;

	    public Group(String groupName, String groupDescription) {
	        this.groupName = groupName;
	        this.groupDescription = groupDescription;
	        this.contactCount = 0;
	    }

	    // Getters and setters
	    public String getGroupName() { return groupName; }
	    public void setGroupName(String groupName) { this.groupName = groupName; }

	    public String getGroupDescription() { return groupDescription; }
	    public void setGroupDescription(String groupDescription) { this.groupDescription = groupDescription; }

	    public Contact[] getContacts() { return contacts; }

	    public void addContact(Contact contact) {
	    	 if (contactCount < contacts.length) {
	             for (int i = 0; i < contactCount; i++) {
	                 if (contacts[i] == contact) {
	                     return; // Contact already added
	                 }
	             }
	             contacts[contactCount] = contact;
	             contactCount++;
	         } else {
	             System.out.println("No more contacts can be added to this group.");
	         }
	    }

	    public void removeContact(Contact contact) {
	        for (int i = 0; i < contactCount; i++) {
	            if (contacts[i].equals(contact)) {
	                contacts[i] = contacts[contactCount - 1]; // Replace with the last contact
	                contacts[contactCount - 1] = null;
	                contactCount--;
	                break;
	            }
	        }
	    }

}
