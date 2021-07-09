package com.company;

import java.nio.file.Path;

public class FileAccess {
    static Path messageDecryptedLocation;
    static Path messageEncryptedLocation;

    // static - Sets and gets the paths for the files. No need to change this unless requested. Can simply add more
    // a full setter for that.

    public static Path getMessageDecryptedLocation() {
        Path filepathD;
        try {
            filepathD = Path.of("C:\\Users\\hoffl\\IdeaProjects\\Caesar\\src\\com\\company\\decryptedMessage");
            ;
            messageDecryptedLocation = filepathD;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return messageDecryptedLocation;
    }

    public static Path getMessageEncryptedLocation() {
            Path filepathE;
            try{
                filepathE = Path.of("C:\\Users\\hoffl\\IdeaProjects\\Caesar\\src\\com\\company\\encryptedMessage");;
                messageEncryptedLocation = filepathE;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
        }
        return messageEncryptedLocation;
    }
}
