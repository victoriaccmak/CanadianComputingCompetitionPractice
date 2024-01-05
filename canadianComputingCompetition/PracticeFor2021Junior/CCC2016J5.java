import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int questionNum = Integer.parseInt(input.nextLine());
    int citizens = Integer.parseInt(input.nextLine());
    String [] lineOfSpeeds = new String[2];
    int [][] speeds = new int[2][citizens];
    boolean isAdded = false;
    int totalSpeed = 0;

    ArrayList<Integer> totalTopSpeeds = new ArrayList<Integer>();
    ArrayList<Integer> slowestSpeeds = new ArrayList<Integer>();
    ArrayList<Integer>[] topSpeeds = new ArrayList[citizens];

    for (int i = 0; i < 2; i++)
    {
      lineOfSpeeds[i] = input.nextLine();

      for (int j = 0; j < citizens; j++)
      {
        if (j < citizens - 1)
        {
          speeds[i][j] = Integer.parseInt(lineOfSpeeds[i].substring(0, lineOfSpeeds[i].indexOf(" ")));
          lineOfSpeeds[i] = lineOfSpeeds[i].substring(lineOfSpeeds[i].indexOf(" ") + 1);
        }
        else
        {
          speeds[i][j] = Integer.parseInt(lineOfSpeeds[i]);
        }
      }
    }

    switch (questionNum)
    {
      case 1:
        for (int i = 0; i < 2; i++)
        {
          topSpeeds[i] = new ArrayList<Integer>();

          for (int j = 0; j < citizens; j++)
          {
            isAdded = false;

            if (j == 0)
            {
              topSpeeds[i].add(speeds[i][j]);
            }
            else
            {
              for (int k = 0; k < topSpeeds[i].size() && isAdded == false; k++)
              {
                if (speeds[i][j] <= topSpeeds[i].get(k))
                {
                  topSpeeds[i].add(k, speeds[i][j]);
                  isAdded = true;
                }
                else if (speeds[i][j] >= topSpeeds[i].get(topSpeeds[i].size() - 1))
                {
                  topSpeeds[i].add(speeds[i][j]);
                  isAdded = true;
                }
              }
            }
          }
        }

        for (int i = 0; i < topSpeeds[0].size(); i++)
        {
          totalSpeed = totalSpeed + Math.max(topSpeeds[0].get(i), topSpeeds[1].get(i)); 
        }

        System.out.println(totalSpeed);
        break;
      case 2:
        for (int i = 0; i < 2; i++)
        {
          for (int j = 0; j < citizens; j++)
          {
            isAdded = false;

            if (i == 0 && j == 0)
            {
              totalTopSpeeds.add(speeds[i][j]);
            }
            else
            {
              for (int k = 0; k < totalTopSpeeds.size() && isAdded == false; k++)
              {
                if (speeds[i][j] >= totalTopSpeeds.get(k))
                {
                  totalTopSpeeds.add(k, speeds[i][j]);
                  isAdded = true;
                }
                else if (speeds[i][j] <= totalTopSpeeds.get(totalTopSpeeds.size() - 1))
                {
                  totalTopSpeeds.add(speeds[i][j]);
                  isAdded = true;
                }
              }
            }
          }
        }
        for (int i = 0; i < totalTopSpeeds.size() / 2; i++)
        {
          totalSpeed = totalSpeed + totalTopSpeeds.get(i);
        }

        System.out.println(totalSpeed);
        break;
    }
  }
}
