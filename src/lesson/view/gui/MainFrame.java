package lesson.view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lesson.log.Admin;

// (1) 검색 - 전체 검색, 강의 제목 기준 검색, 강사 이름 기준 검색 (
// (1) 삽입 - 새로운 강의 정보 삽입
// (3) 수정 - 강의별 주강사&보조강사 수정, 가격 할인
// (4) 삭제 - 강의 정보 삭제
public class MainFrame extends JFrame {
	JPanel displayPanel;

	public MainFrame() {
		// 프레임
		this.setSize(360, 120); // 프레임 개체 생성 및 제목 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X 버튼 클릭시 종료
		// 창 위치
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation(screenSize.width / 2, screenSize.height / 2);
		// 패널1 (버튼들)
		ButtonPanel buttonPanel = new ButtonPanel();
		// 패널2 (display)
		displayPanel = new JPanel();
		displayPanel.setLayout(new FlowLayout());
		JLabel label = new JLabel("메가스터디 영어 강의 관리 프로그램");
		displayPanel.add(label);
		getContentPane().add(buttonPanel); // 레이아웃끼리 정렬
		getContentPane().add(displayPanel, BorderLayout.NORTH);
		// show
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}

// 버튼 클래스
class ButtonPanel extends Panel implements ActionListener {
	JButton read, insert, update, delete;

	ButtonPanel() {
		this.setLayout(new FlowLayout());
		read = new JButton("검색");
		this.add(read);
		read.addActionListener(this);

		if (Admin.getAdminAuthority()) {
			insert = new JButton("삽입");
			update = new JButton("수정");
			delete = new JButton("삭제");
			this.add(insert);
			this.add(update);
			this.add(delete);
			insert.addActionListener(this);
			update.addActionListener(this);
			delete.addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o == read) {
			ReadWindow r = new ReadWindow();
		} else if (o == insert) {
			new InsertWindow();
		} else if (o == update) {
			new UpdateWindow();
		} else if (o == delete) {
			new DeleteWindow();
		}
	}
}