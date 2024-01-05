import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int month = Integer.parseInt(input.nextLine());
    int day = Integer.parseInt(input.nextLine());
    String status = "";

    if (month == 2 && day == 18)
    {
      status = "Special";
    }
    else if ((month == 2 && day < 18) || month < 2)
    {
      status = "Before";
    }
    else if ((month == 2 && day > 18) || month > 2)
    {
      status = "After";
    }

    System.out.println(status);
  }
}