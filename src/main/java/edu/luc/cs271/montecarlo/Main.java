import java.util.*;
import com.udojava.evalex.Expression;

public class Main {
    
    public static void main(String[] args){
     /* This main class is the driver for asking for user information and interpreting it
     as well as displaying the results of an asked for calculation*/
     
     //Scanner keyboard = new Scanner(System.in).useDelimiter("[^\\p{Alnum}]+");
     Scanner keyboard = new Scanner(System.in);
     String input;
     Expression exp;
     
     System.out.println("Monte Carlo Integrator for instructions enter 'help' or '?'. To terminate please enter 'terminate'.");
     
     do{
      input = keyboard.next();
      
      //the follow is displayed when teh user asks for help
      if(input.equalsIgnoreCase("?") || input.equalsIgnoreCase("help")) {
          System.out.println("Please enter a mathematical function. Use all caps and shorthand form for trig functions and ABS for absolute value");
          //System.out.println("Follow this with a list of variables to integrate with each seperated by a comma");
          System.out.println("Follow this function up with a range of numbers seperated by a comma that indicates the domain of integration. Create a pair of numbers for each variable.");
          System.out.println("Then enter a range for the integration bounds for a dendency variable also seperated by a comma.");
      } 
      //else exp = new Expression(input);
        
      
      
     } while(!input.equalsIgnoreCase("terminate"));
     
     
        
        
        
    }
}