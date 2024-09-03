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

	    public void addGroup(Group group) {
	    	if (groupCount < groups.length) {
	            for (int i = 0; i < groupCount; i++) {
	                if (groups[i] == group) {
	                    return;
	                }
	            }
	            groups[groupCount] = group;
	            groupCount++;
	        } else {
	            System.out.println("No more groups can be added.");
	        }   
	    }

	    public void removeGroup(Group group) {
	        for (int i = 0; i < groupCount; i++) {
	            if (groups[i].equals(group)) {
	                groups[i] = groups[groupCount - 1]; // Replace with the last group
	                groups[groupCount - 1] = null;
	                groupCount--;
	                break;
	            }
	        }
	    }



		@Override
		public int compareTo(Contact o) {
			return this.phoneNumber.compareTo(o.phoneNumber);
		}

}
