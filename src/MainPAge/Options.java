package MainPAge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Options extends JFrame {

    private JPanel Options;
    private JRadioButton kseriesoptions;
    private JRadioButton sseriesoptions;
    private JRadioButton tseriesoptions;
    private JRadioButton hseriesoptions;
    private JRadioButton mseriesoptions;
    private JRadioButton yseriesoptions;
    private JRadioButton rseriesoptions;
    private JRadioButton wnseriesoptions;
    private JRadioButton gseriesoptions;
    private JRadioButton bseriesoptions;
    private JRadioButton pseriesoptions;
    private JLabel KatakanaOptions;

    Options(String Title){
        this.setContentPane(Options);
        this.pack();

        HashMap<String,String> firstseries = new HashMap<String,String>();
        firstseries.put("ア","a");
        firstseries.put("イ","i");
        firstseries.put("ウ","u");
        firstseries.put("エ","e");
        firstseries.put("オ","o");
        MainPage.HashRef.putAll(firstseries);

        HashMap<String,String> kseries = new HashMap<String,String>();
        kseries.put("カ","ka");
        kseries.put("キ","ki");
        kseries.put("ク","ku");
        kseries.put("ケ","ke");
        kseries.put("コ","ko");
        MainPage.HashRef.putAll(kseries);

        HashMap<String,String> sseries = new HashMap<String,String>();
        sseries.put("サ","sa");
        sseries.put("シ","si");
        sseries.put("ス","su");
        sseries.put("セ","se");
        sseries.put("ソ","so");
        MainPage.HashRef.putAll(sseries);

        HashMap<String,String> tseries = new HashMap<String,String>();
        tseries.put("タ","ta");
        tseries.put("チ","ti");
        tseries.put("ツ","tu");
        tseries.put("テ","te");
        tseries.put("ト","to");
        MainPage.HashRef.putAll(tseries);

        HashMap<String,String> nseries = new HashMap<String,String>();
        nseries.put("ナ","na");
        nseries.put("ニ","ni");
        nseries.put("ヌ","nu");
        nseries.put("ネ","ne");
        nseries.put("ノ","no");
        MainPage.HashRef.putAll(nseries);

        HashMap<String,String> hseries = new HashMap<String,String>();
        hseries.put("ハ","ha");
        hseries.put("ヒ","hi");
        hseries.put("フ","hu");
        hseries.put("へ","he");
        hseries.put("ホ","ho");
        MainPage.HashRef.putAll(hseries);

        HashMap<String,String> mseries = new HashMap<String,String>();
        mseries.put("マ","ma");
        mseries.put("ミ","mi");
        mseries.put("ム","mu");
        mseries.put("メ","me");
        mseries.put("モ","mo");
        MainPage.HashRef.putAll(mseries);

        HashMap<String,String> yseries = new HashMap<String,String>();
        yseries.put("ヤ","ya");
        yseries.put("ユ","yu");
        yseries.put("ヨ","yo");
        MainPage.HashRef.putAll(yseries);

        HashMap<String,String> rseries = new HashMap<String,String>();
        rseries.put("ラ","ra");
        rseries.put("リ","ri");
        rseries.put("ル","ru");
        rseries.put("レ","re");
        rseries.put("ロ","ro");
        MainPage.HashRef.putAll(rseries);

        HashMap<String,String> wnseries = new HashMap<String,String>();
        wnseries.put("ワ","wa");
        wnseries.put("ヲ","wo");
        wnseries.put("ン","n");
        MainPage.HashRef.putAll(wnseries);

        HashMap<String,String> gseries = new HashMap<String,String>();
        gseries.put("ガ","ga");
        gseries.put("ギ","gi");
        gseries.put("グ","gu");
        gseries.put("ゲ","ge");
        gseries.put("ゴ","go");
        MainPage.HashRef.putAll(gseries);

        HashMap<String,String> bseries = new HashMap<String,String>();
        bseries.put("バ","ba");
        bseries.put("ビ","bi");
        bseries.put("ブ","bu");
        bseries.put("べ","be");
        bseries.put("ボ","bo");
        MainPage.HashRef.putAll(bseries);

        HashMap<String,String> pseries = new HashMap<String,String>();
        pseries.put("パ","pa");
        pseries.put("ピ","pi");
        pseries.put("プ","pu");
        pseries.put("ぺ","pe");
        pseries.put("ポ","po");
        MainPage.HashRef.putAll(pseries);

        kseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(kseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(kseries.keySet());
                }
            }
        });
        sseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(sseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(sseries.keySet());
                }
            }
        });
        tseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(tseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(tseries.keySet());
                }
            }
        });
        hseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(hseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(hseries.keySet());
                }
            }
        });
        mseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(mseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(mseries.keySet());
                }
            }
        });
        yseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(yseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(yseries.keySet());
                }
            }
        });
        rseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(rseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(rseries.keySet());
                }
            }
        });
        wnseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wnseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(wnseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(wnseries.keySet());
                }
            }
        });
        gseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(gseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(gseries.keySet());
                }
            }
        });
        bseriesoptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(bseries.keySet());
                }
                else{
                    MainPage.FinalKataList.removeAll(bseries.keySet());
                }
            }
        });
        //when calling this listener, never
        pseriesoptions.addActionListener(new ActionListener() {
            @Override
            //this method gonna
            public void actionPerformed(ActionEvent e) {
                //selects when to give
                if (pseriesoptions.isSelected()){
                    MainPage.FinalKataList.addAll(pseries.keySet());
                }
                //else you
                else{
                    MainPage.FinalKataList.removeAll(pseries.keySet());
                }
            }
        });
    }
}