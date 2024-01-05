import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numBids = Integer.parseInt(input.nextLine());
    String [] names = new String[numBids];
    int [] values = new int[numBids];
    String winner;

    for (int i = 0; i < numBids; i++)
    {
      names[i] = input.nextLine();
      values[i] = Integer.parseInt(input.nextLine());
    }

    winner = names[0];
    int winnerValue = values[0];

    for (int i = 1; i < numBids; i++)
    {
      if (values[i] > winnerValue)
      {
        winner = names[i];
        winnerValue = values[i];
      }
    }

    System.out.println(winner);
  }
}