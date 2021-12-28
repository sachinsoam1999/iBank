package com.sachin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OTPDialog extends JDialog implements ActionListener {

	final int WIDTH = 400;
	final int HEIGHT = 200;
	boolean isOtpValidated = false;

	final String otp = Generator.generateOTP();
	final String phone_num;

	final JLabel otpLabel = new JLabel("OTP:");
	final JLabel msgSentLabel = new JLabel(Utils.ERROR);
	final JTextField otpTextField = new JTextField();
	final JButton btnSubmit = new JButton("Submit");
	final JButton btnCancel = new JButton("Cancel");
	final JPanel jPanel = new JPanel(new GridBagLayout());


	OTPDialog(JFrame owner, String phone_num) {
		super(owner, "Enter otp", JDialog.DEFAULT_MODALITY_TYPE);

		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.phone_num = phone_num;


		setUi();
		add(jPanel, BorderLayout.CENTER);

		btnSubmit.addActionListener(this);
		btnCancel.addActionListener(this);


		System.out.println(this.phone_num + ':' + otp);
//		8weRo8cm2bICYNehAzup217WSdzbG2qrGBDN5UG1
//		sendOtp();
		if (msgSentLabel.getText().equals(Utils.ERROR)) {
//			btnSubmit.setVisible(false);
//			otpTextField.setVisible(false);
//			otpLabel.setVisible(false);
		}

		setVisible(true);

	}

	private void sendOtp() {
		String sid;
		MessageSender messageSender = new MessageSender();
		sid = messageSender.send(phone_num, "Your otp for iBank login validation is " + otp);
		if (!sid.equals("")) {
			// msg sent successfully
			msgSentLabel.setText("otp has been sent to your registered mobile number");
		}
	}

	private void setUi() {
		jPanel.setBackground(Utils.MY_BG_COLOR);
		Utils.setLabel(msgSentLabel, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 18);

		Utils.setLabel(otpLabel, Utils.MY_BG_COLOR, Color.BLACK, 18);
		Utils.setTextField(otpTextField);
		Utils.setButton(btnSubmit);
		Utils.setButton(btnCancel);

		GridBagConstraints gbc;
		gbc = new GridBagConstraints();

		// first row
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		jPanel.add(msgSentLabel, gbc);

		// second row
		gbc = new GridBagConstraints();
		final JPanel spacer1 = new JPanel();
		spacer1.setBackground(Utils.MY_BG_COLOR);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(spacer1, gbc);

		final JPanel spacer2 = new JPanel();
		spacer2.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(spacer2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.CENTER;
		jPanel.add(otpLabel, gbc);

		gbc.gridx = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0.1;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		jPanel.add(otpTextField, gbc);

		// third row
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(btnSubmit, gbc);

		gbc.gridx = 3;
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		jPanel.add(btnCancel, gbc);

		final JPanel spacer3 = new JPanel();
		spacer3.setBackground(Utils.MY_BG_COLOR);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(spacer3, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCancel) {
			dispose();
		} else {
			if (otpTextField.getText().equals(otp)) {
				//success login
				isOtpValidated = true;
				dispose();
			} else {
				new MyDialog(this, "Error", "Otp doesn't match", "Ok");
			}
		}
	}

	public boolean getOtpValidated() {
		return isOtpValidated;
	}
}

