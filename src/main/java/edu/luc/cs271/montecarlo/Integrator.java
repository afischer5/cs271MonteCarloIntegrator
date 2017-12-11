package edu.luc.cs271.montecarlo;

import java.util.*;
import com.udojava.evalex.Expression;


//this class handles all checks to see if a point is whithin a functions bounds after creating them and stores information about the function
public class Integrator {
  Expression exp;
  double minRange;
  double maxRange;
  PointGenerator pointGen;
  List<String> variables;
  int numberOfPoints;
  
  boolean debug = false;
  
  final double DEFAULT_MAX_RANGE = 100;
  final double DEFAULT_MIN_RANGE = -100;
  final int DEFAULT_NUMBER_OF_POINTS = 1000;
  
  public Integrator(Expression exp, List<String> vars, int numberOfPoints, double min, double max){
      this.exp = exp;
      this.variables = vars;
      pointGen = new PointGenerator(vars.size());
      this.minRange = min;
      this.maxRange = max;
      this.numberOfPoints = numberOfPoints;
  }
  
  //a construtor but with several values set to default for ease of construction and debugging
  public Integrator(Expression exp, List<String> vars){
      this.exp = exp;
      this.variables = vars;
      pointGen = new PointGenerator(vars.size());
      this.minRange = DEFAULT_MIN_RANGE;
      this.maxRange = DEFAULT_MAX_RANGE;
      this.numberOfPoints = DEFAULT_NUMBER_OF_POINTS;
  }
  
  //does the actual calculation of the integral based on information stored in
  //integrator seperating like this alows us to do the same integral but with a
  //different domain easily
  public double integrate (List<Double> mins, List<Double> maxs){
      double result = 0;
      double area;
      double value = 0;
      
      //begin looking at points
      for(int i = 0; i < this.numberOfPoints; i++){
          pointGen.generatePoint(mins,maxs,this.minRange,this.maxRange);
          
          //inserts all the variable values into the expression
          for(int j = 0; j < this.variables.size(); j++){
              this.exp = this.exp.with(this.variables.get(j),Double.toString(pointGen.getPointCoords().get(j+1)));
          }
          
          value = this.exp.eval().doubleValue();
          double independentVariable = pointGen.getPointCoords().get(0);
          
          //determines if the point is within the integrand
          if(value < 0 && value < independentVariable && independentVariable <0) result--;
          if(value > 0 && value > independentVariable && independentVariable > 0) result++;
      }//end of looking at all points
      
      //calculates the proportion of area inside integral or negatively inside it
      result = result / this.numberOfPoints;
      
      //calculates the total area and uses this to produce a final result
      area = maxRange - minRange;
      for(int i = 0; i < mins.size(); i++){
          area = area * (maxs.get(i) - mins.get(i));
      }
      
      if(debug){
      System.out.println("area" + area);
      System.out.println("value" + value);
      System.out.println("result" + result);
       System.out.println("independent" + pointGen.getPointCoords().get(0));
      }
      
      return area * result;
    }
  
}