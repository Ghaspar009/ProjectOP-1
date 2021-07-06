package Project1;

public class PESEL {

        public static boolean ControlNumber(String pesel) {

            char[] peselChars = pesel.toCharArray();
            int contolSum = 0;
            for (int i = 0; i < pesel.length() - 1; i++) {
                if (i == 0 || i == 4 || i == 8) {
                    contolSum += (peselChars[i] - 48);
                } else if (i == 1 || i == 5 || i == 9) {
                    contolSum += ((peselChars[i] - 48) * 3) % 10;
                } else if (i == 2 || i == 6) {
                    contolSum += ((peselChars[i] - 48) * 7) % 10;
                } else {
                    contolSum += ((peselChars[i] - 48) * 9) % 10;
                }
            }
            if (pesel.length() == 11) {
                if (10 - (contolSum % 10) == peselChars[10] - 48) {
                    return true;
                }
            }
                return false;
        }

        public static  boolean PeselGenderCheck(String pesel, String forename) { //ta metoda dziala tylko w przypadku gdy imiona zenskie sa zakonczone na litere 'a'.
            String lastLetter = forename.substring(forename.length() - 1);
            char[] peselChars = pesel.toCharArray();
            if (pesel.length() == 11)
                if (lastLetter.equals("a") && peselChars[pesel.length()-2] % 2 == 0 || !lastLetter.equals("a") && peselChars[pesel.length()-2] % 2 == 1)
                    return true;
            return false;
        }
}
