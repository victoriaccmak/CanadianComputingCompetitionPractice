import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int n = Integer.parseInt(input.nextLine());
    int aPoints = 100;
    int dPoints = 100;

    int aRoll;
    int dRoll;

    for (int i = 0; i < n; i++)
    {
      String round = input.nextLine();
      
      aRoll = Character.getNumericValue(round.charAt(0));
      dRoll = Character.getNumericValue(round.charAt(2));

      if (aRoll > dRoll)
      {
        dPoints -= aRoll;
      }
      else if (dRoll > aRoll)
      {
        aPoints -= dRoll;
      }
    }

    System.out.println(aPoints);
    System.out.println(dPoints);
  }
}