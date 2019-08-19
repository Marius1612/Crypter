package sample;

import code.EncryptingAndDecrypting;
import databaseWorking.AddDataInDataBase;
import databaseWorking.Login;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Controller {
    public TabPane tabPane;
    public Tab loginTab;
    public Tab encryptTab;
    public TextField usernameTxt;
    public PasswordField passwordTxt;
    public TextField txtEncryptedOutput;
    public TextField txtToEncrypt;
    public Tab registerTAb;
    public TextField usernameRegisterTxt;
    public PasswordField passwordRegisterTxt;
    public Button registerbtn;
    public Label usernameLbl;
    public Label passwordLbl;
    public Label usernameLoginLbl;


    public void initialize() {
        tabPane.getTabs().remove(encryptTab);
    }


    public void encryptText(KeyEvent keyEvent) {
        EncryptingAndDecrypting encryptingAndDecrypting = new EncryptingAndDecrypting();
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            txtEncryptedOutput.setText(encryptingAndDecrypting.cryptingMethod(txtToEncrypt.getText()));
        }
    }


    private AddDataInDataBase addDataInDataBase = new AddDataInDataBase();

        public void register(ActionEvent event){
            if (!usernameRegisterTxt.getText().isEmpty() && !passwordRegisterTxt.getText().isEmpty()) {
                addDataInDataBase.addData(usernameRegisterTxt.getText() , passwordRegisterTxt.getText());
        }

    }

    private Login login = new Login();
    public void checkingData(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            if(login.LogIn(usernameTxt.getText(), passwordTxt.getText())) {
                tabPane.getTabs().add(encryptTab);
                tabPane.getSelectionModel().select(encryptTab);
                usernameLbl.setText("ACCOUNT: " + usernameTxt.getText().toUpperCase().replaceAll("I", "1")
                        .replaceAll("E", "3").replaceAll("O", "0").replaceAll("A", "4"));
                tabPane.getTabs().remove(loginTab);
            }
            else {
                usernameLoginLbl.setTextFill(Color.RED);
                passwordLbl.setTextFill(Color.RED);
            }
        }
    }
}