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

// https://brian-s.tistory.com/97 ~ ���� awt,swing, container ��
// https://m.blog.naver.com/imf4/220631763652 ~ ����2 jpanel ��
// https://hallang.tistory.com/137 ~ ���â �޽���
// https://movefast.tistory.com/62 ~ jlabel
// https://m.blog.naver.com/lbo1989/220783608100 ~ java ���� �����
// https://www.crocus.co.kr/551 ~ ���̺�/���� ��ư
// https://movefast.tistory.com/62 ~ ����Ʈ (���� ������ spiner)
public class ReadWindow extends JFrame implements ActionListener {
	JPanel panel;
	JComboBox<String> dropdown;
	JTextField searchKeyword;
	JButton search;
	LessonController controller = LessonController.getInstance();

	public ReadWindow() {
		// ������
		this.setSize(240, 120); // ������ ��ü ���� �� ���� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		; // X ��ư Ŭ���� ����
			// â ��ġ
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation(screenSize.width / 2, screenSize.height / 2);
		// �г�
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		// �޺��ڽ�
		String[] dropdownList = { "���� ���� �˻�", "���� �̸� �˻�", "��� ���� �˻�" };
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
		// �˻���ư
		search = new JButton("�˻�");
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
				JOptionPane.showMessageDialog(null, "���� ���� �˻��� �����մϴ� (�˻��� :" + text + ")");
				controller.infoViewByTitle(text);
			} else if (index == 1) {
				JOptionPane.showMessageDialog(null, "���� �̸� �˻��� �����մϴ� (�˻��� :" + text + ")");
				controller.infoViewByTeacher(text);
			} else if (index == 2) {
				JOptionPane.showMessageDialog(null, "��� ���� �˻��� �����մϴ�");
				controller.infoListView();
			}
		}
	}

	public static void main(String[] args) {
		new ReadWindow();
	}
}