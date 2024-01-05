import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String [] eachDist = input.nextLine().split(" ");
    int [] consDist = new int[5];
    int [][] distances = new int[5][5];
    int curLocation = 0;
    int curLocation2 = 0;
    int [] line = new int[5];

    consDist[0] = 0;

    for (int i = 1; i < 5; i++)
    {
      consDist[i] = Integer.parseInt(eachDist[i - 1]);
    }

    for (int i = 0; i < 5; i++)
    {
      //Determine current location on the line
      curLocation += consDist[i];

      //Determine the second location and the distance between them
      for (int j = 0; j < 5; j++)
      {
        curLocation2 += consDist[j];
        distances[i][j] = Math.abs(curLocation2 - curLocation);
      }

      for (int j = 0; j < 5; j++)
      {
        System.out.print(distances[i][j] + " ");
      }
      
      System.out.println("");
      curLocation2 = 0;
    }
  }
}