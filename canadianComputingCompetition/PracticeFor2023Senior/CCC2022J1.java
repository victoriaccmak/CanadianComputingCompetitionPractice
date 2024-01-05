import java.util.Scanner;

class Main 
{
  static int CUPCAKES_IN_LARGE = 8;
  static int CUPCAKES_IN_SMALL = 3;
  static int STUDENTS = 28;
  
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int largeBox = Integer.parseInt(input.nextLine());
    int smallBox = Integer.parseInt(input.nextLine());

    int totalCakes = largeBox * CUPCAKES_IN_LARGE + smallBox * CUPCAKES_IN_SMALL;
    int leftover = totalCakes - STUDENTS;

    System.out.println(leftover);
  }
}