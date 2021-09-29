package com.company;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralForm extends Form{
    private JFrame frame;
    private JTextArea area; //ссылка на текстовое полк
    private JPanel statusPanel;
    private JLabel statusLabel;
    private JMenuBar menuBar;
    private  JPanel actionPanal;
    private LogicGeneral logicG;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;

    public GeneralForm(LogicGeneral logic){
        super(logic);
        this.logicG = logic;
        createFrame();
        initElements();
    }
    public void addToTextArea(String text){
        area.append(text);
    }

    public void setStatusLabel(String text) {
        this.statusLabel.setText(text);
    }

    private void createFrame(){     //создает окно графического интерфейса
        frame = new JFrame("Лаборатоные работы");
        frame.setSize(900, 600);
        // выход из приложения по закрытию
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void show(){ //делает окно видимым
        frame.setVisible(true);
    }
    private void initElements() { //создает необходимые элементы внутри окна
        Container mainContainer = frame.getContentPane();

        mainContainer.setLayout(new BorderLayout());

        Box panel = Box.createVerticalBox();

        actionPanal = createActionPanal();

        // поле для вывода лога выполнения задач
        area = new JTextArea( 50, 80);

        area.setLineWrap(true);    // параметры переноса слов
        area.setWrapStyleWord(true);

       // Box leftPanel = createLeftPanel(); // создаем левую панель в другом методе
        //mainContainer.add(leftPanel, BorderLayout.WEST); // эта панель будет слева
        menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createLab1Menu());
        menuBar.add(new JMenu("защита от ВП"));
        menuBar.add(new JMenu("about"));
        frame.setJMenuBar(menuBar);


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


        panel.add(actionPanal);
        panel.add(new JScrollPane(area));
        //panel.add (progressBar) ;
        mainContainer.add(panel);

    }
    private JPanel createActionPanal(){
        checkBox1 = new JCheckBox("Запись данных в БД");
        checkBox2 = new JCheckBox("Показать БД");
        Box panal = Box.createHorizontalBox();
        panal.add(checkBox1);
        panal.add(checkBox2);
        JPanel k = new JPanel();
        k.add(panal);
        return k;

    }
    private JMenu createLab1Menu(){
        JMenu ZPS = new JMenu("Защита РС");
      /*  JMenuItem Lab1 = new JMenuItem("Lab 1");
        JMenuItem Lab2 = new JMenuItem("Lab 2");

        ZPS.add(Lab1);
        ZPS.add(Lab2);*/
        JMenuItem[] labs = new JMenuItem[Labs.values().length];
        int j = 0;
        for (Labs i: Labs.values()){
            labs[j] = new JMenuItem(i.getName());
            ZPS.add(labs[j]);
            labs[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logicG.pressLabMenu(i);
                }
            });
            j++;

        }

        return ZPS;
    }
    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Open");
        JMenuItem Save = new JMenuItem("Save");
        JMenuItem Create = new JMenuItem("Create");
        JMenuItem encryption = new JMenuItem("encryption");
        JMenuItem decryption = new JMenuItem("decryption");
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem("exit");
        // Добавим в меню пункта open
        file.add(open);
        file.add(Save);
        file.add(Create);

        file.addSeparator();

        file.add(encryption);
        file.add(decryption);
        // Добавление разделителя
        file.addSeparator();

        file.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return file;
    }
}


