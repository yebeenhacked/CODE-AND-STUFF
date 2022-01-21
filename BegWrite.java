import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {



        try {
            File myFile = new File("inputFile.txt");
            File output = new File("outputFile.txt");
            output.createNewFile();
            FileWriter writer = new FileWriter("outputFile.txt" , true);



            Scanner file = new Scanner(myFile);
            Scanner file2 = new Scanner(output);


            while(file.hasNextLine()){
                String data = file.nextLine();
                writer.write(data + "\n");
            }
            writer.close();



            while(file2.hasNextLine()){
                String data = file2.nextLine();
                System.out.println("line output: " + data);
            }

        }catch (Exception a){
            System.out.println(a);
        }






    }
}
