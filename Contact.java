package Miniproj;

public class Contact implements Comparable<Contact> {
      private static int groupArraySize=25;
	    private String name;
	    private String phoneNumber;
	    private String countryCode;
	    private Group[] groups=new Group[groupArraySize];
	    private int groupCount;
	
	    
	  


		public Contact(String name2, String phoneNumber2, String countryCode2) {
			// TODO Auto-generated constructor stub
			  this.name = name2;
		        this.phoneNumber = phoneNumber2;
		        this.countryCode = countryCode2;
		        this.groupCount = 0;
		}




		// Getters and setters
	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getPhoneNumber() { return phoneNumber; }
	    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	    public String getCountryCode() { return countryCode; }
	    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

	    public Group[] getGroups() { return groups; }

	    public void addGroup(Group group) throws GroupLimitExceededException, DuplicateGroupException {
	    	 if (groupCount >= groups.length) {
	             throw new GroupLimitExceededException("Contact cannot be added to more groups.");
	         }
	         for (int i = 0; i < groupCount; i++) {
	             if (groups[i] == group) {
	                 throw new DuplicateGroupException("This contact is already part of the group.");
	             }
	         }
	         groups[groupCount++] = group;   
	    }

	    public void removeGroup(Group group) throws GroupNotFoundException {
	    	boolean found = false;
	        for (int i = 0; i < groupCount; i++) {
	            if (groups[i].equals(group)) {
	                groups[i] = groups[groupCount - 1]; // Replace with the last group
	                groups[groupCount - 1] = null;
	                groupCount--;
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            throw new GroupNotFoundException("Group not found in the contact's list.");
	        }
	    }



		@Override
		public int compareTo(Contact o) {
			return this.phoneNumber.compareTo(o.phoneNumber);
		}

}
