import java.util.Scanner;

class Main 
{
  static int MONTH = 2;
  static int DAY = 18;
  
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int month = Integer.parseInt(input.nextLine());
    int day = Integer.parseInt(input.nextLine());

    String status = "";
    
    if (month > MONTH)
    {
      status = "After";
    }
    else if (month < MONTH)
    {
      status = "Before";
    }
    else
    {
      if (day > DAY)
      {
        status = "After";
      }
      else if (day < DAY)
      {
        status = "Before";
      }
      else
      {
        status = "Special";
      }
    }

    System.out.println(status);
  }
}