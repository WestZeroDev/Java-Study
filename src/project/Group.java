package project;

public class Group {

	// 필드
	private String groupType;
	private int minAge;
	private int maxAge;
	private String gender;
	private int spentTime;
	
	// 생성자
	public Group() {}
	public Group(String groupType) {
		this.groupType = groupType;
	}
	
	// getter, setter
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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

	@Override
	public String toString() {
		return String.format("MinAge: %d, MaxAge: %d, Gender: %s, SpentTime: %d", minAge, maxAge, gender, spentTime);
	}

	// 그룹에 입력된 정보가 없는지 판별, 없으면 edit 불가
	public boolean noParameter() {
		return this.minAge == 0 && this.maxAge == 0
				&& this.gender == null && this.spentTime == 0;
	}

}
