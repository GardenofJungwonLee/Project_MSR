package lesson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class LessonInfo {

	private String serialNumber;
	private Lesson lesson;
	private Teacher teacher;
	private Assistant assistant;
	private Area area;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 강의코드 : ");
		builder.append(serialNumber);
		builder.append("\n2. 강의정보 : ");
		builder.append(lesson);
		builder.append("\n3. 강의 선생님 : ");
		builder.append(teacher);
		builder.append("\n4. 보조 선생님 : ");
		builder.append(assistant);
		builder.append("\n5. 지역 : ");
		builder.append(area);
		return builder.toString();
	}

}
