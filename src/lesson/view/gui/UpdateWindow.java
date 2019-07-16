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

// https://brian-s.tistory.com/97 ~ ���� awt,swing, container ��
// https://m.blog.naver.com/imf4/220631763652 ~ ����2 jpanel ��
// https://hallang.tistory.com/137 ~ ���â �޽���
// https://movefast.tistory.com/62 ~ jlabel
// https://m.blog.naver.com/lbo1989/220783608100 ~ java ���� �����
// https://www.crocus.co.kr/551 ~ ���̺�/���� ��ư
// https://movefast.tistory.com/62 ~ ����Ʈ (���� ������ spiner)
public class UpdateWindow extends JFrame implements ActionListener {
	JPanel panel1, panel2;
	JTextField id;
	JButton confirm, cancel;
	
	static {
		Common.addID("YoungIn");
		Common.addID("JungWon");
	}
	
	public UpdateWindow() {
		// ������
		this.setSize(240, 120); // ������ ��ü ���� �� ���� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		; // X ��ư Ŭ���� ����
		// â ��ġ
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation(screenSize.width / 2, screenSize.height / 2);
		// �г�1 (���̵�)
		panel1 = new JPanel();
//		panel1.setLayout(new GridLayout(1,2)); // 1�� 2���� ȭ���� ����
		panel1.setLayout(new FlowLayout()); // 1�� 2���� ȭ���� ����
		id = new JTextField(10);
		panel1.add(new JLabel("ID", JLabel.LEFT));
		panel1.add(id);
		id.setToolTipText("ID�� �Է��ϼ���");
		// �г�2 (��ư)
		panel2 = new JPanel();
		confirm = new JButton("Ȯ��");
		cancel = new JButton("���");
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
				JOptionPane.showMessageDialog(null, Admin.loginGUI()); // ���â ����
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
