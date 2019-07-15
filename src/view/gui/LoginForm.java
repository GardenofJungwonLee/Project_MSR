package view.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// https://brian-s.tistory.com/97
// https://m.blog.naver.com/imf4/220631763652
public class LoginForm extends JFrame implements ActionListener {
	JPanel panel1, panel2;
	JTextField id;
	JButton confirm, cancel;
	
	public LoginForm() {
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
		String admin_id = "admin";
		String common_id = "young";
		String inputText = id.getText().trim();
		if (o==confirm) {
			if (admin_id.equals(inputText)) {
				id.setText("Success (Admin)");
			} else if (common_id.equals(inputText)) {
				id.setText("Success (Common)");
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
