package lesson.view.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lesson.log.Admin;
import lesson.log.Common;

// https://brian-s.tistory.com/97 ~ 기초 awt,swing, container 등
// https://m.blog.naver.com/imf4/220631763652 ~ 기초2 jpanel 등
// https://hallang.tistory.com/137 ~ 경고창 메시지
// https://movefast.tistory.com/62 ~ jlabel
// https://m.blog.naver.com/lbo1989/220783608100 ~ java 보더 만들기
// https://www.crocus.co.kr/551 ~ 레이블/라디오 버튼
// https://movefast.tistory.com/62 ~ 리스트 (연관 문서로 spiner)
public class UpdateWindow extends JFrame implements ActionListener {
	JPanel panel1, panel2;
	JTextField id;
	JButton confirm, cancel;
	
	static {
		Common.addID("YoungIn");
		Common.addID("JungWon");
	}
	
	public UpdateWindow() {
		// 프레임
		this.setSize(240, 120); // 프레임 개체 생성 및 제목 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		; // X 버튼 클릭시 종료
		// 창 위치
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation(screenSize.width / 2, screenSize.height / 2);
		// 패널1 (아이디)
		panel1 = new JPanel();
//		panel1.setLayout(new GridLayout(1,2)); // 1행 2열로 화면을 분할
		panel1.setLayout(new FlowLayout()); // 1행 2열로 화면을 분할
		id = new JTextField(10);
		panel1.add(new JLabel("ID", JLabel.LEFT));
		panel1.add(id);
		id.setToolTipText("ID를 입력하세요");
		// 패널2 (버튼)
		panel2 = new JPanel();
		confirm = new JButton("확인");
		cancel = new JButton("취소");
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		panel2.add(confirm);
		panel2.add(cancel);
		getContentPane().add(panel1, "Center");
		getContentPane().add(panel2, "South");
		// show
		this.setVisible(true);
		this.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		String inputText = id.getText().trim();
		if (o==confirm) {
			if (Admin.getAdminID().equals(inputText)) {
				JOptionPane.showMessageDialog(null, Admin.loginGUI()); // 경고창 띄우기
				this.setVisible(false);
			} else if (Common.getIdList().contains(inputText)) {
				JOptionPane.showMessageDialog(null, Common.loginGUI(inputText));
				this.setVisible(false);
			} else {
				id.setText("Fail");
				id.requestFocus();
			}
		} else if (o==cancel) {
			id.setText("");
			id.requestFocus();
		}
	}
}
