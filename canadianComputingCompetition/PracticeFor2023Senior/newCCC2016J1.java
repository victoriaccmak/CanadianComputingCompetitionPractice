import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main 
{
  public static void main(String[] args) throws Exception 
  {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);
    int wins = 0;
    
    for (int i = 0; i < 6; i++)
    {
      String outcome = br.readLine();

      if (outcome.equals("W"))
      {
        wins++;
      }
    }
    
    switch (wins)
    {
      case 0:
        System.out.println("-1");
        break;
      case 1:
      case 2:
        System.out.println("3");
        break;
      case 3:
      case 4:
        System.out.println("2");
        break;
      case 5:
      case 6:
        System.out.println("1");
        break;
    }
  }
}