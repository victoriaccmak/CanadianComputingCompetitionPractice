import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int aVotes = 0;
    int bVotes = 0;
    
    int numVotes = Integer.parseInt(input.nextLine());
    String votes = input.nextLine();

    for (int i = 0; i < numVotes; i++)
    {
      if (votes.charAt(i) == 'A')
      {
        aVotes++;
      }
      else
      {
        bVotes++;
      }
    }

    if (aVotes > bVotes)
    {
      System.out.println("A");
    }
    else if (bVotes > aVotes)
    {
      System.out.println("B");
    }
    else
    {
      System.out.println("Tie");
    }
  }
}