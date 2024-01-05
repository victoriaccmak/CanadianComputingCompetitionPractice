import java.util.Scanner;

class Letter
{
  String character;
  String code;

  Letter (String character, String code) 
  {
    this.character = character;
    this.code = code;
  }
}
class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int k = Integer.parseInt(input.nextLine());
    Letter[] letters = new Letter[k];
    String decoded = "";

    for (int i = 0; i < k; i++)
    {
      String line = input.nextLine();
      String[] arrayOfStr = line.split(" ");

      letters[i] = new Letter(arrayOfStr[0], arrayOfStr[1]);
    }

    String codedMsg = input.nextLine();

    first:
    while (codedMsg.length() > 0)
    {
      second:
      for (int i = 0; i < k; i++)
      {
        String checker = codedMsg.substring(0, letters[i].code.length());

        if (checker.equals(letters[i].code))
        {
          codedMsg = codedMsg.substring(letters[i].code.length(), codedMsg.length());
          decoded = decoded + letters[i].character;
          i = -1;

          if (codedMsg.length() == 0)
          {
            break first;
          }
        }
      }
    }
    System.out.println(decoded);
  }
}