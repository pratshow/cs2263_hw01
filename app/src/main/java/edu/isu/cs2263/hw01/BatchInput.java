package edu.isu.cs2263.hw01;

import java.util.Scanner;
import java.io.*;

public class BatchInput implements Input {

  public String getInput(String[] input, int length){ //Reconstructs input from array of strings.
    String inputString = "";
    for (int i = 0; i < length; i++){
      inputString = (inputString + input[i] + " "); //concatination of current string plus next string and a space
    }
    return inputString;
  }

  //Check to see if the file is valid
  public boolean checkFile(String usrFile) throws FileNotFoundException{
    //This is the dir where the file should be placed
    File directory = new File("./src/main/java/edu/isu/cs2263/hw01/");
    boolean found = false;

    File[] files = directory.listFiles(); // Array of files for all the files in the dir
    for (File file : files) { //Iterate through all the files until a name matches
        if (file.getName().equals(usrFile)) {
          found = true;
          return found;
        }
    }
      return found;
  }

  //Method to read the contents of the file and print to terminal
  public void readFile(String file) throws FileNotFoundException, IOException{
    App app = new App();
    if (checkFile(file) == false){ //Seeing if the file exists
      System.out.println(file + " could not be found. Please ensure the file is in 'cs2263_hw01/app/src/main/java/edu/isu/cs2263/hw01' ");
    }
    else{
      file = ("./src/main/java/edu/isu/cs2263/hw01/" + file); // Full path name to file
      try (BufferedReader br = new BufferedReader(new FileReader(file))){
        String expressionString;
        while((expressionString = br.readLine()) != null){ // Read every line in the file one at a time
          System.out.println(expressionString); // Print the line
          String[] expressionArr = expressionString.split(" "); //Split into a array and evaluate and print to terminal
          int total = app.eval(expressionArr, 0);
          app.printTotal(total);
        }
      }
    }
  }

}
