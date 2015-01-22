package hw8.taxi.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Дмитрий on 19.03.14.
 */
    public class Autorization extends JFrame {   /* Для того, чтобы впоследствии обращаться к содержимому текстовых полей, рекомендуется сделать их членами класса окна */
            JTextField loginField;
            JPasswordField passwordField;
            Autorization(){
                super("Вход в систему");
            setDefaultCloseOperation(EXIT_ON_CLOSE); // Настраиваем первую горизонтальную панель (для ввода логина)

            Box box1 = Box.createHorizontalBox();
            JLabel loginLabel = new JLabel("Логин:");
            loginField = new JTextField(15);
            box1.add(loginLabel);
            box1.add(Box.createHorizontalStrut(6));
            box1.add(loginField); // Настраиваем вторую горизонтальную панель (для ввода пароля)

            Box box2 = Box.createHorizontalBox();
            JLabel passwordLabel = new JLabel("Пароль:");
            passwordField = new JPasswordField(15);
            box2.add(passwordLabel);
            box2.add(Box.createHorizontalStrut(6));
            box2.add(passwordField); // Настраиваем третью горизонтальную панель (с кнопками)

            Box box3 = Box.createHorizontalBox();
            JButton ok = new JButton("OK");
            JButton cancel = new JButton("Отмена");
            box3.add(Box.createHorizontalGlue());
            box3.add(ok);
            box3.add(Box.createHorizontalStrut(12));
            box3.add(cancel); // Уточняем размеры компонентов

            loginLabel.setPreferredSize(passwordLabel.getPreferredSize()); // Размещаем три горизонтальные панели на одной вертикальной
            Box mainBox = Box.createVerticalBox();
            mainBox.setBorder(new EmptyBorder(12,12,12,12));
            mainBox.add(box1);
            mainBox.add(Box.createVerticalStrut(12));
            mainBox.add(box2);
            mainBox.add(Box.createVerticalStrut(17));
            mainBox.add(box3);
            setContentPane(mainBox);
            pack();
            setResizable(false);
            }

    }
