package Miniproj;

public class GroupService {
	
	private Group[] groups;
    private int groupCount;

    public GroupService(int initialSize) {
        this.groups = new Group[initialSize];
        this.groupCount = 0;
    }

    public void createGroup(String groupName, String groupDescription) {
        if (groupCount < groups.length) {
            groups[groupCount++] = new Group(groupName, groupDescription);
        } else {
           
            System.out.println("No more groups can be created");
        }
    }

    public Group getGroup(String groupName) {
        for (int i = 0; i < groupCount; i++) {
            if (groups[i].getGroupName().equals(groupName)) {
                return groups[i];
            }
        }
        return null;
    }

    public void updateGroup(String groupName, String newDescription) {
        Group group = getGroup(groupName);
        if (group != null) {
            group.setGroupDescription(newDescription);
        }
    }

    public void deleteGroup(String groupName) {
        for (int i = 0; i < groupCount; i++) {
            if (groups[i].getGroupName().equals(groupName)) {
                groups[i] = groups[groupCount - 1]; // Replace with the last group
                groups[groupCount - 1] = null;
                groupCount--;
                break;
            }
        }
    }

    public Group[] getAllGroups() {
        return groups;
    }
	
}
