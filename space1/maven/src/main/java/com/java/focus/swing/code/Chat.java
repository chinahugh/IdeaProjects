package com.java.focus.swing.code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Chat extends JFrame implements ActionListener {
	private JTextField userTxt = new JTextField(10);
	private JComboBox<String> ipBox = new JComboBox<String>(new String[] { "224.0.0.1", "224.0.0.2" });
	private JComboBox<String> portBox = new JComboBox<String>(new String[] { "10000", "10500", "20000" });
	private JButton connBtn = new JButton("Enter");
	private JTextArea chatArea = new JTextArea();
	private JList<String> userList = new JList<String>();

	private JTextField chatTxt = new JTextField(60);
	private JButton sendBtn = new JButton("Send");
	private Container contentPane;
	private MulticastSocket socket;
	private InetAddress group;
	private int port;
	private boolean isEntering = false;
	private Vector<String> users = new Vector<String>();

	public Chat(String title) {
		super(title);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		initGUI();
	}

	public void initGUI() {
		contentPane.setLayout(new BorderLayout());

		chatArea.setFont(new Font("宋体", Font.BOLD, 16));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(chatArea);
		add(scrollPane, BorderLayout.CENTER);

		userList.setFont(new Font("黑体", Font.BOLD, 16));
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(userList);
		add(scrollPane, BorderLayout.EAST);

		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("Name:"));
		northPanel.add(userTxt);
		northPanel.add(new JLabel("Ip:"));
		northPanel.add(ipBox);
		northPanel.add(new JLabel("Port:"));
		northPanel.add(portBox);
		northPanel.add(connBtn);
		add(northPanel, BorderLayout.NORTH);

		JPanel southPanel = new JPanel();
		southPanel.add(chatTxt);
		southPanel.add(sendBtn);
		add(southPanel, BorderLayout.SOUTH);

		connBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		chatTxt.addActionListener(this);
	}

	private void entryRoom() {
		try {
			group = InetAddress.getByName((String) ipBox.getSelectedItem());
			port = Integer.parseInt((String) portBox.getSelectedItem());
			socket = new MulticastSocket(port);
			socket.joinGroup(group);
			(new ReceiverThread()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void quitRoom() {
		try {
			socket.leaveGroup(group);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}

	private void update(String name, String ip, int port, String msg) {
		String str = name + "(" + ip + ":" + port + "): " + msg + "\n";
		chatArea.append(str);
		users.add(name);
		userList.setListData(users);
	}

	class ReceiverThread extends Thread {
		@Override
        public void run() {
			try {
				byte[] buffer = new byte[1024];
				while (true) {
					DatagramPacket dp = new DatagramPacket(buffer, 1024);
					socket.receive(dp);
					String str = new String(dp.getData(), 0, dp.getLength());
					try {
						StringTokenizer st = new StringTokenizer(str, "%");
						String name = st.nextToken();
						String msg = st.nextToken();
						String ip = dp.getAddress().getHostAddress();
						int port = dp.getPort();
						update(name, ip, port, msg);
					} catch (Exception e) {
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == sendBtn) || (e.getSource() == chatTxt)) {
			String str = chatTxt.getText().trim();
			String name = userTxt.getText().trim();
			str = name + "%" + str;
			try {
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, group, port);
				socket.send(dp);
				chatTxt.setText("");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		if (e.getSource() == connBtn) {
			if (isEntering) {
				quitRoom();
				connBtn.setText("Enter");
				ipBox.setEditable(true);
				portBox.setEditable(true);
				isEntering = !isEntering;
			} else {
				entryRoom();
				connBtn.setText("Quit");
				ipBox.setEditable(false);
				portBox.setEditable(false);
				isEntering = !isEntering;
			}
		}
	}

	public static void main(String... args) {
		(new Thread() {
			@Override
            public void run() {
				(new Chat("Chat Room")).setVisible(true);
			}
		}).start();
	}
}
