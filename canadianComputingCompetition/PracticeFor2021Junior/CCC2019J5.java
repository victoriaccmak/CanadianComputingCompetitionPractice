import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Word
{
  int startingPos;
  StringBuilder string;
  int methodUsed;
  Word parent;

  Word(StringBuilder string, int methodUsed, int startingPos)
  {
    this.string = string;
    this.methodUsed = methodUsed;
    this.startingPos = startingPos;
  }
}

class Replacement
{
  int value;
  String first;
  String last;
  int firstLength;

  Replacement(int value, String first, String last)
  {
    this.value = value;
    this.first = first;
    this.last = last;
    firstLength = first.length();
  }   
}

class Main 
{
  static Map<Integer, Replacement> rules = new HashMap<Integer, Replacement>();
  static Map<Integer, Word> words = new HashMap<Integer, Word>();
  static String fin;
  static int steps;

  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder init = new StringBuilder();

    for (int i = 0; i < 3; i++)
    {
      String in = br.readLine();
      Replacement rplc = new Replacement(i + 1, in.substring(0, in.indexOf(" ")), in.substring(in.indexOf(" ") + 1));
      rules.put(i + 1, rplc);
    }

    String in = br.readLine();
    steps = Integer.parseInt(in.substring(0, in.indexOf(" ")));
    in = in.substring(in.indexOf(" ") + 1);
    init.append(in.substring(0, in.indexOf(" ")));
    fin = in.substring(in.indexOf(" ") + 1);
    
    ArrayList<Word> words = new ArrayList<Word>();
    words.add(new Word(init, 0, 0));

    for (int level = 1; level <= steps; level++)
    {
      words = FindNextChildren(words, level);
    }
  }

  private static ArrayList<Word> FindNextChildren(ArrayList<Word> words, int level)
  {
    ArrayList<Word> nextChildren = new ArrayList<Word>();

    for (Word word : words)
    {
      rules.forEach((k, v) -> 
      {
        String temp = word.string.toString();

        if (temp.contains(v.first))
        {
          int lastIndexToCheck = word.string.length() - v.firstLength;
          
          for (int j = 0; j <= lastIndexToCheck; j++)
          {
            if (temp.substring(j, j + v.firstLength).equals(v.first))
            {
              Word w = new Word(word.string.replace(j, j + v.firstLength, v.last), k, j + 1);
              nextChildren.add(w);
              word.string = new StringBuilder().append(temp);
              w.parent = word;

              if (level == steps && w.string.toString().equals(fin))
              {
                ArrayList<Word> lastList = new ArrayList<Word>();
                lastList = CompileSteps(w, lastList, steps);
                Collections.reverse(lastList);

                lastList.forEach(a ->
                {
                  System.out.println(a.methodUsed + " " + a.startingPos + " " + a.string.toString());
                });

                System.exit(0);
              }
            }
          }
        }
      });
    }

    return nextChildren;
  }

  private static ArrayList<Word> CompileSteps(Word w, ArrayList<Word> lastList, int s)
  {
    if (s == 0)
    {
      return lastList;
    }
    lastList.add(w);
    s--;
    return CompileSteps(w.parent, lastList, s);
  }
}