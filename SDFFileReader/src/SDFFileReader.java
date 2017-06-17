/**
 * Created by HCL on 6/16/2017.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class SDFFileReader {
    public static void main(String[] args) {
        readDataFromSDFFile();
    }

    public static void readDataFromSDFFile() {
        try {
            File SDFFile = new File("Z:/Shared/Code/Biogen/Medicinal Chemistry/Material from Michael/100080_71_products from eLN.sdf");
            FileReader fileReader = new FileReader(SDFFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            String currentStructure = "";
            String position = "";
            String compoundID = "";
            String name = "";
            String exactMass = "";
            String theoryMass = "";
            int posIndex = -1;
            int compoundIDIndex = -1;
            int nameIndex = -1;
            int exactMassIndex = -1;
            int theoryMassIndex = -1;

            Boolean appendStructure = false;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i==3) {
                    //append line, add CR and LF back in, as they get stripped by readline
                    currentStructure = currentStructure + line + "\r\n";
                    appendStructure = true;
                } else if (appendStructure && i > 2 && !line.toLowerCase().contains("M  END".toLowerCase())){
                    //append line, add CR and LF back in, as they get stripped by readline
                    currentStructure = currentStructure + line + "\r\n";
                } else if (appendStructure && line.toLowerCase().contains("M  END".toLowerCase())){
                    //stop appending after "M  END" tag
                    appendStructure = false;
                } else if (line.toLowerCase().contains("Pos.".toLowerCase())) {
                    posIndex = i + 1;
                } else if (i == posIndex){
                    position = line;
                } else if (line.toLowerCase().contains("Compound ID".toLowerCase())) {
                    compoundIDIndex = i + 1;
                } else if (i == compoundIDIndex){
                    compoundID = line;
                } else if (line.toLowerCase().contains("Name".toLowerCase())) {
                    nameIndex = i + 1;
                } else if (i == nameIndex){
                    name = line;
                } else if (line.toLowerCase().contains("EM".toLowerCase())) {
                    exactMassIndex = i + 1;
                } else if (i == exactMassIndex){
                    exactMass = line;
                } else if (line.toLowerCase().contains("Theory Mass".toLowerCase())) {
                    theoryMassIndex = i + 1;
                } else if (i == theoryMassIndex){
                    theoryMass = line;
                } else if (line.toLowerCase().contains("$$$$".toLowerCase())) {
                    //do something weith these values
                    //here, we could instantiate a new instance of Compound and set all these properties and then add it to the experiment
                    System.out.print(currentStructure);
                    System.out.println(position);
                    System.out.println(compoundID);
                    System.out.println(name);
                    System.out.println(exactMass);
                    System.out.println(theoryMass);
                    i = -1;
                    posIndex = -1;
                    compoundIDIndex = -1;
                    nameIndex = -1;
                    exactMassIndex = -1;
                    theoryMassIndex = -1;
                    currentStructure = "";
                }



                i++;
//                }


            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


