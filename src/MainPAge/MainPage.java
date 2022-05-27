package MainPAge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.FileNameMap;
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
    private int count = 0;
    private char temp;
    public static ArrayList<String> FinalKataList = new ArrayList<>();
    public static HashMap<String, String> HashRef = new HashMap<>();
    public static ArrayList<Character> currentKatakana = new ArrayList<>();
    private int index;
    private String Katakana;

    public void randomize() {
        Random r = new Random();

        index = r.nextInt(FinalKataList.size());
        Katakana = FinalKataList.get(index);
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
                                    count++;
                                    setquestion(e);
                                    System.out.print(count);
//                                    for (int i = 0; i < input.length(); i++) {
//                                        r.keyPress(KeyEvent.VK_BACK_SPACE);
//                                        r.keyRelease(KeyEvent.VK_BACK_SPACE);
//                                    }
                                }
                            } else {
                                setquestion(e);
                                System.out.print(count);
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

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                boolean ISCorrect = false;
//                for (int i = 0; i <= (HashRef.get(Katakana)).length(); i++) {
//                    ISCorrect = false;
//                    if (temp != HashRef.get(Katakana).charAt(i)) {
//                        break;
//                    }
//                    ISCorrect = true ;
//                }
//                if(ISCorrect){
//                    count++;
//                }
//                index = r.nextInt(FinalKataList.size());
//                Katakana = FinalKataList.get(index);
//                Kata.setText(Katakana);

            }
        });

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
                Kata.setText("Press Start to Begin");
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
