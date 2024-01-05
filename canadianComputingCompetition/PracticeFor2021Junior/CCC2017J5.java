import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numBoards = Integer.parseInt(input.nextLine());
    String allwoodLengths = input.nextLine();
    String [] inputSplits = allwoodLengths.split(" ");
    int [] woodLengths = new int[numBoards];
    int [] boardLengths = new int[4000];
    ArrayList<Integer>[] woodsInvolved = new ArrayList[4000];

    for (int i = 0; i < 4000; i++)
    {
      woodsInvolved[i] = new ArrayList<Integer>();
    }

    int maxLength = 0;
    int difBoardLengths = 0;

    for (int i = 0; i < numBoards; i++)
    {
      woodLengths[i] = Integer.parseInt(inputSplits[i]);
    }  

    for (int i = 0; i < numBoards - 1; i++)
    {
      for (int j = i + 1; j < numBoards; j++)
      {
        if (woodsInvolved[woodLengths[i] + woodLengths[j] - 1].contains(i) == false && woodsInvolved[woodLengths[i] + woodLengths[j] - 1].contains(j) == false)
        {
          boardLengths[woodLengths[i] + woodLengths[j] - 1]++;
          woodsInvolved[woodLengths[i] + woodLengths[j] - 1].add(i);
          woodsInvolved[woodLengths[i] + woodLengths[j] - 1].add(j);
        }
      }
    }

    Arrays.sort(boardLengths);
    maxLength = boardLengths[3999];

    for (int i = 3999; i >= 0; i--)
    {
      if (boardLengths[i] == maxLength)
      {
        difBoardLengths++;
      }
      else
      {
        break;
      }
    }

    System.out.println(maxLength + " " + difBoardLengths);
  }
}