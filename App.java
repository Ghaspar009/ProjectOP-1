// Projekt zaliczeniowy autorstwa Kacpra Knuth

package Project1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        List<Resident> residentList = new ArrayList<>();
        String city, forename, surname, pesel, line, runAgain, fileName, extension;
        String [] namePesel;
        boolean overwritten;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Podaj miasto."); //u�ytkownik podaje miasto
            city = scanner.nextLine();
            System.out.println("Podaj po spacji imie, nazwisko i PESEL"); //w kolejnej linii podaje imie, nazwisko i numer pesel
            line = scanner.nextLine();
            namePesel = line.split(" ");
            try {
                forename = namePesel[0];
                surname = namePesel[1];
                pesel = namePesel[2];
                Resident resident = new Resident(city, forename, surname, pesel);
                overwritten = false;
                if(PESEL.ControlNumber(pesel) && PESEL.PeselGenderCheck(pesel, forename)) {
                    for(Resident re : residentList) {
                        if (App.RepetedPesel(re, pesel, forename, surname))
                        {
                            overwritten = true;
                            re.setCity(city);
                            re.setForename(forename);
                            re.setSurname(surname);
                            break;
                        }
                    }
                    if (!overwritten) {
                        residentList.add(resident);
                    }
                }
                else System.out.println("Podany numer PESEL jest bledny, wpis nie zostanie zapisany.");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Dane zostaly wprowadzone w bledny sposob.");
            }
            System.out.println("Czy chcesz kontynuowac (t/n)?");
            do {
                runAgain = scanner.nextLine();
                if (!runAgain.equals("t") && !runAgain.equals("n"))
                    System.out.println("Wprowadz t lub n.");
            }while(!runAgain.equals("t") && !runAgain.equals("n"));
        } while (runAgain.equals("t"));

        System.out.println("Jak chcesz nazwac plik do ktorego zostana zapisane dane? Podaj nazwe wraz z rozszerzeniem '.txt'.");
        do {
            fileName = scanner.nextLine();
            extension = fileName.substring(fileName.length() - 4);
            if (!extension.equals(".txt")) System.out.println("Nazwa pliku musi zostac wpisana wraz z rozszerzeniem '.txt'.");
        }while(!extension.equals(".txt"));
        scanner.close();

        FileWriter writer = new FileWriter(fileName);
        for(Resident resident : residentList) {
            writer.write(resident.getCity() + " " + resident.getForename() + " " + resident.getSurname() + " " + resident.getPesel() + "\n");
        }
        writer.close();
    }

    public static boolean RepetedPesel(Resident resident, String pesel, String forename, String surname) {  //w poleceniu jest napisane gdy pesel jest ten sam, a imie i nazwisko inne to nadpisujemy
        if (resident.getPesel().equals(pesel) && !resident.getForename().equals(forename) && !resident.getSurname().equals(surname))
            return true;
        return false;
    }
}
