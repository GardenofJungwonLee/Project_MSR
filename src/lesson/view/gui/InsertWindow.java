package lesson.view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lesson.log.Admin;
import lesson.log.Common;

public class InsertWindow extends JFrame implements ActionListener {
	JPanel panel;
	JComboBox<String> dropdown;
	JButton search;

	public InsertWindow() {
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
		String[] dropdownList = { "모든 강의 검색", "강의 제목 검색", "강사 이름 검색" };
		dropdown = new JComboBox<>(dropdownList);
		dropdown.setToolTipText("원하는 검색 방식을 선택하세요");
		// 검색버튼
		search = new JButton("검색");
		search.addActionListener(this);
		panel.add(search);
		panel.add(dropdown);
		getContentPane().add(panel);
		// show
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o == search) {
			JOptionPane.showMessageDialog(null, "검색 기능을 실행합니다");
		}
	}
}
