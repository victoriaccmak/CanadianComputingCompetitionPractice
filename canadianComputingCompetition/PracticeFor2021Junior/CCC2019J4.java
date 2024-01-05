import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numH = 0;
    int numV = 0;
      
    String flips = input.nextLine();

    for (int i = 0; i < flips.length(); i++)
    {
      switch (flips.charAt(i))
      {
        case 'H':
          numH++;
          break;
        case 'V':
          numV++;
          break;
      }
    }

    if (numH % 2 == 1)
    {
      if (numV % 2 == 0)
      {
        System.out.println("3 4\n1 2");
      }
      else
      {
        System.out.println("4 3\n2 1");
      }
    }
    else if (numH % 2 == 0 && numV % 2 == 1)
    {
      System.out.println("2 1\n4 3");
    }
    else
    {
      System.out.println("1 2\n3 4");
    }
  }
}