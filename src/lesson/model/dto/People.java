package lesson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class People {
	String name;
	int age;
	int wage;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[이름 : ");
		builder.append(name);
		builder.append(", 나이 : ");
		builder.append(age);
		builder.append(" 살, 연봉 : ");
		builder.append(wage);
		builder.append(" 만원");
		return builder.toString();
	}
}
