import java.util.*;
import com.udojava.evalex.Expression;


//this class handles all checks to see if a point is whithin a functions bounds after creating them and stores information about the function
public class Integrator {
  String exp;
  double minRange;
  double maxRange;
  PointGenerator pointGen;
  List<String> variables;
  int numberOfPoints;
  
  final double DEFAULT_MAX_RANGE = 100;
  final double DEFAULT_MIN_RANGE = -100;
  final int DEFAULT_NUMBER_OF_POINTS = 10000;
  
  public Integrator(String exp, List<String> vars, int numberOfPoints, double min, double max){
      this.exp = exp;
      this.variables = vars;
      pointGen = new PointGenerator(vars.size());
      this.minRange = min;
      this.maxRange = max;
      this.numberOfPoints = numberOfPoints;
  }
  
  public Integrator(String exp, List<String> vars){
      this.exp = exp;
      this.variables = vars;
      pointGen = new PointGenerator(vars.size());
      this.minRange = DEFAULT_MIN_RANGE;
      this.maxRange = DEFAULT_MAX_RANGE;
      this.numberOfPoints = DEFAULT_NUMBER_OF_POINTS;
  }
  
  public double integrate (List<Double> mins, List<Double> maxs, List<String> variables){
      for(int i = 0; i < this.numberOfPoints; i++){
          
      }
      return 6.7;
  }
  
}