package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstForm extends Form{
        private JFrame frame;
        private JTextArea area; //ссылка на текстовое полк
        private JTextField nameTextField;
        private JTextField famyliTextField;
        private JLabel resultTextField;
        private JPanel statusPanel;
        private JLabel statusLabel;


        public JButton button;

        public FirstForm(Logic logic){
            super(logic);
            createFrame();
            initElements();
        }
        public void addToTextArea(String text){
            area.append(text);
        }

        public void setStatusLabel(String text) {
            this.statusLabel.setText(text);
        }

        public String getNameTextField() {
            return nameTextField.getText();
        }

        public String getFamyliTextField() {
            return famyliTextField.getText();
        }

        public void setResultTextField(String resultTextField) {
            this.resultTextField.setText(resultTextField);
        }

        private void createFrame(){     //создает окно графического интерфейса
            frame = new JFrame("Лабораторная 1");
            frame.setSize(900, 600);
            // выход из приложения по закрытию
            //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        public void show(){ //делает окно видимым
            frame.setVisible(true);
        }
        private void initElements() { //создает необходимые элементы внутри окна
            Container mainContainer = frame.getContentPane();

            mainContainer.setLayout(new BorderLayout());

            Box panel = Box.createHorizontalBox(); //контейнер, в котором элементы располагаются
            // горизонтально

            // поле для вывода лога выполнения задач
            area = new JTextArea( 50, 80);

            area.setLineWrap(true);    // параметры переноса слов
            area.setWrapStyleWord(true);

            Box leftPanel = createLeftPanel(); // создаем левую панель в другом методе
            mainContainer.add(leftPanel, BorderLayout.WEST); // эта панель будет слева

            //строка состояния
            statusPanel = new JPanel();
            statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
            frame.add(statusPanel, BorderLayout.SOUTH);
            statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
            statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
            //элементы строки состояния
            statusLabel = new JLabel();
            statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(statusLabel);

            panel.add(new JScrollPane(area));
            //panel.add (progressBar) ;
            mainContainer.add(panel);

        }
        private Box createLeftPanel() {
            Box panel = Box.createVerticalBox();  // вертикальный Box
            // Box это контейнер, в котором элементы выстраиваются в одном порядке

            JLabel title = new JLabel("<html>Проведение эксперимента</html>");
            // чтобы добавить перевод строки в тексте, нужно писать в тегах <html>
            title.setFont(new Font(null, Font.BOLD, 12)); // изменяем шрифт
            panel.add(title);

            panel.add(Box.createVerticalStrut(20)); //в Box можно добавлять отступы

            panel.add(new JLabel("Имя"));

            nameTextField = new JTextField("");  // поле ввода названия
            nameTextField.setMaximumSize(new Dimension(300, 30)); // чтобы не был слишком большим
            panel.add(nameTextField);

            panel.add(new JLabel("Фамилия"));
            famyliTextField = new JTextField("");
            famyliTextField.setMaximumSize(new Dimension(300, 30)); // чтобы не был слишком большим
            panel.add(famyliTextField);

            panel.add(new JLabel("результат:"));
            resultTextField = new JLabel("");
            panel.add(resultTextField);

            panel.add(Box.createVerticalGlue()); // также в Box можно добавлять заполнитель пустого места

            button = new JButton("Пуск"); // Кнопка
            panel.add(button);


            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logic.click(0);
                }
            });

            return panel;
        }
    }


