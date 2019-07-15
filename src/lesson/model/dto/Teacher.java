package lesson.model.dto;

import lombok.AllArgsConstructor;
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
	builder.append(", ������ : ");
	builder.append(level);
	builder.append(", ��� : ");
	builder.append(careerYear);
	builder.append(" ��]");
	return builder.toString();
}	
	
}
