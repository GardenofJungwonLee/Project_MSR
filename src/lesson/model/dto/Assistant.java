package lesson.model.dto;

import lombok.Data;

	@Data
	public class Assistant extends People {
		int month;
		
	public Assistant(String name, int age, int wage, int month) {
			super(name, age, wage);
			this.month= month;
		}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", �Ⱓ : ");
		builder.append(month);
		builder.append(" ����]");
		return builder.toString();
	}	
		
	}

