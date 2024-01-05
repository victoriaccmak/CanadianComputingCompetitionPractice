import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numSpaces = Integer.parseInt(input.nextLine());

    String yesterday = input.nextLine();
    String today = input.nextLine();
    
    int bothOccp = 0;

    for (int i = 0; i < numSpaces; i++)
    {
      if (yesterday.charAt(i) == 'C' && today.charAt(i) == 'C')
      {
        bothOccp++;
      }
    }

    System.out.println(bothOccp);
  }
}