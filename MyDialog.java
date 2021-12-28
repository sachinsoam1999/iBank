package com.sachin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MyDialog extends JDialog implements ActionListener {

	final int WIDTH = 400;
	final int HEIGHT = 200;

	JLabel msgLabel;
	JButton btnPositive;
	final JButton btnNegative = new JButton("Cancel");

	MyDialog(JFrame owner, String title, String msg, String posBtnText) {
		super(owner, title, JDialog.DEFAULT_MODALITY_TYPE);
		setUi(msg, posBtnText);

	}

	MyDialog(OTPDialog owner, String title, String msg, String posBtnText) {
		super(owner, title, JDialog.DEFAULT_MODALITY_TYPE);
		setUi(msg, posBtnText);
	}

	private void setUi(String msg, String posBtnText) {

		this.setSize(WIDTH, HEIGHT);
		this.getContentPane().setBackground(Utils.MY_BG_COLOR);
		this.setLayout(new GridBagLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.msgLabel = new JLabel(msg, SwingConstants.CENTER);
		this.btnPositive = new JButton(posBtnText);

		Utils.setLabel(msgLabel, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 22);
		Utils.setButton(btnPositive);
		Utils.setButton(btnNegative);
		btnPositive.setPreferredSize(new Dimension(140, 35));
		btnNegative.setPreferredSize(new Dimension(140, 35));


		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.weighty = 0.2;
		add(msgLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(btnNegative, gbc);

		final JPanel spacer1 = new JPanel();
		spacer1.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(spacer1, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(btnPositive, gbc);

		final JPanel spacer2 = new JPanel();
		spacer2.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.VERTICAL;
		add(spacer2, gbc);

		final JPanel spacer3 = new JPanel();
		spacer3.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(spacer3, gbc);

		final JPanel spacer4 = new JPanel();
		spacer4.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(spacer4, gbc);

		btnPositive.addActionListener(this);
		btnNegative.addActionListener(this);

		this.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		if (e.getSource() == btnPositive && btnPositive.getText().equals("Yes")) {
			getOwner().dispose();
			new Login();
		}
	}

}

