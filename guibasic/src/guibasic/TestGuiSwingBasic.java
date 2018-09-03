package guibasic;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGuiSwingBasic extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4;
	JPanel p;

	TestGuiSwingBasic() {
		super("MyFrame 만들기"); // ==setTitle("MyFrame 만들기");
		setSize(350, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료

		p = new JPanel();
		p.setBackground(Color.pink);

		p.setLayout(new FlowLayout());
		b1 = new JButton("파란색");
		b2 = new JButton("분홍색");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p.add(b1);
		p.add(b2);
		add(p);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			p.setBackground(Color.blue);
		} else if(e.getSource()==b2) {
			p.setBackground(Color.pink);
		}
	}

	public static void main(String[] args) {
		new TestGuiSwingBasic();
	}
}
