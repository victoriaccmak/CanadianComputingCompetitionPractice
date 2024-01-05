import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int num20s = 0;
    int ways = 0;
    int remainder;
    
    int sum = Integer.parseInt(input.nextLine());

    num20s = sum / 20;
    //ways += num20s + 1;

    //remainder = sum % num20s;

    for (int i = 0; i <= sum / 4; i++)
    {
      if ((sum - (4 * i)) % 5 == 0)
      {
        ways++;
      }
    }

    System.out.println(ways);
  }
}