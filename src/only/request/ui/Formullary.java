package only.request.ui;

import javax.swing.*;

public class Formullary {
    private JTextArea codeArea;
    private JTextArea resultArea;
    private JTextField URL;
    private JComboBox typecurl;
    private JButton resultCode;

    private JPanel panel;
    private JButton executeButton;

    public JPanel getPanel() {
        return panel;
    }

    public JTextArea getCodeArea() {
        return codeArea;
    }

    public JTextArea getResultArea() {
        return resultArea;
    }

    public JTextField getURL() {
        return URL;
    }

    public JComboBox getTypecurl() {
        return typecurl;
    }

    public JButton getResultCode() {
        return resultCode;
    }

    public JButton getExecuteButton() {
        return executeButton;
    }
}
