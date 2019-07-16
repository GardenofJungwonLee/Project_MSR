package lesson.model.dto;

import lombok.Data;

@Data
public class Teacher extends People {
	String level;
	int careerYear;

	public Teacher(String name, int age, int wage, String level, int careerYear) {
		super(name, age, wage);
		this.level = level;
		this.careerYear = careerYear;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 강사등급 : ");
		builder.append(level);
		builder.append(", 경력 : ");
		builder.append(careerYear);
		builder.append(" 년]");
		return builder.toString();
	}

}
