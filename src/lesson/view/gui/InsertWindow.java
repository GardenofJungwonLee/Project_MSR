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
		String[] dropdownList = { "��� ���� �˻�", "���� ���� �˻�", "���� �̸� �˻�" };
		dropdown = new JComboBox<>(dropdownList);
		dropdown.setToolTipText("���ϴ� �˻� ����� �����ϼ���");
		// �˻���ư
		search = new JButton("�˻�");
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
			JOptionPane.showMessageDialog(null, "�˻� ����� �����մϴ�");
		}
	}
}
