package lesson.view.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lesson.controller.LessonController;

// https://brian-s.tistory.com/97 ~ 기초 awt,swing, container 등
// https://m.blog.naver.com/imf4/220631763652 ~ 기초2 jpanel 등
// https://hallang.tistory.com/137 ~ 경고창 메시지
// https://movefast.tistory.com/62 ~ jlabel
// https://m.blog.naver.com/lbo1989/220783608100 ~ java 보더 만들기
// https://www.crocus.co.kr/551 ~ 레이블/라디오 버튼
// https://movefast.tistory.com/62 ~ 리스트 (연관 문서로 spiner)
public class ReadWindow extends JFrame implements ActionListener {
	JPanel panel;
	JComboBox<String> dropdown;
	JTextField searchKeyword;
	JButton search;
	LessonController controller = LessonController.getInstance();

	public ReadWindow() {
		// 프레임
		this.setSize(240, 120); // 프레임 개체 생성 및 제목 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		; // X 버튼 클릭시 종료
			// 창 위치
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation(screenSize.width / 2, screenSize.height / 2);
		// 패널
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		// 콤보박스
		String[] dropdownList = { "강의 제목 검색", "강사 이름 검색", "모든 강의 검색" };
		dropdown = new JComboBox<>(dropdownList);
		dropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb = (JComboBox) e.getSource();
				int index = jcb.getSelectedIndex();
				if (index != 2) {
					searchKeyword.setVisible(true);
				} else if (index == 2) {
					searchKeyword.setVisible(false);
				}
			}
		});
		// 검색버튼
		search = new JButton("검색");
		search.addActionListener(this);
		searchKeyword = new JTextField(20);
		panel.add(dropdown);
		panel.add(search);
		panel.add(searchKeyword);
		getContentPane().add(panel);
		// show
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o == search) {
			this.setVisible(false);
			int index = dropdown.getSelectedIndex();
			String text = searchKeyword.getText();
			if (index == 0) {
				JOptionPane.showMessageDialog(null, "강의 제목 검색을 실행합니다 (검색어 :" + text + ")");
				controller.infoViewByTitle(text);
			} else if (index == 1) {
				JOptionPane.showMessageDialog(null, "강사 이름 검색을 실행합니다 (검색어 :" + text + ")");
				controller.infoViewByTeacher(text);
			} else if (index == 2) {
				JOptionPane.showMessageDialog(null, "모든 강의 검색을 실행합니다");
				controller.infoListView();
			}
		}
	}

	public static void main(String[] args) {
		new ReadWindow();
	}
}