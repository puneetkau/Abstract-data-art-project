import org.code.theater.*;

public class DataScene extends Scene {


  private Business[] businesses; // 1D array of business objects

  public DataScene() {
    businesses = createBusinesses();
  }

  public Business[] createBusinesses() {
  String[] businessNames = FileReader.toStringArray("business.txt"); //draws business names from business.txt, where chatGPT generated me random business names. 
  int[] averageIncome = FileReader.toIntArray("average.txt"); //draws the average incomes from the household data set on code.org

    //connects text files and creates a 1D array called businessList
  Business[] businessList = new Business[businessNames.length];
    for (int i = 0; i < businessList.length; i++) {
      businessList[i] = new Business(businessNames[i], averageIncome[i]);
    }

    return businessList;

  }

public void drawScene() {

  //picks random values from the business list.
    int index = (int) (Math.random() * businesses.length);

    // Changes the background depending on the income of the businesses
    if (businesses[index].getIncome() > 50000) {
      clear("green");
    } else if (businesses[index].getIncome() < 50000) {
      clear("olive");
    } 

    // sets the stroke and fill color to white
    setStrokeColor("white");
    setFillColor("white");

    // draws two rectangles
    drawRectangle(75, 35, 250, 90);
    drawRectangle(25, 140, 350, 225);

  //if businesses make over 50000, an image with a handful of money is printed along with the steady income message.
    if (businesses[index].getIncome() > 50000) {
      drawImage("Screen-Shot-2024-12-12-at-2.19.13-AM.png", 25, 170, 182, 182, 0.0);
      drawText("Steady income", 200, 270);
  //if businesses make less than 50000, an image with a coin is printed along with the low income message.
    } else if (businesses[index].getIncome() < 50000) {
      drawImage("Screen-Shot-2024-12-12-at-2.21.18-AM.png", 195, 170, 182, 182, 0.0);
      drawText("Low income", 85, 270);
    } 
//draws text -- the name of the business randomly chosen and the average income.
  drawText(businesses[index].getName(), 85, 90);
  drawText("Average income = " + businesses[index].getIncome(), 85, 190);
  
  
  }

  
}