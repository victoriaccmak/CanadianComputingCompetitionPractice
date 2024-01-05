import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numBoards = Integer.parseInt(input.nextLine());
    String allBoardLengths = input.nextLine();
    int [] boardLengths = new int[numBoards];
    ArrayList<Integer> possibleHeights = new ArrayList<Integer>();
    ArrayList<Integer> lengthForPosHeights = new ArrayList<Integer>();
    boolean found;
    int difHeights = 0;

    for (int i = 0; i < numBoards - 1; i++)
    {
      boardLengths[i] = Integer.parseInt(allBoardLengths.substring(0, allBoardLengths.indexOf(" ")));
      allBoardLengths = allBoardLengths.substring(allBoardLengths.indexOf(" ") + 1);
    }
    boardLengths[numBoards - 1] = Integer.parseInt(allBoardLengths);

    

    for (int i = 0; i < numBoards - 1; i++)
    {
      for (int j = i + 1; j < numBoards; j++)
      {
        if (j != 1)
        {
          found = false;

          //Search for preexisting height value
          for (int k = 0; k < possibleHeights.size() && found == false; k++)
          {
            if (boardLengths[i] + boardLengths[j] == possibleHeights.get(k))
            {
              lengthForPosHeights.set(k, lengthForPosHeights.get(k) + 1);
              found = true;
            }
          }

          //Add new height if preexisting height is not found
          if (found == false)
          {
            possibleHeights.add(boardLengths[i] + boardLengths[j]);
            lengthForPosHeights.add(1);
          }
        }
        else
        {
          possibleHeights.add(boardLengths[0] + boardLengths[1]); 
          lengthForPosHeights.add(1);
        }
      }
    }

    //System.out.println("PossibleHeights: " + possibleHeights);
    //System.out.println("Length for possible heights: " + lengthForPosHeights);
    
    Integer maxLength = Collections.max(lengthForPosHeights);

    for (int i = 0; i < possibleHeights.size(); i++)
    {
      if (lengthForPosHeights.get(i) == maxLength)
      {
        difHeights++;
      }
    }
    
    System.out.println(maxLength + " " + difHeights);
  }
}