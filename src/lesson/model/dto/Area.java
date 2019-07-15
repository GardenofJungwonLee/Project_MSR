package lesson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Area {
	String areaName;
	int areaHeadCount;
	int areaScore;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[지역 : ");
		builder.append(areaName);
		builder.append(", 인원수 : ");
		builder.append(areaHeadCount);
		builder.append(" 명, 등급 : ");
		builder.append(areaScore);
		builder.append(" 등급]");
		return builder.toString();
	}
}
