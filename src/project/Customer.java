package project;

public class Customer {
	
	// 필드
	private int index;
	private int age;
	private String gender;
	private int spentTime;
	private String groupType;
	private static int count = 0;
	
	// 생성자
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
	
	// 고객이 해당 그룹에 속하는지 판별, 그룹 정보나 고객 정보가 미입력 된 경우 false
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
