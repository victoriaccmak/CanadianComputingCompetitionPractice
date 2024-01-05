import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

   int aRoll;
    int dRoll;
    int aScore = 100;
    int dScore = 100;

    String rolls;

    int n = Integer.parseInt(input.nextLine());
    
    for (int i = 0; i < n; i++)
    {
      rolls = input.nextLine();
      aRoll = Integer.parseInt(rolls.valueOf(rolls.charAt(0)));
      dRoll = Integer.parseInt(rolls.valueOf(rolls.charAt(2)));

      if (aRoll > dRoll)
      {
        dScore = dScore - aRoll;
      }
      else if (dRoll > aRoll)
      {
        aScore = aScore - dRoll;
      }
    }

    System.out.println(aScore);
    System.out.println(dScore); 
  }
}