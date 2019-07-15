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

/*public static void main(String[] args) {
	Lesson l = new Lesson("집에", 1, 1);
	Teacher t = new Teacher("이정원", 25, 3000, "SSS", 100);
	Assistant as = new Assistant("변영인", 25, 30, 1);
	Area ar = new Area("엔코아", 30, 4);
	LessonInfo test = new LessonInfo("ENG001", l, t, as, ar);
	System.out.println(test);
}*/

}
