import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int startValue = Integer.parseInt(input.nextLine());
    int numOfShifts = Integer.parseInt(input.nextLine());

    int shiftySum = startValue;

    for (int i = 1; i <= numOfShifts; i++)
    {
      shiftySum += startValue * Math.pow(10, i);
    }

    System.out.println(shiftySum);
  }
}