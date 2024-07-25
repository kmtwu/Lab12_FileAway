import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main (String[] args) {
        ArrayList <String> CSV = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String firstName;
        String lastName;
        String IDnumber;
        String email;
        int bDay;
        boolean cont = false;
        do {
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            IDnumber = SafeInput.getRegExString(in, "Enter your ID number, which is a 6 digit number", "\\d{6}");
            email = SafeInput.getRegExString(in, "Enter your email", "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            bDay = SafeInput.getRangedInt(in, "Enter your birth year", 1000, 9999);
            CSV.add(firstName + ", " + lastName + ", " + IDnumber + ", " + email + ", " + bDay);
            cont = SafeInput.getYNConfirm(in, "Enter Y/N to see if you would like to make another CSV to put in the data file");
        } while (cont);

        File directoryFile = new File(System.getProperty("user.dir"));
        Path file = Paths.get(directoryFile.getPath() + "\\src\\data.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String CSVpart : CSV) {
                writer.write(CSVpart, 0, CSVpart.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("We are done writing!");
        }
        catch (IOException e) {
            e.printStackTrace();;
        }
    }
}
