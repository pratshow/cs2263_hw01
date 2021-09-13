package edu.isu.cs2263.hw01;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BatchInput implements Input {

  public String getInput(String[] input, int length){ //Reconstructs input from array of strings.
    String inputString = "";
    for (int i = 0; i < length; i++){
      inputString = (inputString + input[i] + " "); //concatination of current string plus next string and a space
    }
    return inputString;
  }

  //Check to see if the file is valid
  public boolean checkFile(String file){
    try{
      boolean isFile = new File(file).isFile();
      System.out.println(isFile + " was returned");
      return isFile;
    }
    catch (Exception e){
      System.out.println("I was caught!");
      return false;
    }
  }

  //Method to read the contents of the file and print to terminal
  public void readFile(String file){
    App app = new App();
    if (checkFile(file) == false){
      System.out.println(file + " does not exist, please specify a real file");
    }
    else{
      File readFile = new File(file);
      Scanner scanner = new Scanner(file);
      String expressionString = scanner.useDelimiter("\\n").next();
      String[] expressionArr = expressionString.split(" ");
      String input = getInput(expressionArr, expressionArr.length);
      System.out.println(input); // Prints the expression from the file
      int total = app.eval(expressionArr, 0);
      app.printTotal(total);
    }
  }

}
