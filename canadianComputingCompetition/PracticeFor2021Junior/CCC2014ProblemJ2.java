import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int votesForA = 0;
    int votesForB = 0;

    int v = Integer.parseInt(input.nextLine());
    String votes = input.nextLine();

    for (int i = 0; i < v; i++)
    {
      if (votes.charAt(i) == 'A')
      {
        votesForA++;
      }
      else
      {
        votesForB++;
      }
    }

    if (votesForA > votesForB)
    {
      System.out.println("A");
    }
    else if (votesForB > votesForA)
    {
      System.out.println("B");
    }
    else
    {
      System.out.println("Tie");
    }
  }
}