import java.util.Scanner;

class Main 
{
  static final int NUM_GAMES = 6;
  static final char WIN = 'W';

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    char [] gameStatuses = new char[NUM_GAMES];
    int numWins = 0;
    int groupNum;

    for (int i = 0; i < NUM_GAMES; i++)
    {
      gameStatuses[i] = input.nextLine().charAt(0);

      if (gameStatuses[i] == WIN)
      {
        numWins++;
      }
    }

    if (numWins >= 5)
    {
      groupNum = 1;
    }
    else if (numWins >= 3)
    {
      groupNum = 2;
    }
    else if (numWins >= 1)
    {
      groupNum = 3;
    }
    else
    {
      groupNum = -1;
    }

    System.out.println(groupNum);
  }
}