import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int small = Integer.parseInt(input.nextLine());
    int medium = Integer.parseInt(input.nextLine());
    int large = Integer.parseInt(input.nextLine());
    
    int happiness = small + 2 * medium + 3 * large;

    if (happiness >= 10)
    {
      System.out.println("happy");
    }
    else
    {
      System.out.println("sad");
    }
  }
}