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
		builder.append("[�̸� : ");
		builder.append(name);
		builder.append(", ���� : ");
		builder.append(age);
		builder.append(" ��, ���� : ");
		builder.append(wage);
		builder.append(" ����");
		return builder.toString();
	}
}
