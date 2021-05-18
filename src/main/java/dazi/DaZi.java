package dazi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ZKY on 2017-06-16 11:09.
 * 此打字程序是从网上download的现在有些问题。
 */


public class DaZi extends JFrame implements ActionListener, KeyListener
{
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel(new FlowLayout());
    JPanel p3 = new JPanel();
    JTextArea textField1 = new JTextArea(4, 2);
    JTextArea textField2 = new JTextArea();
    float right = 0;
    JLabel showmessageJLabel = new JLabel("当前正确率:100%");
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel("难度:");
    JTextField l3 = new JTextField(5);
    Font font = new Font("楷体", 1, 48);
    Font font1 = new Font("黑体", 0, 14);
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    int count = 0;
    int i = 0, len1 = 0;
    double r = 0;
    char[] y;


    public DaZi()
    {
        super("font practice");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        l1.setFont(font);
        l1.setText("font");
        ;
        p1.setLayout(new GridLayout(3, 1));
        textField1.setEditable(false);
        textField2.addKeyListener(this);
        textField1.setFont(font1);
        textField2.setFont(font1);
        textField1.setLineWrap(true);
        textField2.setLineWrap(true);
        textField1.setWrapStyleWord(true);
        textField2.setWrapStyleWord(true);

        p1.add(textField1);
        p1.add(showmessageJLabel);
        p1.add(textField2);
        b1 = new JButton("开始");
        b2 = new JButton("退出");
        p2.add(b1);
        p2.add(b2);
        p2.add(l2);
        p2.add(l3);
        p3.add(l1);
        add(p1, BorderLayout.CENTER);
        add(p3, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        JOptionPane.showMessageDialog(null, "请选择要练习的内容:1.初级 2.中级 3.困难");
        this.setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1)
        {
            int key = 0;
            key = Integer.valueOf(l3.getText());
            switch (key)
            {
                case 1:
                    textField1.setText("abcdefghijklmnopqrstuvwxyz");
                    break;
                case 2:
                    textField1.setText("My father was a self-taught mandolin player. " + "He was one of the best string instrument players in our town. " + "He could not read " + "music, but if he heard a tune a few times, " + "he could play it. " + "When he was younger, he was a member of a small country " + "music b");
                    break;
                case 3:
                    textField1.setText("sdfmawieofnosandvoinqewoifnvoqwneiqwenfqnwefoinqwoien");
                    break;
                default:
                    break;
            }
            len1 = textField1.getText().length();
        }
        if (e.getSource() == b2)
        {
            System.exit(0);
        }

    }


    public static void main(String[] argsS)
    {
        DaZi t1 = new DaZi();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // TODO Auto-generated method stub
        if ((int) e.getKeyChar() > 31 && (int) e.getKeyChar() < 127)
        {
            if (i >= textField1.getText().length())
            {
                JOptionPane.showMessageDialog(null, "超出个数");
            }

            double c = 0;
            if (e.getKeyChar() == textField1.getText().charAt(i))
            {
                r++;
                i++;
            }
            else
            {
                i++;
            }
            double f = i;
            c = (r / f) * 100;
            showmessageJLabel.setText("当前正确率:" + c + "%");

        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }


}
