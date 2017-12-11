import java.util.*;
import com.udojava.evalex.Expression;

public class PointGenerator { //maybe we should make this a point and put point generator as the constructor? but then we cant reuse the class' instance?
  
  private int dimension;
  private List<Double> coordinates;
  
  //this creates an instance of a pointgenerator this does not generate the points themdelves
  public PointGenerator(int dim){
    this.dimension = dim;
    this.coordinates = new ArrayList<Double>();
  }
  
  //dim returns the number of independen dimensions of integration
  public int getDim(){
    return this.dimension;
  }
  
  //dim defines the number of dimensions a random double between max and min is randomly generated for each point
  public void generatePoint(List<Double> min, List<Double> max, Double rMin, Double rMax){
    if(min.size()!=this.dimension || max.size()!=this.dimension) throw new IllegalArgumentException("min and max list have to have same size as the dimension of the point");
    
    Random generator = new Random();
    
    //this adds our dependent variable
    this.coordinates.add(generator.nextDouble() * (rMax - rMin) + rMin);
    
    //adds each of our independent variables
    for(int i = 0; i < this.dimension; i++){
      this.coordinates.add(generator.nextDouble() * (max.get(i) - min.get(i)) + min.get(i));
    }
  }
  
  
  public List<Double> getPointCoords(){
      return this.coordinates;
  }
    
}
  
  
  
  
