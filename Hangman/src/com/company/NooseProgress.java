package com.company;

public class NooseProgress {
    public NooseProgress(int a, String b) {
    }

    public String nooseDisplay(int missedHang, String missedLettersActual){

        String manOnBlock = (
                "\n|====," +
                "\n|   | " +
                "\n|    " +
                "\n|    " +
                "\n|    " +
                "\n|    " +
                "\n|====|"
        );
        switch (missedHang){
            case 0:
                 manOnBlock= (
                     missedLettersActual +
                     "\n|====," +
                    "\n|   | " +
                    "\n|    " +
                    "\n|    " +
                    "\n|    " +
                    "\n|    " +
                    "\n|====|"
            );
                break;
            case 1:
                manOnBlock= (
                     missedLettersActual +
                    "\n|====," +
                    "\n|   (O0)" +
                    "\n|    " +
                    "\n|    " +
                    "\n|    " +
                    "\n|    " +
                    "\n|====|"
            );
                break;
            case 2:
                manOnBlock= (
                    missedLettersActual +
                    "\n|====," +
                    "\n|   (O0)" +
                    "\n|    |" +
                    "\n|    " +
                    "\n|    " +
                    "\n|    " +
                    "\n|====|"
            );
                break;
            case 3:
                manOnBlock= (
                    missedLettersActual +
                    "\n|====," +
                    "\n|   (O0)"  +
                    "\n|    |" +
                    "\n|   /|" +
                    "\n|    " +
                    "\n|    " +
                    "\n|====|"
            );
                break;
            case 4:
                manOnBlock= (
                        missedLettersActual +
                                "\n|====," +
                                "\n|   (O0)"  +
                                "\n|    |" +
                                "\n|   /|\\" +
                                "\n|    |" +
                                "\n|    "  +
                                "\n|====|"
                );
                break;
            case 5:
                manOnBlock= (
                        missedLettersActual +
                                "\n|====," +
                                "\n|   (O0)"  +
                                "\n|    |" +
                                "\n|   /|\\" +
                                "\n|    |" +
                                "\n|    /" +
                                "\n|====|"

                );
                break;
            case 6:
                manOnBlock= (
                        missedLettersActual +
                                "\n|====," +
                                "\n|   (xx)"  +
                                "\n|    |" +
                                "\n|   /|\\" +
                                "\n|    |" +
                                "\n|   /`\\" +
                                "\n|====|" +
                                "\n\nSorry you lost."
                );
                break;
        }
        return manOnBlock;
    }
}
