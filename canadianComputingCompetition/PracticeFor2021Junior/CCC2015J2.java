import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String statement = input.nextLine();
    String newStatement;
    int numHappy = 0;
    int numSad = 0;
    String emotion = "";
    
    if (statement.contains(":-)"))
    {
      newStatement = statement;

      while (newStatement.contains(":-)") == true)
      {
        numHappy++;
        newStatement = newStatement.substring(newStatement.indexOf(":-)") + 3);
      }
    }

    if (statement.contains(":-("))
    {
      newStatement = statement;

      while (newStatement.contains(":-(") == true)
      {
        numSad++;
        newStatement = newStatement.substring(newStatement.indexOf(":-(") + 3);
      }
    }

    if (numHappy > numSad)
    {
      emotion = "happy";
    }
    else if (numSad > numHappy)
    {
      emotion = "sad";
    }
    else if (statement.contains(":-)") == false && statement.contains(":-(") == false)
    {
      emotion = "none";
    }
    else
    {
      emotion = "unsure";
    }

    System.out.println(emotion);
  }
}