import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    int sum = 0;
    int otherSums = 0;
    String row;
    int [][] numbers = new int[4][];
    String status = "magic";
    
    for (int i = 0; i < 4; i++)
    {
      numbers[i] = new int[4];

      row = input.nextLine();

      for (int j = 0; j < numbers[i].length; j++)
      {
        numbers[i][j] = Integer.parseInt(row.split(" ")[j]);
      }

      for (int j = 0; j < 4; j++)
      {
        if (i == 0)
        {
          sum += numbers[0][j];
        }
        else
        {
          otherSums += numbers[i][j];
        }
      }

      if (i != 0)
      {
        if (otherSums != sum)
        {
          status = "not magic";
        }

        otherSums = 0;
      }
    }

    if (status.equals("magic"))
    {
      first:
      for (int i = 0; i < 4; i++)
      {
        int vertSum = 0;
  
        second:
        for (int j = 0; j < 4; j++)
        {
          vertSum += numbers[j][i];
        }
  
        if (vertSum != sum)
        {
          status = "not magic";
          break first;
        }
      }
    }

    System.out.println(status);
  }
}