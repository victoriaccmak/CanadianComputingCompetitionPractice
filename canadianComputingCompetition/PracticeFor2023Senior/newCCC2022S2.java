import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    String restraint;
    String stu1;
    String stu2;
    ArrayList<String> students = new ArrayList<String>();
    int infractions = 0;
    Iterator it;
    
    int numTogRestraints = Integer.parseInt(input.nextLine());
    HashMap <String, HashSet<String>> togRestraints = new HashMap <String, HashSet<String>>();
    HashMap <String, HashSet<String>> apartRestraints = new HashMap <String, HashSet<String>>();

    for (int i = 0; i < numTogRestraints; i++)
    {
      restraint = input.nextLine();
      stu1 = restraint.substring(0, restraint.indexOf(" "));
      stu2 = restraint.substring(restraint.indexOf(" ") + 1);
      
      if (stu1.compareTo(stu2) > 0)
      {
        if (togRestraints.containsKey(stu1))
        {
          togRestraints.get(stu1).add(stu2);
        }
        else
        {
          HashSet<String> pair = new HashSet<String>();
          pair.add(stu2);
          togRestraints.put(stu1, pair);
        }
      }
      else
      {
        if (togRestraints.containsKey(stu2))
        {
          togRestraints.get(stu2).add(stu1);
        }
        else
        {
          HashSet<String> pair = new HashSet<String>();
          pair.add(stu1);
          togRestraints.put(stu2, pair);
        }
      }
    }

    //System.out.println(togRestraints);
    
    int numApRes = Integer.parseInt(input.nextLine());

    for (int i = 0; i < numApRes; i++)
    {
      restraint = input.nextLine();
      stu1 = restraint.substring(0, restraint.indexOf(" "));
      stu2 = restraint.substring(restraint.indexOf(" ") + 1);
      
      if (stu1.compareTo(stu2) > 0)
      {
        if (apartRestraints.containsKey(stu1))
        {
          apartRestraints.get(stu1).add(stu2);
        }
        else
        {
          HashSet<String> pair = new HashSet<String>();
          pair.add(stu2);
          apartRestraints.put(stu1, pair);
        }
      }
      else
      {
        if (apartRestraints.containsKey(stu2))
        {
          apartRestraints.get(stu2).add(stu1);
        }
        else
        {
          HashSet<String> pair = new HashSet<String>();
          pair.add(stu1);
          apartRestraints.put(stu2, pair);
        }
      }
    }

    //System.out.println(apartRestraints);
    
    int numLines = Integer.parseInt(input.nextLine());

    for (int i = 0; i < numLines; i++)
    {
      restraint = input.nextLine();
      students = new ArrayList<>(Arrays.asList(restraint.split(" ")));
      
      //Check together
      for (int j = 0; j < 3; j++)
      {
        if (togRestraints.containsKey(students.get(j)))
        {
          it = togRestraints.get(students.get(j)).iterator();
          //System.out.println(togRestraints.get(students.get(j)));
          //System.out.println(students);

          while (it.hasNext())
          {
            if (!students.contains(it.next()))
            {              
              //System.out.println(students.get(j));
              infractions++;
            }
          }
        }

        if (apartRestraints.containsKey(students.get(j)))
        {
          it = apartRestraints.get(students.get(j)).iterator();

          while (it.hasNext())
          {
            if (students.contains(it.next()))
            {
              //System.out.println(" " + students.get(j));
              infractions++;
            }
          }
        }
      }
    }

    System.out.println(infractions);
  }
}