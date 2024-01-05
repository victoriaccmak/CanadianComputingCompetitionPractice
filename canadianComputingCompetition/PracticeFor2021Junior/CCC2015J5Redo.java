import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int n = Integer.parseInt(input.nextLine());
    int m = Integer.parseInt(input.nextLine());

    int ways = CountWays(n, m);
    
    System.out.println(ways);
  }

  private static int CountWays(int n, int m)
  {
    if (n < m || m == 0)
    {
      return 0;
    }
    else if (n == m || m == 1)
    {
      return 1;
    }
    else if (m == 2)
    {
      return n / m;
    }
    else
    {
      return CountWays(n - 1, m - 1) + CountWays(n - m, m);
    }
  }
}