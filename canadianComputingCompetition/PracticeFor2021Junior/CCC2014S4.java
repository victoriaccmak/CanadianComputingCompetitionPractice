import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numGlass = Integer.parseInt(input.nextLine());
    int minTintFactor = Integer.parseInt(input.nextLine());
    String [] glassInfos = new String[numGlass];
    int [] topLeftX = new int[numGlass];
    int [] topLeftY = new int[numGlass];
    int [] botRightX = new int[numGlass];
    int [] botRightY = new int[numGlass];
    int [] tintFactors = new int[numGlass];
    int area = 0;
    int [][] eachSqUnitTint;
    int boxTLX;
    int boxTLY;
    int boxBRX;
    int boxBRY;

    //Extract the information from input
    for (int i = 0; i < numGlass; i++)
    {
      glassInfos[i] = input.nextLine();

      topLeftX[i] = Integer.parseInt(glassInfos[i].substring(0, glassInfos[i].indexOf(" ")));
      glassInfos[i] = glassInfos[i].substring(glassInfos[i].indexOf(" ") + 1, glassInfos[i].length());
      topLeftY[i] = Integer.parseInt(glassInfos[i].substring(0, glassInfos[i].indexOf(" ")));
      glassInfos[i] = glassInfos[i].substring(glassInfos[i].indexOf(" ") + 1, glassInfos[i].length());
      botRightX[i] = Integer.parseInt(glassInfos[i].substring(0, glassInfos[i].indexOf(" ")));
      glassInfos[i] = glassInfos[i].substring(glassInfos[i].indexOf(" ") + 1, glassInfos[i].length());
      botRightY[i] = Integer.parseInt(glassInfos[i].substring(0, glassInfos[i].indexOf(" ")));
      tintFactors[i] = Integer.parseInt(glassInfos[i].substring(glassInfos[i].indexOf(" ") + 1));    
    }

    //Find the coordinates of the box covering the entire area
    boxTLX = GetMaxOrMin(1, topLeftX);
    boxTLY = GetMaxOrMin(1, topLeftY);
    boxBRX = GetMaxOrMin(2, botRightX);
    boxBRY = GetMaxOrMin(2, botRightY);

    //Set the dimensions of the 2D array to keep track of the tint for each sq. unit
    eachSqUnitTint = new int[boxBRX][boxBRY];



    for (int rowIndex = boxTLX; rowIndex < boxBRX; rowIndex++)
    {
      for (int colIndex = boxTLY; colIndex < boxBRY; colIndex++)
      {    
        for (int glassPiece = 0; glassPiece < numGlass; glassPiece++)
        {
          if (rowIndex >= topLeftX[glassPiece] && rowIndex < botRightX[glassPiece] && colIndex >= topLeftY[glassPiece] && colIndex < botRightY[glassPiece])
          {
            eachSqUnitTint[rowIndex][colIndex] += tintFactors[glassPiece];
          }
        }
      }
    }

    for (int rowIndex = boxTLX; rowIndex < boxBRX; rowIndex++)
    {
      for (int colIndex = boxTLY; colIndex < boxBRY; colIndex++)
      {
        if (eachSqUnitTint[rowIndex][colIndex] >= minTintFactor)
        {
          area++;
        }
      }
    }

    System.out.println(area);
  }

  private static int GetMaxOrMin(int minIs1MaxIs2, int [] array)
  {      
    int num = array[0];

    switch (minIs1MaxIs2)
    {
      case 1: 
        for (int i = 1; i < array.length; i++)
        {
          if (num >= array[i])
          {
            num = array[i];
          }
        } 
        break;
      case 2:
        for (int i = 1; i < array.length; i++)
        {
          if (num <= array[i])
          {
            num = array[i];
          }
        }
        break;
    }
    return num;
  }
}