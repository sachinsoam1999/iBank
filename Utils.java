package com.sachin;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Utils {
	public static final String ERROR="Some unexpected error occurred";
	public static final Color MY_BG_COLOR = new Color(250, 246, 245);
	public static final Color MY_BTN_BG_COLOR = new Color(255, 211, 77);
	public static final Color MY_RED_COLOR = new Color(170, 0, 0);

	public static void setTextField(JTextField jTextField) {
		jTextField.setFont(new Font("Serif", Font.PLAIN, 18));
		jTextField.setForeground(Utils.MY_RED_COLOR);
	}

	public static void setButton(JButton jButton) {
		jButton.setFocusPainted(false);
		jButton.setFont(new Font("Serif", Font.BOLD, 18));
		jButton.setBackground(Utils.MY_BTN_BG_COLOR);
		jButton.setForeground(Color.BLACK);
	}

	public static void setLabel(JLabel jLabel, Color bg, Color fr, int size) {
		jLabel.setOpaque(true);
		jLabel.setBackground(bg);
		jLabel.setForeground(fr);
		jLabel.setFont(new Font("Serif", Font.PLAIN, size));
	}




}
