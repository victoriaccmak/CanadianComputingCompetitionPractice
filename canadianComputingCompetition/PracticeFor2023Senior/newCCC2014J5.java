import java.util.Scanner;
import java.util.HashMap;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String status = "good";
    
    int N = Integer.parseInt(input.nextLine());

    String allPeople = input.nextLine();
    String [] people1 = allPeople.split(" ", N);

    allPeople = input.nextLine();
    String [] people2 = allPeople.split(" ", N);
    
    HashMap <String, String> partners = new HashMap<String, String>();

    for (int i = 0; i < N; i++)
    {
      if (people1[i].equals(people2[i]))
      {
        status = "bad";
        break;
      }
      else if (!partners.containsKey(people2[i]))
      {
        partners.put(people1[i], people2[i]);
      }
      else if (!partners.get(people2[i]).equals(people1[i]))
      {
        status = "bad";
        break;
      }
    }

    System.out.println(status);
  }
}