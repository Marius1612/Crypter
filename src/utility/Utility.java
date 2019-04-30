package utility;

import data.SecretData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;

public class Utility {
    public static char asciiCodeToChar(int number)
    {
        return (char)number;
    }

    public static int charToAsciiCode(char caracter)
    {
        return (int) caracter;
    }

    public static void createDirectory(String path)
    {
        File directory = new File(path);
        if(!directory.exists())
        {
            directory.mkdir();
        }
    }

    public static void createDataBaseFile(String username, String password)
    {
        createDirectory(SecretData.APP_FOLDER_DATA_PATH);
        File registerFile = new File(SecretData.APP_FOLDER_DATA_PATH+"\\"+username+".txt");
        String path =SecretData.APP_FOLDER_DATA_PATH+"\\"+username+".txt";
        try {
            registerFile.createNewFile();
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(password);
            writer.close();
            fileWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
