import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numPlayers = Integer.parseInt(input.nextLine());

    int [] numPoints = new int[numPlayers];
    int [] numFouls = new int[numPlayers];
    int [] stars = new int[numPlayers];

    int starPlayers = 0;
    
    for (int i = 0; i < numPlayers; i++)
    {
      numPoints[i] = Integer.parseInt(input.nextLine());
      numFouls[i] = Integer.parseInt(input.nextLine());
      stars[i] = numPoints[i] * 5 - numFouls[i] * 3;

      if (stars[i] > 40)
      {
        starPlayers++;
      }
    }

    System.out.print(starPlayers);

    if (starPlayers == numPlayers)
    {
      System.out.print("+");
    }
  }
}