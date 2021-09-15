/*
Show Pratoomratana - CS2263 - HW1
V1.2.0
*/

package edu.isu.cs2263.hw01;

import java.io.*;
import java.util.*;
import org.apache.commons.cli.Options;


//Class to deal with -o flag, writing to a file
public class OutputFile implements Output{

  public void getOutput(String expr, String output){
    OutputConsole consoleOut = new OutputConsole();
    consoleOut.getOutput(expr, output);   //Prints to the console

  }

  private boolean fileExists(String file) throws FileNotFoundException{ // Checks if the file exists in ./src/main/java/edu/isu/cs2263/hw01/
    BatchInput fileCheck = new BatchInput();
    boolean status = fileCheck.checkFile(file);
    return status;
  }

  public void writeFile(Options options, String file) throws java.io.IOException{
    //OutputFile out;
    boolean status = fileExists(file);
    String absFile = ("./src/main/java/edu/isu/cs2263/hw01/" + file); // Giving the file a full path name
    try{
      if (status == false){ // If the the doesn't exist create it
        File newFile = new File(absFile);
        System.out.println(file + " doesn't exist so it was created");
        newFile.createNewFile();
      }
      ConsoleInput watingInput = new ConsoleInput();
      watingInput.loopCli(options, absFile);  // Go to "live" console mode for inputs
    }
    catch (Exception e){
      System.out.println("Couldn't create or find file");
    }

  }
}
