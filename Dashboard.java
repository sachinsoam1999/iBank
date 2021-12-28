package com.sachin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	final int WIDTH = 700;
	final int HEIGHT = 550;

	final JLabel labelAccDetails = new JLabel("<HTML><U>Account Details<U></HTML>");
	final JLabel labelUpdateDetails = new JLabel("<HTML><U>Update Account Details</U></HTML>");
	final JLabel labelHistory = new JLabel("<HTML><U>Transaction History</U></HTML>");
	final JLabel labelLogout = new JLabel("<HTML><U>Logout</U></HTML>");

	final JPanel center = new JPanel(new GridBagLayout());

	Dashboard(String customerId, String phone_num) {
		setTitle("Dashboard");
		getContentPane().setBackground(Utils.MY_BG_COLOR);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel welcome = new JLabel("iBank internet banking", SwingConstants.CENTER);
		Utils.setLabel(welcome, Utils.MY_RED_COLOR, Color.WHITE, 22);

		welcome.setPreferredSize(new Dimension(0, 50));
		add(welcome, BorderLayout.NORTH);

		setCenterPanel();
		add(center, BorderLayout.CENTER);

		setVisible(true);

		labelAccDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//open profile
				dispose();
				new Profile(customerId);
			}
		});
		labelUpdateDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//open profile update
				dispose();
				new ProfileUpdate(customerId, phone_num);
			}
		});
		labelHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// open transaction history
				dispose();
				new TransactionHistory(customerId, phone_num);

			}
		});
		labelLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// logout
				new MyDialog((JFrame) getRootPane().getParent(), "Confirmation", "Are you sure you want to logout?", "Yes");

			}
		});

	}

	private void setCenterPanel() {
		center.setBackground(Utils.MY_BG_COLOR);
		Utils.setLabel(labelAccDetails, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 25);
		Utils.setLabel(labelUpdateDetails, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 25);
		Utils.setLabel(labelHistory, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 25);
		Utils.setLabel(labelLogout, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 25);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.CENTER;
		center.add(labelAccDetails, gbc);

		gbc.gridy = 1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.CENTER;
		center.add(labelUpdateDetails, gbc);

		gbc.gridy = 2;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.CENTER;
		center.add(labelHistory, gbc);

		gbc.gridy = 3;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.CENTER;
		center.add(labelLogout, gbc);
	}

}