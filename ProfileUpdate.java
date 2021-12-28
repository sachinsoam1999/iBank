package com.sachin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileUpdate extends JFrame implements ActionListener {

	final JLabel l1;
	final JLabel l2;
	final JLabel l3;
	final JLabel l4;
	final JLabel l5;
	final JTextField t1;
	final JTextField t2;
	final JTextField t3;
	final JTextField t4;
	final JButton b1 = new JButton("Go Back");
	final JButton b2 = new JButton("Submit");
	final String customerId;
	final String phone_num;

	ProfileUpdate(String customerId, String phone_num) {
		this.customerId = customerId;
		this.phone_num = phone_num;

		setTitle("Update Profile");
		setSize(650, 410);
		getContentPane().setBackground(Utils.MY_BG_COLOR);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel iBank = new JLabel("iBank internet banking", SwingConstants.CENTER);
		Utils.setLabel(iBank, Utils.MY_RED_COLOR, Color.WHITE, 24);
		iBank.setBounds(0, 0, getWidth(), 50);
		add(iBank);

		l1 = new JLabel("Change Account Details");
		Utils.setLabel(l1, Utils.MY_BG_COLOR, Color.BLACK, 22);
		l1.setBounds(48, 70, 250, 30);
		add(l1);

		l2 = new JLabel("Name");
		Utils.setLabel(l2, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l2.setBounds(50, 150, 50, 30);
		add(l2);

		l3 = new JLabel("Email-id");
		Utils.setLabel(l3, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l3.setBounds(50, 190, 70, 30);
		add(l3);

		l4 = new JLabel("Address");
		Utils.setLabel(l4, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l4.setBounds(50, 230, 70, 30);
		add(l4);

		l5 = new JLabel("Phone Number");
		Utils.setLabel(l5, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l5.setBounds(50, 270, 120, 30);
		add(l5);

		Utils.setButton(b1);
		b1.setBounds(500, 70, 120, 50);
		add(b1);

		t1 = new JTextField();
		Utils.setTextField(t1);
		t1.setBounds(300, 150, 320, 30);
		add(t1);

		t2 = new JTextField();
		Utils.setTextField(t2);
		t2.setBounds(300, 190, 320, 30);
		add(t2);

		t3 = new JTextField();
		Utils.setTextField(t3);
		t3.setBounds(300, 230, 320, 30);
		add(t3);

		t4 = new JTextField();
		Utils.setTextField(t4);
		t4.setBounds(300, 270, 320, 30);
		add(t4);

		Utils.setButton(b2);
		b2.setBounds(50, 310, 570, 50);
		add(b2);

		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			dispose();
			new Dashboard(customerId, phone_num);
		} else if (e.getSource() == b2) {
			DatabaseConnection db_conn = new DatabaseConnection();
			String query = "UPDATE customers SET full_name='%s',email='%s',address='%s',phone_num ='+91%s' where id = '%s';";
			query = String.format(query, t1.getText(), t2.getText(), t3.getText(), t4.getText(), customerId);

			OTPDialog otpDialog = new OTPDialog((JFrame) this.getRootPane().getParent(), phone_num);
			if (otpDialog.getOtpValidated()) {
				int rs = db_conn.update(query);
				if (rs == 1) {
					dispose();
					new MyDialog((JFrame) getRootPane().getParent(), "Success", "Profile updated successfully!!!", "Ok");
					new Dashboard(customerId, phone_num);
				} else {
					new MyDialog((JFrame) getRootPane().getParent(), "Try Again", Utils.ERROR, "Ok");
				}
			}
		}
	}
}


