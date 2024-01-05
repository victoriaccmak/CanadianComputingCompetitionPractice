import java.util.Scanner;

class Main 
{
  static boolean GOLD = true;
  static boolean BLACK = false;
  
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numRows = Integer.parseInt(input.nextLine());
    int numCols = Integer.parseInt(input.nextLine());
    int numActions = Integer.parseInt(input.nextLine());
    
    boolean[][] gridColours = new boolean[numRows][numCols];
    
    String action;
    int line;

    int numGold = 0;
    
    for (int i = 0; i < numActions; i++)
    {
      action = input.nextLine();
      line = Integer.parseInt(action.substring(action.indexOf(" ") + 1)) - 1;
      
      if (action.charAt(0) == 'R')
      {
        for (int j = 0; j < numCols; j++)
        {
          gridColours[line][j] = !gridColours[line][j];
        }
      }
      else
      {
        for (int j = 0; j < numRows; j++)
        {
          gridColours[j][line] = !gridColours[j][line];
        }
      }
    }

    for (int i = 0; i < numRows; i++)
    {
      for (int j = 0; j < numCols; j++)
      {
        if (gridColours[i][j])
        {
          numGold++;
        }
      }
    }
    
    System.out.println(numGold);
  }
}