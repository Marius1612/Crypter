package code;

import utility.Utility;

public class EncryptingAndDecrypting {

    public String cryptingMethod(String textField) {
        StringBuilder encryptetMessage = new StringBuilder();
        for (int i = 0; i < textField.length(); i++) {
            int atbash = Utility.charToAsciiCode(textField.charAt(i));
            if (atbash >= 65 && atbash <= 90) {
                atbash = 65 + 90 - atbash;
            } else if (atbash >= 97 && atbash <= 122) {
                atbash = 97 + 122 - atbash;
            }
            char atbashInt = Utility.asciiCodeToChar(atbash);
            encryptetMessage.append(atbashInt);
        }
        return encryptetMessage.toString();
    }
}
