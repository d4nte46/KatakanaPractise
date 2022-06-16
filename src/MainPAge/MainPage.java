package MainPAge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.FileNameMap;
import java.text.NumberFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;


public class MainPage extends JFrame {
    private JPanel mainPanel;
    private JLabel Kata;
    private JTextField textField1;
    private JButton OPTIONS;
    private JLabel ErrorDeclare;
    private JButton StartButton;
    private JLabel Timer;
    private JButton StopButton;
    private JLabel CorrectCount;
    private Integer count = 0;
    private int total = 0;
    private char temp;
    public static ArrayList<String> FinalKataList = new ArrayList<>();
    public static HashMap<String, String> HashRef = new HashMap<>();
    public static ArrayList<Character> currentKatakana = new ArrayList<>();
    private int index;
    private String Katakana;
    private long StartTime;
    private long EndTime;

    public void randomize() {
        Random r = new Random();
        String newKatakana;
        do {
            int index = r.nextInt(FinalKataList.size());
            newKatakana = FinalKataList.get(index);
        } while (newKatakana.equals(Katakana)); //repeat until they are not equal
        Katakana = newKatakana;
    }

    public void setquestion(KeyEvent e){
        randomize();
        Kata.setText(Katakana);
        e.consume();
        textField1.setText("");
    }

    public Boolean CompareString(String CompareFrom, String CompareWith) {
        try {
            if (CompareFrom.substring(0, (CompareWith.length())).equalsIgnoreCase(CompareWith)) {
                return true;
            } else {
                return false;
            }
        } catch (StringIndexOutOfBoundsException s) {
            return false;
        }
    }
    public String HourFormatter(int Time){
        String outputTime = Integer.toString((Integer) Time);
        if (outputTime.length()>4){
            StopButton.doClick();
            ErrorDeclare.setText("Time Limit Crossed");
            return null;
        }
        while(outputTime.length()<4){
            outputTime = "0"+outputTime;
        }
        return outputTime;
    }

    public String TimeFormatter(int Time){
        String outputTime = Integer.toString((Integer) Time);
        while(outputTime.length()<2){
            outputTime = "0"+outputTime;
        }
        return outputTime;
    }

    public MainPage(String name) {
        super(name);

        FinalKataList.add("ア");
        FinalKataList.add("イ");
        FinalKataList.add("ウ");
        FinalKataList.add("エ");
        FinalKataList.add("オ");

        randomize();

        JFrame OptionsOfMyFrame = new Options("OPTIONS");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                        String input = textField1.getText() + e.getKeyChar();
                        try {
                            Robot r = new Robot();
//                            System.out.println(HashRef.get(Katakana).substring(0, input.length()));
////                            System.out.println(input);
////
////                            System.out.println(CompareString(HashRef.get(Katakana), input));
////                            System.out.println(HashRef.get(Katakana).length());
////                            System.out.println(input.length());
////                            System.out.print(count);

                            if (CompareString(HashRef.get(Katakana), input)) {
                                if (HashRef.get(Katakana).length() == input.length()) {
                                    EndTime = System.currentTimeMillis();
                                    count++;
                                    total++;
                                    setquestion(e);
//                                    System.out.print(count);
//                                    for (int i = 0; i < input.length(); i++) {
//                                        r.keyPress(KeyEvent.VK_BACK_SPACE);
//                                        r.keyRelease(KeyEvent.VK_BACK_SPACE);
//                                    }
                                }
                            } else {
                                EndTime = System.currentTimeMillis();
                                setquestion(e);
                                total++;
//                                System.out.print(count);
//                                for (int i = 0; i <= input.length(); i++) {
//                                    e.consume();
//
//                                    r.keyPress(KeyEvent.VK_BACK_SPACE);
//                                    r.keyRelease(KeyEvent.VK_BACK_SPACE);
//                                }
                            }
                        } catch (AWTException exception) {
                        } catch (StringIndexOutOfBoundsException a) {
                        }
                        ;

//                randomize();
//
//                Kata.setText(Katakana);

//                String roman = textField1.getText() + e.getKeyChar();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


//                String text = textField1.getText() + e.getKeyChar();
//                String roman = HashRef.get(Katakana);
//
//                if (!roman.matches("^"+text))
//                    return;
//
//                if (roman.length() != text.length())
//                    return;
//
//                System.out.println("complete match");

//                for(int i = 0 ; i <= (HashRef.get(Katakana)).length() ; i++){
//                    if (e.getKeyChar() != HashRef.get(Katakana).charAt(i)) {
//                        break;
//                    }
//
//                }
//                count++;
//                try{
//                    int index = r.nextInt(FinalKataList.size());
//                    String Katakana = FinalKataList.get(index);
//                    Kata.setText(String.valueOf(e.getKeyChar()));
//                }
//                catch(IllegalArgumentException illegalArgumentException){
//                    ErrorDeclare.setText("You have not set any options.");
//                }
//            }
//        });

        OPTIONS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OptionsOfMyFrame.isVisible()) {
                    OptionsOfMyFrame.setVisible(false);
                }
                ;
                OptionsOfMyFrame.setVisible(true);
            }
        });
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StartTime = System.currentTimeMillis();
                    textField1.setEditable(true);
                    Kata.setText(Katakana);
                    textField1.requestFocus();
                    textField1.setCaretPosition(0);
                } catch (IllegalArgumentException illegalArgumentException) {
                    ErrorDeclare.setText("You have not set any options.");
                }
            }
        });

        StopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long TotalTime = EndTime-StartTime;
                int TimeInHours = (int) (TotalTime/(60*60*1000));
                int TimeInMinutes = (int) ((TotalTime/(60*1000))-(TimeInHours*60));
                int TimeInSecond = (int) ((TotalTime/1000)-(TimeInHours*60*60)-(TimeInMinutes*60));
                int TimeInMilliseccond = (int) ((TotalTime%1000)/10);
                CorrectCount.setText("Points: " + Integer.toString(count)+"/"+total);
                System.out.println(TimeInHours);
                System.out.println(TimeInMinutes);
                System.out.println(TimeInSecond);
                System.out.println(TimeInMilliseccond);
                Timer.setText("Time Taken: " + HourFormatter(TimeInHours)+":"+TimeFormatter(TimeInMinutes)+":"+TimeFormatter(TimeInSecond)+":"+TimeInMilliseccond);
                Kata.setText("Press Start to Begin");
                total = 0;
                count = 0;
                textField1.setText("");
                textField1.setEditable(false);
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
        });
    }

    public static void main(String[] args) {

        JFrame MyFrame = new MainPage("KatakanaPractise (JSL)");
        MyFrame.setVisible(true);

    }
}
