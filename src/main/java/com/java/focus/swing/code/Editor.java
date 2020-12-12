package com.java.focus.swing.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editor extends JFrame {
	private JFileChooser fileChooser = new JFileChooser();
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar toolBar = new JToolBar();
	private JTextArea editArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel statusLbl = new JLabel("status: ");
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu helpMenu = new JMenu("Help");
	private JButton copyBtn = new JButton("copy");
	private JButton cutBtn = new JButton("cut");
	private JButton pasteBtn = new JButton("paste");
	private JMenuItem newFileMenuItem = new JMenuItem("New");
	private JMenuItem openFileMenuItem = new JMenuItem("Open");
	private JMenuItem saveFileMenuItem = new JMenuItem("Save");
	private JMenuItem exitFileMenuItem = new JMenuItem("Exit");
	private JMenuItem copyEditMenuItem = new JMenuItem("Copy");
	private JMenuItem cutEditMenuItem = new JMenuItem("Cut");
	private JMenuItem pasteEditMenuItem = new JMenuItem("Paste");
	private JMenuItem aboutHelpMenuItem = new JMenuItem("About me");

	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem copyPopupMenuItem = 
			new JMenuItem("copy content");
	private JMenuItem cutPopupMenuItem = 
			new JMenuItem("cut content");
	private JMenuItem pastePopupMenuItem = 
			new JMenuItem("paste content");

	private JComboBox<Integer> fontSizeBox = 
			new JComboBox<Integer>(
			new Integer[] { 
				new Integer(20), new Integer(25), 
				new Integer(30), new Integer(40) });

	private Container contentPane;

	public Editor(String title) {
		super(title);
		setSize(800, 600);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		makeMenu();
		setJMenuBar(menuBar);
		initGUI();
	}

	public void makeMenu() {
		fileMenu.add(newFileMenuItem);
		fileMenu.add(openFileMenuItem);
		fileMenu.add(saveFileMenuItem);
		fileMenu.add(exitFileMenuItem);
		menuBar.add(fileMenu);

		editMenu.add(copyEditMenuItem);
		editMenu.add(cutEditMenuItem);
		editMenu.add(pasteEditMenuItem);
		menuBar.add(editMenu);

		helpMenu.add(aboutHelpMenuItem);
		menuBar.add(helpMenu);

		popupMenu.add(copyPopupMenuItem);
		popupMenu.add(cutPopupMenuItem);
		popupMenu.add(pastePopupMenuItem);
	}

	public void initGUI() {
		contentPane.setLayout(new BorderLayout());
		makeToolBar();
		contentPane.add(BorderLayout.NORTH, toolBar);

		editArea.setFont(new Font("宋体", Font.BOLD, 20));

		scrollPane.getViewport().add(editArea);
		contentPane.add(BorderLayout.CENTER, scrollPane);

		contentPane.add(BorderLayout.SOUTH, statusLbl);

		addListener();
	}

	public void makeToolBar() {
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(copyBtn);
		toolBar.add(cutBtn);
		toolBar.add(pasteBtn);
		toolBar.add(fontSizeBox);
	}

	public void addListener() {
		fontSizeBox.addItemListener(
				new ItemListener() {
			@Override
            public void itemStateChanged(ItemEvent e) {
				JComboBox<Integer> b = 
						(JComboBox<Integer>) e.getSource();
				Integer i = (Integer) b.getSelectedItem();
				Font f = 
						new Font("宋体", Font.BOLD, i.intValue());
				editArea.setFont(f);
			}
		});
		exitFileMenuItem.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		openFileMenuItem.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(Editor.this);
			}
		});

		class EditListener implements ActionListener {
			@Override
            public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if ((o == copyEditMenuItem) || (o == copyBtn) || (o == copyPopupMenuItem)) {
					editArea.copy();
				}
				if ((o == cutEditMenuItem) || (o == cutBtn) || (o == cutPopupMenuItem)) {
					editArea.cut();
				}
				if ((o == pasteEditMenuItem) || (o == pasteBtn) || (o == pastePopupMenuItem)) {
					editArea.paste();
				}
			}
		}
		ActionListener l = new EditListener();
		copyEditMenuItem.addActionListener(l);
		cutEditMenuItem.addActionListener(l);
		pasteEditMenuItem.addActionListener(l);
		copyBtn.addActionListener(l);
		cutBtn.addActionListener(l);
		pasteBtn.addActionListener(l);
		copyPopupMenuItem.addActionListener(l);
		cutPopupMenuItem.addActionListener(l);
		pastePopupMenuItem.addActionListener(l);

		editArea.addMouseListener(new MouseListener() {
			@Override
            public void mouseClicked(MouseEvent e) {
			}

			@Override
            public void mouseEntered(MouseEvent e) {
			}

			@Override
            public void mousePressed(MouseEvent e) {
				mouseReleased(e);
			}

			@Override
            public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(editArea, e.getX(), e.getY());
				}
			}

			@Override
            public void mouseExited(MouseEvent e) {
			}
		});
	}

	public void go() {
		setVisible(true);
	}

	public static void main(String... args) {
		(new Editor("My Editor")).go();
	}
}
