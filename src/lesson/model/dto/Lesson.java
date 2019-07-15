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
		builder.append("[강의 제목 : ");
		builder.append(title);
		builder.append(", 기간 : ");
		builder.append(period);
		builder.append(" 개월, 가격 : ");
		builder.append(price);
		builder.append(" 만원]");
		return builder.toString();
	}

}
