package com.sachin;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class TransactionHistory extends JFrame implements ActionListener {

	JTable table;
	JScrollPane ScrollPane;
	final JButton b = new JButton("Go Back");
	final JLabel l1 = new JLabel("Your Transaction History");
	final JLabel noTransactionLabel = new JLabel("No Transaction Found", SwingConstants.CENTER);
	final String customerId;
	final String phone_num;

	TransactionHistory(String customerId, String phone_num) {
		this.customerId = customerId;
		this.phone_num = phone_num;
		setTitle("Transaction History");
		setSize(650, 700);
		getContentPane().setBackground(Utils.MY_BG_COLOR);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel iBank = new JLabel("iBank internet banking", SwingConstants.CENTER);
		Utils.setLabel(iBank, Utils.MY_RED_COLOR, Color.WHITE, 24);
		iBank.setBounds(0, 0, getWidth(), 50);
		add(iBank);

		Utils.setButton(b);
		b.setBounds(500, 70, 120, 50);
		add(b);

		Utils.setLabel(l1, Utils.MY_BG_COLOR, Color.BLACK, 22);
		l1.setBounds(48, 70, 250, 30);

		Utils.setLabel(noTransactionLabel, Utils.MY_BG_COLOR, Utils.MY_RED_COLOR, 25);
		noTransactionLabel.setBounds(210, 325, 230, 50);

		DatabaseConnection db_conn = new DatabaseConnection();
		String[][] data = db_conn.getTransactionHistory("SELECT * FROM transactions WHERE customer_id = '" + customerId + "';");
//		data = null;

		if (data != null) {

			add(l1);
			table = new JTable(data, new String[]{"Id", "Date", "Amount", "Type"});
			table.setFont(new Font("Serif", Font.PLAIN, 18));

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			for (int i = 0; i < 4; i++) {
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

			}
			for (int i = 0; i < data.length; i++) {
				table.setRowHeight(i, 50);
			}

			table.getColumnModel().getColumn(1).setPreferredWidth(150);

			JTableHeader THeader = table.getTableHeader();
			THeader.setBackground(Utils.MY_RED_COLOR);
			THeader.setForeground(Color.WHITE);
			THeader.setFont(new Font("Serif", Font.PLAIN, 22));

			ScrollPane = new JScrollPane(table);
			ScrollPane.setBounds(48, 130, 573, 525);
			add(ScrollPane);

		} else {
			add(noTransactionLabel);
		}

		setVisible(true);

		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		new Dashboard(customerId, phone_num);
	}
}