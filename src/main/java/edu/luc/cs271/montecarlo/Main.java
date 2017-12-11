package edu.luc.cs271.montecarlo;

import java.util.*;
import com.udojava.evalex.Expression;


public class Main {
    
    public static void main(String[] args){
     /* This main class is the driver for asking for user information and interpreting it
     as well as displaying the results of an asked for calculation*/
     
     //Scanner keyboard = new Scanner(System.in).useDelimiter(",");
     Scanner keyboard = new Scanner(System.in);
     String input;
     Expression exp;
     List<String> variables = new ArrayList<String>();
     List<Double> mins = new ArrayList<Double>();
     List<Double> maxs = new ArrayList<Double>();
     
     System.out.println("Monte Carlo Integrator for instructions enter 'help' or '?'. To terminate please enter 'terminate'.");
     
     do{
      input = keyboard.nextLine();
      
      //the follow is displayed when teh user asks for help
      while(input.equalsIgnoreCase("?") || input.equalsIgnoreCase("help")) {
          System.out.println("Please enter a mathematical function. Use all caps and shorthand form for trig functions and ABS for absolute value");
          System.out.println("Follow this function up with a range of numbers seperated by a space that indicates respectively the min of range, the max of range, the number of points to use.");
          System.out.println("Follow this with a list of variables to integrate with each seperated by a comma.");
          System.out.println("Then enter a domain for the integration bounds for each variable in the integrand seperated by a comma. i.e. Create a pair of numbers for each variable.");
          input = keyboard.nextLine();
      } 
      
      exp = new Expression(input);
      System.out.println(input);
      Double rMin = keyboard.nextDouble();
      Double rMax = keyboard.nextDouble();
      int numberPoints = keyboard.nextInt();
      keyboard.nextLine();
      System.out.println(rMin + rMax);
      
      String variableString = keyboard.nextLine();
       List<String> vars = Arrays.asList(variableString.split(","));
       for(int i = 0; i < vars.size(); i ++){
          variables.add(vars.get(i));
       }
      
     List<String> domains = Arrays.asList(keyboard.nextLine().split(","));
      for(int i = 0; i < domains.size(); i= i +2){
          mins.add(Double.parseDouble(domains.get(i)));
          maxs.add(Double.parseDouble(domains.get(i + 1)));
       }
      
      
      Integrator integrator = new Integrator(exp, variables, numberPoints,rMin,rMax);
      System.out.println(integrator.integrate(mins,maxs));
      
      
     } while(!input.equalsIgnoreCase("terminate"));
     
     
        
        
        
        /*Expression exp = new Expression("1 + x");
        List<String> vars = new ArrayList<>();
        vars.add("x");
         List<Double> mins = new ArrayList<>();
         mins.add(2.0);
         List<Double> maxs = new ArrayList<>();
         maxs.add(2.1);
        Integrator integrator = new Integrator(exp,vars);
        System.out.println(integrator.integrate(mins,maxs));*/
        
        keyboard.close();
    }
}