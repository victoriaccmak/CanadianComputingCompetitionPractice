import java.util.Scanner;

class Main {
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int piecesOfPie = Integer.parseInt(input.nextLine());
    int numOfPpl = Integer.parseInt(input.nextLine());
    int [] piePerPerson = new int[numOfPpl];
    int ways = 1;

    

    if (numOfPpl == 1 || piecesOfPie == numOfPpl)
    {
      System.out.println(ways);
    }
    else
    {
      for (int i = 0; i < numOfPpl - 1; i++)
      {
        piePerPerson[i] = 1;
      }

      piePerPerson[numOfPpl - 1] = piecesOfPie - numOfPpl + 1;

      RedistributePie(piecesOfPie, numOfPpl, ways, piePerPerson);
    }
  }

  private static void RedistributePie(int piecesOfPie, int numOfPpl, int ways, int [] piePerPerson)
  {
    boolean isAdded = false;
    int subtractingIndex = 0;
    boolean gotSubIndex = false;

    if (piePerPerson[numOfPpl - 1] <= piePerPerson[0] + 1)
    {
      System.out.println(ways);
    }
    else
    {
      if (piePerPerson[numOfPpl - 1] > piePerPerson[0] + 1)
      {
        for (int i = numOfPpl - 1; i >= 1 && gotSubIndex == false; i--)
        {
          //subtractingIndex has to be greater than the previous at any amount, but greater or equal to the increasing index + 1. 
          if (piePerPerson[i] > piePerPerson[i - 1])
          {
            for (int j = numOfPpl - 2; j >= 0 && isAdded == false; j--)
            {
              if (piePerPerson[i] > piePerPerson[j] + 1)
              {
                subtractingIndex = i;
                gotSubIndex = true;
                piePerPerson[subtractingIndex] -= 1;
                piePerPerson[j]++;
                isAdded = true;
                ways++;
              }
            }
          }
        }

        RedistributePie(piecesOfPie, numOfPpl, ways, piePerPerson); 
      }
    }
  }
}