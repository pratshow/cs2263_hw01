/*
Show Pratoomratana - CS2263 - HW1
V1.2.0
*/

package edu.isu.cs2263.hw01;

//Simple class to output to the console
public class OutputConsole implements Output {

  public void getOutput(String expr, String output){
    System.out.println(expr);
    System.out.println("    -> " + output);
  }
}
