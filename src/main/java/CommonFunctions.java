

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommonFunctions {

    //Logger defined for class, logs created as per log4j.properties
//    private static Logger log = Logger.getLogger(CommonFunctions.class);
    private static Logger log = LogManager.getLogger(CommonFunctions.class);

    //Method to return data set to data provider
    public static Object[][] getDataDetails(String assetJourney) throws IOException {
        log.info("Scanning CSV to find active files for use case to use!");

        String csvFile = "src/test/resources/data/" + assetJourney + ".csv";

        //Reading Active script names
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        br = new BufferedReader(new FileReader(csvFile));

        ArrayList<ArrayList<String>> md = new ArrayList<ArrayList<String>>();
        Object[] active = null;


        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")){
                //Don't read the line, it's a comment
            } else {
                active = line.split(cvsSplitBy);
//                if (active[0].toString().equalsIgnoreCase("active")) {
                ArrayList<String> row = new ArrayList<String>();
                for(int i=0;i<active.length;i++){
                    row.add(active[i].toString());
                }
                md.add(row);
//                }
            }
        }
//        Object[][] data = new Object[md.size()][active.length-1];
        Object[][] data = new Object[md.size()][active.length];
        //initialize data
        int index=0;
        for(ArrayList<String> r : md){
            for(int i=0;i<r.size();i++){
                data[index][i] = r.get(i).toString();
            }
            ++index;
        }
        return data;
    }


    public static void renameFile(String oldFileWithPath, String newNameFileWithPath){
        // Create an object of the File class
        // Replace the file path with path of the directory
        File file = new File(oldFileWithPath);

        // Create an object of the File class
        // Replace the file path with path of the directory
        File rename = new File(newNameFileWithPath);

        // store the return value of renameTo() method in
        // flag
        boolean flag = file.renameTo(rename);
        // if renameTo() return true then if block is
        // executed
        if (flag == true) {
            log.info("File Successfully Rename");
        }
        // if renameTo() return false then else block is
        // executed
        else {
            log.info("Operation Failed");
        }
    }

}
