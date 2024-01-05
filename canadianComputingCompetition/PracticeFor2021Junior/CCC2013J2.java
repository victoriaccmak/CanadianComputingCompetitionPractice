import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main 
{
  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = br.readLine();

    if (word.contains("A") || word.contains("B") || word.contains("C") || word.contains("D") || word.contains("E") || word.contains("F") || word.contains("G") || word.contains("J") || word.contains("K") || word.contains("L") || word.contains("M") || word.contains("P") || word.contains("Q") || word.contains("R") || word.contains("T") || word.contains("U") || word.contains("V") || word.contains("W") || word.contains("Y"))
    {
      System.out.println("NO");
    }
    else
    {
      System.out.println("YES");
    }
  }
}