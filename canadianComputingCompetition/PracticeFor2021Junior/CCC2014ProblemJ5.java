import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

   int numStudents = Integer.parseInt(input.nextLine());
    String allNames = input.nextLine();
    String allNames2 = input.nextLine();

    String [] names = new String[numStudents];
    String [] names2 = new String[numStudents];

    String status = "good";

    for (int i = 0; i < numStudents; i++)
    {
      if (allNames.contains(" ") == true)
      {
        names[i] = allNames.substring(0, allNames.indexOf(" "));
        allNames = allNames.substring(allNames.indexOf(" ") + 1, allNames.length());
        
        names2[i] = allNames2.substring(0, allNames2.indexOf(" "));
        allNames2 = allNames2.substring(allNames2.indexOf(" ") + 1, allNames2.length());
      }
      else
      {
        names[i] = allNames;
        names2[i] = allNames2;
      }
    }

    for (int i = 0; i < numStudents; i++)
    {
      if (names[i].equals(names2[i]))
      {
        status = "bad";
      }
      else
      {
        for (int j = 0; j < numStudents; j++)
        {
          if (names[i].equals(names2[j]))
          {
            if (names[j].equals(names2[i]) == false)
            {
              status = "bad";
            }
          }
        }
      }
    }

    System.out.println(status);
  }
}