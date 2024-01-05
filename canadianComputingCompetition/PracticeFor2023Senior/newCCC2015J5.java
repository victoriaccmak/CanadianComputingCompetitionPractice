import java.util.Scanner;

class Main 
{
  static int ways = 1;
  static int startIndex;
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    int numSlices = Integer.parseInt(input.nextLine());
    int numPeople = Integer.parseInt(input.nextLine());
    int [] distribution = new int[numPeople];
    startIndex = numPeople - 1;
    
    if (numSlices == numPeople || numPeople == 1)
    {
      System.out.println("1");
    }
    else
    {
      for (int i = 0; i < numPeople - 1; i++)
      {
        distribution[i] = 1;
      }

      distribution[numPeople - 1] = numSlices - numPeople + 1;

      CalcNumSlices(numSlices, numPeople, distribution);
    }
  }

  private static void CalcNumSlices(int numSlices, int numPeople, int [] distribution)
  {
    if (distribution[startIndex] >= distribution[numPeople - 1] - 1)
    {
      if (startIndex == 0)
      {
        System.out.println(ways);
      }
      else
      {
        startIndex--;
        distribution = Redistribute(distribution, numPeople, numSlices);
        CalcNumSlices(numSlices, numPeople, distribution);
      }
    }
    else if (distribution[numPeople - 1] > distribution[startIndex] + 1)
    {
      distribution[numPeople - 1]--;
      distribution[startIndex]++;
      ways++;

      CalcNumSlices(numSlices, numPeople, distribution);
    }
  }

  private static int[] Redistribute(int [] distribution, int numPeople, int numSlices)
  {
    int sum = 0;

    if (distribution[startIndex] < distribution[numPeople - 1] - 1)
    {
      distribution[startIndex]++;
      
      for (int i = startIndex + 1; i < numPeople - 1; i++)
      {
        distribution[i] = distribution[startIndex];
      }
  
      for (int i = 0; i < numPeople - 1; i++)
      {
        sum += distribution[i];
      }
      
      distribution[numPeople - 1] = numSlices - sum;
      
      startIndex = numPeople - 2;
      ways++;
    }

    return distribution;
  }
}