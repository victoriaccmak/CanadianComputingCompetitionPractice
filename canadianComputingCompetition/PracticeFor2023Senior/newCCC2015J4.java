import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int M = Integer.parseInt(input.nextLine());
    String [] events = new String[M];
    ArrayList<Integer> friends = new ArrayList<Integer>();
    ArrayList<Boolean> isWaiting = new ArrayList<Boolean>();
    ArrayList<Integer> waitTimes = new ArrayList<Integer>();    

    for (int i = 0; i < M; i++)
    {
      events[i] = input.nextLine();

      if (events[i].charAt(0) == 'R')
      {
        for (int j = 0; j < friends.size(); j++)
        {
          if (isWaiting.get(j))
          {
            waitTimes.set(j, waitTimes.get(j) + 1);
          }
        }
        
        if (!friends.contains(Integer.parseInt(events[i].substring(2))))
        {
          if (friends.isEmpty())
          {
            friends.add(Integer.parseInt(events[i].substring(2)));
            isWaiting.add(true);
            waitTimes.add(0);
          }
          else
          {
            for (int j = 0; j < friends.size(); j++)
            {
              if (Integer.parseInt(events[i].substring(2)) < friends.get(j))
              {
                friends.add(j, Integer.parseInt(events[i].substring(2)));
                isWaiting.add(j, true);
                waitTimes.add(j, 0);
                break;
              }
              else if (j == friends.size() - 1)
              {
                friends.add(Integer.parseInt(events[i].substring(2)));
                isWaiting.add(true);
                waitTimes.add(0);
                break;
              }
            }
          }
        }
        else
        {
          isWaiting.set(friends.indexOf(Integer.parseInt(events[i].substring(2))), true);
        }
      }
      else if (events[i].charAt(0) == 'S')
      {
        for (int j = 0; j < friends.size(); j++)
        {
          if (isWaiting.get(j))
          {
            waitTimes.set(j, waitTimes.get(j) + 1);
          }
        }
        
        isWaiting.set(friends.indexOf(Integer.parseInt(events[i].substring(2))), false);
      }
      else
      {
        for (int j = 0; j < friends.size(); j++)
        {
          if (isWaiting.get(j))
          {
            waitTimes.set(j, waitTimes.get(j) + Integer.parseInt(events[i].substring(2)) - 1);
          }
        }
      }
    }
    
    for (int i = 0; i < friends.size(); i++)
    {
      if (isWaiting.get(i))
      {
        waitTimes.set(i, -1);
      }

      System.out.println(friends.get(i) + " " + waitTimes.get(i));
    }
  }
}