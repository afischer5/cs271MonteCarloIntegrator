package edu.luc.cs271.montecarlo;

import java.util.*;
import com.udojava.evalex.Expression;


public class Main {
    
    public static void main(String[] args){
     /* This main class is the driver for asking for user information and interpreting it
     as well as displaying the results of an asked for calculation*/
     
     
     Scanner keyboard = new Scanner(System.in);
     String input;
     Expression exp;
     List<String> variables = new ArrayList<String>();
     List<Double> mins = new ArrayList<Double>();
     List<Double> maxs = new ArrayList<Double>();
     
     System.out.println("Monte Carlo Integrator for instructions enter 'help' or '?'. To terminate please enter 'terminate'. To integrate enter 'integrate' ");
     
     do{
       input = keyboard.nextLine();
     
      if(input.equalsIgnoreCase("?") || input.equalsIgnoreCase("help")) {
          System.out.println("Please enter a mathematical function. Use all caps and shorthand form for trig functions and ABS for absolute value");
          System.out.println("Follow this function up with a range of numbers seperated by a space that indicates respectively the min of range, the max of range, the number of points to use.");
          System.out.println("Follow this with a list of variables to integrate with each seperated by a space.");
          System.out.println("Then enter a domain for the integration bounds for each variable in the integrand seperated by a space. i.e. Create a pair of numbers for each variable and sperate each pair by a space aswell.");
          input = keyboard.nextLine();
      } 
     
    
      
      //the follow is displayed when teh user asks for help
      while(input.equalsIgnoreCase("?") || input.equalsIgnoreCase("help")) {
          System.out.println("Please enter a mathematical function. Use all caps and shorthand form for trig functions and ABS for absolute value");
          System.out.println("Follow this function up with a range of numbers seperated by a space that indicates respectively the min of range, the max of range, the number of points to use.");
          System.out.println("Follow this with a list of variables to integrate with each seperated by a space.");
          System.out.println("Then enter a domain for the integration bounds for each variable in the integrand seperated by a space. i.e. Create a pair of numbers for each variable and sperate each pair by a space aswell.");
          input = keyboard.nextLine();
      } 
      
      if(input.equalsIgnoreCase("integrate")){
       
     
      exp = new Expression(keyboard.nextLine());
      System.out.println(input);
      Double rMin = keyboard.nextDouble();
      Double rMax = keyboard.nextDouble();
      int numberPoints = keyboard.nextInt();
      keyboard.nextLine();
      
      String variableString = keyboard.nextLine();
       List<String> vars = Arrays.asList(variableString.split(" "));
       for(int i = 0; i < vars.size(); i ++){
          variables.add(vars.get(i));
       }
      
     List<String> domains = Arrays.asList(keyboard.nextLine().split(" "));
      for(int i = 0; i < domains.size(); i= i +2){
          mins.add(Double.parseDouble(domains.get(i)));
          maxs.add(Double.parseDouble(domains.get(i + 1)));
       }
      
      
      Integrator integrator = new Integrator(exp, variables, numberPoints,rMin,rMax);
      System.out.println(exp + " integrated over " + variableString +" with respective domains " + domains + " = " +integrator.integrate(mins,maxs));
      
      }
     }while(!input.equalsIgnoreCase("terminate")); 
     
        keyboard.close();
    }
}