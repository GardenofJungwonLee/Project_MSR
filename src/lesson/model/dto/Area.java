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
		builder.append("[���� : ");
		builder.append(areaName);
		builder.append(", �ο��� : ");
		builder.append(areaHeadCount);
		builder.append(" ��, ��� : ");
		builder.append(areaScore);
		builder.append(" ���]");
		return builder.toString();
	}
}
