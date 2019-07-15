package lesson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lesson {
	String title;
	int period;
	double price;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���� ���� : ");
		builder.append(title);
		builder.append(", �Ⱓ : ");
		builder.append(period);
		builder.append(" ����, ���� : ");
		builder.append(price);
		builder.append(" ����]");
		return builder.toString();
	}

}
