import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main 
{
  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int time = Integer.parseInt(br.readLine());
    int numChoices = Integer.parseInt(br.readLine());
    ArrayList<Integer> choiceTime = new ArrayList<Integer>();
    int choreTime = 0;
    int numChores = 0;

    for (int i = 0; i < numChoices; i++)
    {
      choiceTime.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(choiceTime);

    while (choreTime <= time)
    {
      choreTime += choiceTime.get(0);
      choiceTime.remove(0);
      numChores++;
    }

    System.out.println(numChores - 1);
  }
}