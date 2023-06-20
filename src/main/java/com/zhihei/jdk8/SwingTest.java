package com.zhihei.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ZKY
 * @createTime 2019/7/3 0:49
 * @description
 */

public class SwingTest {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame("My JFrame");

		JButton jButton = new JButton("My JButton");

		// jButton.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("Btton Pressed");
		// }
		// });

		// //使用lambda表达式
		// jButton.addActionListener((ActionEvent event)-> {
		// System.out.println("Btton Pressed lambda");
		// System.out.println("hello world");
		// });

		// 使用lambda表达式 简化
		jButton.addActionListener(event -> {
			System.out.println("Btton Pressed lambda");
			System.out.println("hello world");
		});

		jFrame.add(jButton);
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
