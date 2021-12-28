package com.sachin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame implements ActionListener {
	final JLabel l1;
	final JLabel l2;
	final JLabel l3;
	final JLabel l4;
	final JLabel l5;
	final JLabel l6;
	final JLabel l7;
	final JLabel l8;
	final JLabel l9;
	final JLabel l10;
	final JLabel l11;
	final JLabel l12;
	final JLabel l13;
	final JLabel l14;
	final JLabel l15;
	final JLabel l16;
	final JLabel l17;
	final JLabel l18;
	final JLabel l19;
	final JLabel l20;
	final JLabel l21;
	final JLabel l22;
	final JLabel l23;
	final JLabel l24;
	final JLabel l25;
	final JLabel l26;
	final JLabel l27;
	final JButton b1 = new JButton("Go Back");
	final String customerId;
	String phone_num = null;

	Profile(String customerId) {
		this.customerId = customerId;
		DatabaseConnection db_conn = new DatabaseConnection();
		String[] details = db_conn.getCustomerDetails("SELECT * FROM customers where id = '" + customerId + "'");
		setTitle("Profile");
		setSize(650, 700);
		getContentPane().setBackground(Utils.MY_BG_COLOR);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel iBank = new JLabel("iBank internet banking", SwingConstants.CENTER);
		Utils.setLabel(iBank, Utils.MY_RED_COLOR, Color.WHITE, 24);
		iBank.setBounds(0, 0, getWidth(), 50);
		add(iBank);

		l1 = new JLabel("Your Account Details");
		Utils.setLabel(l1, Utils.MY_BG_COLOR, Color.BLACK, 22);
		l1.setBounds(48, 70, 200, 30);
		add(l1);


		l2 = new JLabel("Id");
		Utils.setLabel(l2, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l2.setBounds(50, 130, 50, 30);
		add(l2);


		l3 = new JLabel("Name");
		Utils.setLabel(l3, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l3.setBounds(50, 170, 70, 30);
		add(l3);

		l4 = new JLabel("Email-id");
		Utils.setLabel(l4, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l4.setBounds(50, 210, 100, 30);
		add(l4);

		l5 = new JLabel("Address");
		Utils.setLabel(l5, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l5.setBounds(50, 250, 100, 30);
		add(l5);

		l6 = new JLabel("Phone Number");
		Utils.setLabel(l6, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l6.setBounds(50, 290, 150, 30);
		add(l6);

		l7 = new JLabel("Gender");
		Utils.setLabel(l7, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l7.setBounds(50, 330, 90, 30);
		add(l7);

		l8 = new JLabel("DOB");
		Utils.setLabel(l8, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l8.setBounds(50, 370, 100, 30);
		add(l8);

		l9 = new JLabel("Account Number");
		Utils.setLabel(l9, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l9.setBounds(50, 410, 150, 30);
		add(l9);

		l10 = new JLabel("Account Type");
		Utils.setLabel(l10, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l10.setBounds(50, 450, 150, 30);
		add(l10);

		l11 = new JLabel("Balance");
		Utils.setLabel(l11, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l11.setBounds(50, 490, 100, 30);
		add(l11);

		l12 = new JLabel("Adhaar Number");
		Utils.setLabel(l12, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l12.setBounds(50, 530, 150, 30);
		add(l12);

		l24 = new JLabel("PAN");
		Utils.setLabel(l24, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l24.setBounds(50, 570, 70, 30);
		add(l24);

		l26 = new JLabel("Last login date");
		Utils.setLabel(l26, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l26.setBounds(50, 610, 150, 30);
		add(l26);


		Utils.setButton(b1);
		b1.setBounds(500, 70, 120, 50);
		add(b1);

		l13 = new JLabel();
		Utils.setLabel(l13, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l13.setBounds(300, 130, 400, 30);
		add(l13);

		l14 = new JLabel();
		Utils.setLabel(l14, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l14.setBounds(300, 170, 400, 30);
		add(l14);

		l15 = new JLabel();
		Utils.setLabel(l15, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l15.setBounds(300, 210, 400, 30);
		add(l15);

		l16 = new JLabel();
		Utils.setLabel(l16, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l16.setBounds(300, 250, 400, 30);
		add(l16);

		l17 = new JLabel();
		Utils.setLabel(l17, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l17.setBounds(300, 290, 400, 30);
		add(l17);

		l18 = new JLabel();
		Utils.setLabel(l18, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l18.setBounds(300, 330, 400, 30);
		add(l18);

		l19 = new JLabel();
		Utils.setLabel(l19, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l19.setBounds(300, 370, 400, 30);
		add(l19);

		l20 = new JLabel();
		Utils.setLabel(l20, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l20.setBounds(300, 410, 400, 30);
		add(l20);

		l21 = new JLabel();
		Utils.setLabel(l21, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l21.setBounds(300, 450, 400, 30);
		add(l21);

		l22 = new JLabel();
		Utils.setLabel(l22, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l22.setBounds(300, 490, 400, 30);
		add(l22);

		l23 = new JLabel();
		Utils.setLabel(l23, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l23.setBounds(300, 530, 400, 30);
		add(l23);

		l25 = new JLabel();
		Utils.setLabel(l25, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l25.setBounds(300, 570, 150, 30);
		add(l25);

		l27 = new JLabel();
		Utils.setLabel(l27, Utils.MY_BG_COLOR, Color.BLACK, 20);
		l27.setBounds(300, 610, 200, 30);
		add(l27);

		setVisible(true);

		if (details != null) {
			phone_num = details[3];
			l13.setText(details[12]);
			l14.setText(details[0]);
			l15.setText(details[1]);
			l16.setText(details[2]);
			l17.setText(phone_num);
			l18.setText(details[4].toUpperCase());
			l19.setText(details[7]);
			l20.setText(details[5]);
			l21.setText(details[6].toUpperCase());
			l22.setText("Rs. " + details[10]);
			l23.setText(details[8]);
			l25.setText(details[9]);
			l27.setText(details[11]);
		} else {
			dispose();
			new MyDialog((JFrame) getRootPane().getParent(), "Try Again", Utils.ERROR, "Ok");
			new Profile(customerId);
		}

		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			dispose();
			if (phone_num != null) {
				new Dashboard(customerId, phone_num);
			}
		}
	}
}
