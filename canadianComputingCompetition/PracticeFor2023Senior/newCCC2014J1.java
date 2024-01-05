import java.util.Scanner;

class Main 
{
  static int ANGLE_SUM_IN_TRIANGLE = 180;
  
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    
    int [] angles = new int[3];
    int sum = 0;

    for (int i = 0; i < angles.length; i++)
    {
      angles[i] = Integer.parseInt(input.nextLine());

      sum += angles[i];
    }

    if (sum == ANGLE_SUM_IN_TRIANGLE)
    {
      if (angles[0] == 60 && angles[1] == 60 && angles[2] == 60)
      {
        System.out.println("Equilateral");
      }
      else if (angles[0] == angles[1] || angles[0] == angles[2] || angles[1] == angles[2])
      {
        System.out.println("Isosceles");
      }
      else
      {
        System.out.println("Scalene");
      }
    }
    else
    {
      System.out.println("Error");
    }
  }
}