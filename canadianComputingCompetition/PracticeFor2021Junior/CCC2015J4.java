import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numEntries = Integer.parseInt(input.nextLine());
    String [] entries = new String[numEntries];
    ArrayList<Integer> friendNums = new ArrayList<Integer>();
    ArrayList<Integer> waitTimes = new ArrayList<Integer>();
    ArrayList<Boolean> isWaiting = new ArrayList<Boolean>();
    boolean isNewFriend = false;
    boolean isAdded = false;

    for (int i = 0; i < numEntries; i++)
    {
      entries[i] = input.nextLine();

      for (int j = 0; j < friendNums.size(); j++)
      {
        if (isWaiting.get(j) == true)
        {
          if (entries[i].charAt(0) != 'W')
          {
            waitTimes.set(j, waitTimes.get(j) + 1);
          }
          else if (entries[i].charAt(0) == 'W')
          {
            waitTimes.set(j, waitTimes.get(j) + Integer.parseInt(entries[i].substring(2)));
          }
        }
      }

      if (entries[i].charAt(0) == 'S')
      {
        for (int j = 0; j < friendNums.size(); j++)
        {
          if (Integer.parseInt(entries[i].substring(2)) == friendNums.get(j))
          {
            isWaiting.set(j, false);
            waitTimes.set(j, waitTimes.get(j) - 1);
          }
        }
      }
      else if (entries[i].charAt(0) == 'R')
      {
        for (int j = 0; j < friendNums.size(); j++)
        {
          if (Integer.parseInt(entries[i].substring(2)) != friendNums.get(j))
          {
            isNewFriend = true;
            isAdded = false;
          }
        }

        for (int j = 0; j < friendNums.size() && isAdded == false; j++)
        {
          if (Integer.parseInt(entries[i].substring(2)) == friendNums.get(j))
          {
            isWaiting.set(j, true);
            isNewFriend = false;
            isAdded = true;
          }
        }
      }
      
      if (i == 0 && entries[i].charAt(0) == 'R')
      {
        friendNums.add(Integer.parseInt(entries[i].substring(2)));
        waitTimes.add(0);
        isWaiting.add(true);
      }
      
      if (isNewFriend == true)
      {
        for (int j = 0; j < friendNums.size() && isAdded == false; j++)
        {
          if (Integer.parseInt(entries[i].substring(2)) < friendNums.get(j))
          {
            friendNums.add(j, Integer.parseInt(entries[i].substring(2)));
            waitTimes.add(j, 0);
            isWaiting.add(j, true);
            isAdded = true;
            isNewFriend = false;
          }
          else if (Integer.parseInt(entries[i].substring(2)) > friendNums.get(j))
          {
            if (j + 1 < friendNums.size() && Integer.parseInt(entries[i].substring(2)) < friendNums.get(j + 1))
            {
              friendNums.add(j + 1, Integer.parseInt(entries[i].substring(2)));
              waitTimes.add(j + 1, 0);
              isWaiting.add(j + 1, true);
              isAdded = true;
              isNewFriend = false;
            }
            else if (j == friendNums.size() - 1)
            {
              friendNums.add(Integer.parseInt(entries[i].substring(2)));
              waitTimes.add(0);
              isWaiting.add(true);
              isAdded = true;
              isNewFriend = false;
            }
          }
        }
      }

      isNewFriend = false;
      isAdded = true;
    }

    for (int i = 0; i < friendNums.size(); i++)
    {
      if (isWaiting.get(i) == true)
      {
        waitTimes.set(i, -1);
      }

      System.out.println(friendNums.get(i) + " " + (waitTimes.get(i)));
    }
  }
}