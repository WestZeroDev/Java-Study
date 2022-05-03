package project;

public class Customer {
	
	// �ʵ�
	private int index;
	private int age;
	private String gender;
	private int spentTime;
	private String groupType;
	private static int count = 0;
	
	// ������
	public Customer() {
		count++;
	}
	public Customer(int index) {
		this.index = index;
		count++;
	}
	
	// getter, setter
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSpentTime() {
		return spentTime;
	}
	public void setSpentTime(int spentTime) {
		this.spentTime = spentTime;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public static int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return String.format("No.%2d => Age: %d, Gender: %s, SpentTime: %d, GroupType: %s", index, age, gender, spentTime, groupType);
	}
	
	// ���� �ش� �׷쿡 ���ϴ��� �Ǻ�, �׷� ������ �� ������ ���Է� �� ��� false
	public boolean classify(Group group) {
		if(group.noParameter() || group.getMaxAge() == 0 || 
				group.getGender() == null || group.getSpentTime() == 0 || 
				age == 0 || gender == null || spentTime == 0) return false;
		else {
			return age >= group.getMinAge() && age <= group.getMaxAge()
					&& gender.equals(group.getGender())
					&& spentTime <= group.getSpentTime();
		}
	}
	
}
