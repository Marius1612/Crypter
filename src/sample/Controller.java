package sample;

import code.EncryptingAndDecrypting;
import data.SecretData;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utility.Utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TabPane tabPane;
    public Tab loginTab;
    public Tab encryptTab;
    public TextField usernameTxt;
    public PasswordField passwordTxt;
    public TextField txtEncryptedOutput;
    public TextField txtToEncrypt;
    public TextField txtCode;
    public Tab registerTAb;
    public TextField usernameRegisterTxt;
    public PasswordField passwordRegisterTxt;
    public Button registerbtn;
    public Label usernameLbl;
    public Tab dataBaseTab;
    public TextField dataBaseTxt;


    public void initialize() {
        tabPane.getTabs().remove(encryptTab);
        tabPane.getTabs().remove(dataBaseTab);
    }

    public void checkingData(KeyEvent keyEvent) throws IOException {
        try {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                String username = usernameTxt.getText() + ".txt";
                File usernameData = new File(SecretData.APP_FOLDER_DATA_PATH + "\\" + username);
                FileReader passwordData = new FileReader(usernameData);
                BufferedReader bufferedReader = new BufferedReader(passwordData);
                String line = bufferedReader.readLine();
                if (usernameData.exists() && passwordTxt.getText().equals(line.toString())) {
                    tabPane.getTabs().add(encryptTab);
                    tabPane.getSelectionModel().select(encryptTab);
                    usernameLbl.setText("ACCOUNT: " + usernameTxt.getText().toUpperCase().replaceAll("I", "1")
                            .replaceAll("E", "3").replaceAll("O", "0").replaceAll("A", "4"));
                    tabPane.getTabs().remove(loginTab);
                }
            }
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public void encryptText(KeyEvent keyEvent) {
        EncryptingAndDecrypting encryptingAndDecrypting = new EncryptingAndDecrypting();
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            txtEncryptedOutput.setText(encryptingAndDecrypting.cryptingMethod(txtToEncrypt.getText()));
        }
    }

    public void testCode(KeyEvent keyEvent) {
        SecretData test = new SecretData();
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if (txtCode.getText().equals(test.getRegister())) {
                tabPane.getTabs().add(registerTAb);
                tabPane.getSelectionModel().select(registerTAb);
            }
            if (txtCode.getText().equals(test.getDtb())) {
                List<String> dataList =new ArrayList() {};
                tabPane.getTabs().add(dataBaseTab);
                tabPane.getSelectionModel().select(dataBaseTab);
                File file = new File(SecretData.APP_FOLDER_DATA_PATH);
                File[] allfiles = file.listFiles();
                for(File fi:allfiles)
                {
                    String location = "c:\\\\Users\\\\Public\\\\Documents\\\\code\\\\";
                    String  data = fi.toString().replaceAll(location,"").
                            replaceAll(".txt","\n");
                    dataList.add(data);
                }
                dataBaseTxt.setText(dataList.toString());
            }
        }
    }

    public void register(ActionEvent event) {
        if (!usernameRegisterTxt.getText().isEmpty() && !passwordRegisterTxt.getText().isEmpty()) {
            Utility.createDataBaseFile(usernameRegisterTxt.getText(), passwordRegisterTxt.getText());
        }
    }
}