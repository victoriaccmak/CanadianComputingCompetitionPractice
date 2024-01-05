import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int angle1 = Integer.parseInt(input.nextLine());
    int angle2 = Integer.parseInt(input.nextLine());
    int angle3 = Integer.parseInt(input.nextLine());

    if (angle1 + angle2 + angle3 != 180)
    {
      System.out.println("Error");
    }
    else if (angle1 == 60 && angle2 == 60 && angle3 == 60)
    {
      System.out.println("Equilateral");
    }
    else if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3)
    {
      System.out.println("Isosceles");
    }
    else
    {
      System.out.println("Scalene");
    }
  }
}