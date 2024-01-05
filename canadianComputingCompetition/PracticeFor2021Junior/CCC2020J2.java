import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int p = Integer.parseInt(input.nextLine());
    int n = Integer.parseInt(input.nextLine());
    int r = Integer.parseInt(input.nextLine());

    int days = 0;
    int infected = n;
    int newlyInfected = n;

    while (infected <= p)
    {
      days++;
      newlyInfected *= r;
      infected += newlyInfected;
    }

    System.out.println(days);
  }
}