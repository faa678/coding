import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class SwingLoginExample {
    static int name = 0;
    static int rela = 0;
    static String result = "";
    static JComboBox<String> human;
    static JComboBox<String> relation;
    static JButton loginButton;
    static JTextArea resBox;
    public static void main(String[] args) {

        // 创建 JFrame 实例
        JFrame frame = new JFrame("亲属关系");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
        static String result = ""
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        human = new JComboBox<>();
        human.addItem("爸爸");
        human.addItem("妈妈");
        human.addItem("哥哥");
        human.addItem("姐姐");
        human.addItem("弟弟");
        human.setBounds(50, 20, 80, 25);
        panel.add(human);
        human.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                name = human.getSelectedIndex();
            }
        });

        relation = new JComboBox<>();
        relation.addItem("的爸爸");
        relation.addItem("的妈妈");
        relation.addItem("的儿子");
        relation.addItem("的女儿");
        relation.addItem("的兄弟");
        relation.addItem("的姐姐");
        relation.setBounds(190, 20, 80, 25);
        panel.add(relation);
        relation.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rela = relation.getSelectedIndex();
            }
        });

        // 创建按钮
        loginButton = new JButton("计算亲属关系");
        loginButton.setBounds(120, 60, 120, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = getResult(name, rela);
                resBox.setText(result);
            }

        });

        /*
         * 创建文本域
         */
        resBox = new JTextArea();
        resBox.setBounds(130,100,100,40);
        panel.add(resBox);
    }

    public static String getResult(int a, int b) {
        switch(a) {
            case 0:
            case 1:
                if (b == 2) {
                    return "哥哥,弟弟";
                } else if (b == 3) {
                    return "姐姐";
                }
                break;
            case 2:
                if (b == 0){return "爸爸";}
                else if (b == 1) {return "妈妈";}
                else if (b == 4) {return "弟弟";}
                else if (b == 5) {return "姐姐";}
                break;
            case 3:
                if (b == 0){return "爸爸";}
                else if (b == 1) {return "妈妈";}
                else if (b == 4) {return "哥哥,弟弟";}
                break;
            case 4:
                if (b == 0){return "爸爸";}
                else if (b == 1) {return "妈妈";}
                else if (b == 4) {return "哥哥";}
                else if (b == 5) {return "姐姐";}
                break;

        }
        return "";
    }

}