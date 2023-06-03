package acad;

import java.awt.FlowLayout;

import javax.swing.*;

public class StatusBar extends JPanel {
	JLabel status;

	public StatusBar() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		status = new JLabel("Comment");
		add(status);
	}

	public void setMessage(String text) {
		this.status.setText(text);
	}

}
