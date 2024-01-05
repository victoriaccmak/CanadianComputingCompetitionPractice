import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numTests = Integer.parseInt(input.nextLine());
    int [] numCars = new int[numTests];
    int [][] carOrders;
    int nextAtMountTop;
    ArrayList<Integer> nextInBranch = new ArrayList<Integer>();
    int nextCar = 1;
    int iteration = 1;
    char [] status = new char[numTests];

    for (int i = 0; i < numTests; i++)
    {
      status[i] = 'Y';
    }  

    for (int i = 0; i < numTests; i++)
    {
      numCars[i] = Integer.parseInt(input.nextLine());

      carOrders = new int[numTests][numCars[i]];

      for (int j = 0; j < numCars[i]; j++)
      {
        carOrders[i][j] = Integer.parseInt(input.nextLine());
      }

      nextAtMountTop = carOrders[i][carOrders[i].length - 1];
      nextCar = 1;
      iteration = 1;
      nextInBranch = new ArrayList<Integer>();

      while (iteration < carOrders[i].length && status[i] == 'Y' && nextCar < numCars[i])
      {
        if (nextCar == nextAtMountTop)
        {
          nextAtMountTop = carOrders[i][carOrders[i].length - 1 - iteration];
          nextCar++;
          iteration++;
        }
        else if (nextInBranch.size() > 0 && nextCar == nextInBranch.get(nextInBranch.size() - 1))
        {
          nextInBranch.remove(nextInBranch.size() - 1);
          nextCar++;
        }
        else
        {
          nextInBranch.add(nextAtMountTop);
          nextAtMountTop = carOrders[i][carOrders[i].length - 1 - iteration];
          iteration++;

          if (nextInBranch.size() >= 2)
          {
            if (nextInBranch.get(nextInBranch.size() - 1) > nextInBranch.get(nextInBranch.size() - 2))
            {
              status[i] = 'N';
            }
          }
        }
      }
    }

    for (int i = 0; i < numTests; i++)
    {
      System.out.println(status[i]);
    }
  }
}