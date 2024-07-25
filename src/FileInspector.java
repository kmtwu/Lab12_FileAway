import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;

public class FileInspector {
    public static void main (String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        String recordedLine;
        File chosenFile;
        int characters = 0;
        int words = 0;
        String name;
        try {

            File directoryFile = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(directoryFile);

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                chosenFile = fileChooser.getSelectedFile();
                Path file = chosenFile.toPath();
                name = chosenFile.getName();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int lineNumber = 0;

                while(reader.ready()) {
                    recordedLine = reader.readLine();
                    characters = characters + recordedLine.length();
                    String [] wordSplit = recordedLine.split("\\s+");
                    words = words + wordSplit.length;
                    characters = characters + recordedLine.length();
                    lineNumber = lineNumber + 1;
                    System.out.printf("\nLine %4d %-60s ", lineNumber, recordedLine);
                }
                reader.close();
                System.out.println("\n\nFile read!" + " There are " + characters + " characters in this file.");
                System.out.println("There are " + lineNumber + " lines in this file. There are " + words + " words in this file.");
                System.out.println("The file name is " + name + ".");
            }
            else {
                System.out.println("No file was chose. Bye Bye!");
                System.out.println("Run the program again to try again and actually select a file this time.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
