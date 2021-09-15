/*
Show Pratoomratana - CS2263 - HW1
V1.2.0
*/

package edu.isu.cs2263.hw01;

import java.util.Scanner;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Options;
import java.io.*;

public class ConsoleInput implements Input {
  //Reconstructs the input from the teminal to print
  public String getInput(String[] input, int length){
    String inputString = "";
    for (int i = 0; i < length; i++){
      inputString = (inputString + input[i] + " "); //concatination of current string plus next string and a space
    }
    return inputString;
  }

  //If no argument is given enter "live mode".
  public void loopCli(Options options, String toFile) throws ParseException, FileNotFoundException, IOException{
    App app = new App();
    //Making a scanner for live cmd line with whitespace as a delimiter.
    Scanner scanner = new Scanner(System.in);
    System.out.print("> ");
    String input = scanner.nextLine();
    //Splitting the input string into an array
    String[] inputArr = input.split(" ");
    //If you simply enter a expression (no command). I check if the first input is a int
    try{ //Try catch block here because if inputArr[0] is a '-h' etc. you get an error since it's a string not an int.
        int total = app.eval(inputArr, 0);
        app.printTotal(total);
        if ((toFile != null)) { // Sees if the `-o` flag was passed
          FileWriter fWriter = new FileWriter(toFile, true);
          fWriter.write(input + "\n" + "   ->" + total + "\n"); //Write to file and flush buffer
          fWriter.flush();
          fWriter.close();
          loopCli(options, toFile); // loop via recursion
        }
      }
    catch (Exception e){ //Otherwise a diffrent command was entered
      app.checkCmd(options, inputArr);
    }
    finally{
      //scanner.close();
      //Looping via recurrsion use 'ctrl + c to exit'
      loopCli(options, null);
    }
  }
}
