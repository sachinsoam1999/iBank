package com.sachin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Login extends JFrame implements ActionListener {

	final int WIDTH = 700;
	final int HEIGHT = 550;

	final JTextField customerId = new JTextField();
	final JTextField password = new JPasswordField();
	final JTextField captchaShow = new JTextField();
	final JTextField captchaEnter = new JTextField();
	final JButton btnCaptchaRefresh = new JButton("Refresh");
	final JButton btnLogin = new JButton("Log in");
	final JLabel labelForgot = new JLabel("<HTML><U>Forgot Customer-Id/Password?</U></HTML>");
	final JLabel labelRegister = new JLabel("<HTML><U>Click here to Register yourself</U></HTML>");

	final JPanel center = new JPanel(new GridBagLayout());
	final JPanel bottom = new JPanel(new GridBagLayout());

	Login() {
		setTitle("Login");
		getContentPane().setBackground(Utils.MY_BG_COLOR);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel welcome = new JLabel("Welcome to iBank internet banking", SwingConstants.CENTER);
		Utils.setLabel(welcome, Utils.MY_RED_COLOR, Color.WHITE, 22);

		welcome.setPreferredSize(new Dimension(0, 50));
		add(welcome, BorderLayout.NORTH);

		setCenterPanel();
		add(center, BorderLayout.CENTER);

		setBottomPanel();
		add(bottom, BorderLayout.SOUTH);

		setVisible(true);

		btnCaptchaRefresh.addActionListener(this);
		btnLogin.addActionListener(this);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				btnLogin.setBackground(Color.BLACK);
				btnLogin.setForeground(Utils.MY_BTN_BG_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				btnLogin.setBackground(Utils.MY_BTN_BG_COLOR);
				btnLogin.setForeground(Color.BLACK);
			}
		});
		btnCaptchaRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				btnCaptchaRefresh.setBackground(Color.BLACK);
				btnCaptchaRefresh.setForeground(Utils.MY_BTN_BG_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				btnCaptchaRefresh.setBackground(Utils.MY_BTN_BG_COLOR);
				btnCaptchaRefresh.setForeground(Color.BLACK);
			}
		});
		labelForgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new MyDialog((JFrame) getRootPane().getParent(), "Try Again", "Work in Progress", "Ok");
			}
		});
		labelRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new MyDialog((JFrame) getRootPane().getParent(), "Try Again", "Work in Progress", "Ok");
			}
		});

	}

	private void setBottomPanel() {
		bottom.setBackground(Utils.MY_BG_COLOR);
		Utils.setLabel(labelRegister, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 22);
		Utils.setLabel(labelForgot, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 22);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0.2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 20;
		bottom.add(labelRegister, gbc);

		gbc.weightx = 0.2;
		gbc.gridx++;
		bottom.add(labelForgot, gbc);
	}

	private void setCenterPanel() {
		center.setBackground(Utils.MY_BG_COLOR);

		final JLabel customerId = new JLabel("Customer Id:");
		Utils.setLabel(customerId, Utils.MY_BG_COLOR, Color.BLACK, 18);

		final JLabel password = new JLabel("Password:");
		Utils.setLabel(password, Utils.MY_BG_COLOR, Color.BLACK, 18);

		final JLabel captcha = new JLabel("Captcha:");
		Utils.setLabel(captcha, Utils.MY_BG_COLOR, Color.BLACK, 18);

		captchaShow.setFont(new Font("Serif", Font.BOLD, 20));
		captchaShow.setHorizontalAlignment(SwingConstants.CENTER);
		captchaShow.setEditable(false);
		captchaShow.setBackground(Color.WHITE);
		captchaShow.setForeground(Utils.MY_RED_COLOR);
		captchaShow.setText(Generator.generateCaptcha());

		Utils.setTextField(this.customerId);
		Utils.setTextField(this.password);
		Utils.setTextField(this.captchaEnter);

		Utils.setButton(btnLogin);
		Utils.setButton(btnCaptchaRefresh);

		GridBagConstraints gbc;

		// first column
		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		center.add(customerId, gbc);

		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		center.add(password, gbc);

		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.ipady = 8;
		gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(captchaShow, gbc);


		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		center.add(captcha, gbc);

		// second column
		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 0.3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(this.customerId, gbc);

		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(this.password, gbc);

		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(this.btnCaptchaRefresh, gbc);

		gbc = new GridBagConstraints();
		gbc.weighty = 0.2;
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(this.captchaEnter, gbc);

		gbc = new GridBagConstraints();
		gbc.weighty = 0.1;
		gbc.insets = new Insets(30, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(this.btnLogin, gbc);

		final JPanel spacer1 = new JPanel();
		spacer1.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(spacer1, gbc);

		final JPanel spacer2 = new JPanel();
		spacer2.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(spacer2, gbc);

		final JPanel spacer3 = new JPanel();
		spacer3.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(spacer3, gbc);

		final JPanel spacer4 = new JPanel();
		spacer4.setBackground(Utils.MY_BG_COLOR);
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		center.add(spacer4, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCaptchaRefresh) {
			captchaShow.setText(Generator.generateCaptcha());
		} else if (e.getSource() == btnLogin) {
			authenticateLogin();
		}

	}

	private void authenticateLogin() {
		if (captchaEnter.getText().equals(captchaShow.getText())) {
			String password = stringToSha1(this.password.getText());
			if (!password.equals("")) {
				DatabaseConnection db_conn = new DatabaseConnection();
				String query = "SELECT * FROM customers where id = '%s' and password='%s'";
				query = String.format(query, customerId.getText(), password);
				String[] result = db_conn.getCustomerDetails(query);

				if (result != null) {
					OTPDialog otpDialog = new OTPDialog((JFrame) this.getRootPane().getParent(), result[3]);
					if (otpDialog.getOtpValidated()) {
						int rs = db_conn.update("UPDATE customers SET last_login_date = '" + getDate() + "'" + " Where id ='" + customerId.getText() + "'");
						if (rs == 1) {
							System.out.println("login date updated");
						}
						dispose();
						new Dashboard(result[12], result[3]);
					}
				} else {
					new MyDialog((JFrame) getRootPane().getParent(), "Error", "Invalid credentials", "Ok");
				}
			}
			else{
				new MyDialog((JFrame) getRootPane().getParent(), "Error", Utils.ERROR, "Ok");
			}
		} else {
			new MyDialog((JFrame) getRootPane().getParent(), "Error", "The Captcha code doesn't match", "Ok");
		}

	}

	private String stringToSha1(String s) {
		String sha1 = "";
		try {
			MessageDigest m = MessageDigest.getInstance("SHA-1");
			m.update(s.getBytes(StandardCharsets.UTF_8));
			sha1 = String.format("%040x", new BigInteger(1, m.digest()));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sha1;
	}

	private String getDate() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		return dateTimeFormatter.format(LocalDateTime.now());
	}
}
