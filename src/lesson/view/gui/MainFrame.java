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

// (1) �˻� - ��ü �˻�, ���� ���� ���� �˻�, ���� �̸� ���� �˻� (
// (1) ���� - ���ο� ���� ���� ����
// (3) ���� - ���Ǻ� �ְ���&�������� ����, ���� ����
// (4) ���� - ���� ���� ����
public class MainFrame extends JFrame {
	JPanel displayPanel;

	public MainFrame() {
		// ������
		this.setSize(360, 120); // ������ ��ü ���� �� ���� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X ��ư Ŭ���� ����
		// â ��ġ
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation(screenSize.width / 2, screenSize.height / 2);
		// �г�1 (��ư��)
		ButtonPanel buttonPanel = new ButtonPanel();
		// �г�2 (display)
		displayPanel = new JPanel();
		displayPanel.setLayout(new FlowLayout());
		JLabel label = new JLabel("�ް����͵� ���� ���� ���� ���α׷�");
		displayPanel.add(label);
		getContentPane().add(buttonPanel); // ���̾ƿ����� ����
		getContentPane().add(displayPanel, BorderLayout.NORTH);
		// show
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}

// ��ư Ŭ����
class ButtonPanel extends Panel implements ActionListener {
	JButton read, insert, update, delete;

	ButtonPanel() {
		this.setLayout(new FlowLayout());
		read = new JButton("�˻�");
		this.add(read);
		read.addActionListener(this);

		if (Admin.getAdminAuthority()) {
			insert = new JButton("����");
			update = new JButton("����");
			delete = new JButton("����");
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