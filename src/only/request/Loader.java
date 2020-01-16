package only.request;

import only.request.ui.Formullary;
import only.request.utils.URLUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Loader {

    private Formullary formullary;
    private JFrame frame;

    public static void main(String[] args) {
        new Loader().init();
    }

    public void init(){
        formullary = new Formullary();
        JComboBox comboBox = formullary.getTypecurl();
        comboBox.addItem("GET");
        comboBox.addItem("CURL");

        frame = new JFrame("Redstone GET/POST");
        frame.setSize(new Dimension(1080, 768));
        frame.setContentPane(formullary.getPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.show();

        this.registerListeners();

        //System.exit(0);
    }

    public void runner(){
        JComboBox comboBox = formullary.getTypecurl();
        JTextField field = formullary.getURL();
        JTextArea resultArea = formullary.getResultArea();
        while (frame.isShowing()){
            if(comboBox.getSelectedItem() == "GET" && !field.getText().isEmpty()){
                try {
                    resultArea.setText(URLUtil.download(new URL(field.getText())));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerListeners(){
        JComboBox comboBox = formullary.getTypecurl();
        JTextField field = formullary.getURL();
        JTextArea resultArea = formullary.getResultArea();
        formullary.getExecuteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(comboBox.getSelectedItem() == "GET" && !field.getText().isEmpty()){
                    try {
                        resultArea.setText(URLUtil.download(new URL(field.getText())));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
