import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

   int k = Integer.parseInt(input.nextLine());
    int m = Integer.parseInt(input.nextLine());

    ArrayList<Integer> friends = new ArrayList<Integer>();

    for (int i = 0; i < k; i++)
    {
      friends.add(i + 1);
    }

    ArrayList<Integer> newFriends = new ArrayList<Integer>();

    int [] r = new int[m];

    for (int i = 0; i < m; i++)
    {
      r[i] = Integer.parseInt(input.nextLine());
    }
    
    for (int round = 0; round < m; round++)
    {
      for (int i = 0; i < friends.size(); i++)
      {
        if ((i + 1) % r[round] != 0)
        {
          newFriends.add(friends.get(i));
        }        
      }
      
      friends = new ArrayList();

      for (int f = 0; f < newFriends.size(); f++)
      {
        friends.add(newFriends.get(f));
      }
      
      newFriends = new ArrayList();
    }  
    
    for (int j = 0; j < friends.size(); j++)
    {
      System.out.println(friends.get(j));
    }
  }
}