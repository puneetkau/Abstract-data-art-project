import org.code.theater.*;
import org.code.media.*;

public class Business {

  private String name;     // name of business
  private int income;         // the money they make

  // Constructor
  public Business(String name, int income) {
    this.name = name;
    this.income = income;
  }

  //Accessor method for the business names
  public String getName() {
    return name;
  }
  
  // Accessor method for the income
  public int getIncome() {
    return income;
  }
}