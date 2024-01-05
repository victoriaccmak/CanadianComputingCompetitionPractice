import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numPages = Integer.parseInt(input.nextLine());
    String [] inputs = new String[numPages];
    int [] numChoices = new int[numPages];
    ArrayList<Integer>[] choices = new ArrayList[numPages];
    boolean [] visited = new boolean[numPages];
    int pageNum = 1;
    String allPageVisited = "Y";
    int shortestPath = 0;
    boolean finished = false;

    for (int i = 0; i < numPages; i++)
    {
      inputs[i] = input.nextLine();

      //Create the new arraylist for the choices
      choices[i] = new ArrayList<Integer>();
      
      //Determine number of choices
      if (inputs[i].charAt(0) == '0')
      {
        numChoices[i] = 0;
      }
      else
      {
        //Set the number of choices
        numChoices[i] = Integer.parseInt(inputs[i].substring(0, inputs[i].indexOf(" ")));

        //Remove the number of choices from the input line and split the input line into choices
        inputs[i] = inputs[i].substring(inputs[i].indexOf(" ") + 1);
        String [] inputChoices = inputs[i].split(" ");

        for (int j = 0; j < numChoices[i]; j++)
        {
          choices[i].add(Integer.parseInt(inputChoices[j]));
        }
      }
      //System.out.println(i + ": " + choices[i]);
    }

    //Fill the visited all with false except the first page
    Arrays.fill(visited, false);
    visited[0] = true;

    //Determine if each page is reachable
    first:
    for (int i = 1; i < numPages; i++)
    {
      //System.out.println("i + 1: " + (i + 1));
      //Search the choices in each page
      second:
      for (int j = 0; j < numPages; j++)
      {
        //System.out.println(choices[j]);

        if (choices[j].contains(i + 1))
        {
          visited[i] = true;
          break second;
        }
        else if (j == numPages - 1)
        {
          allPageVisited = "N";
          break first;
        }
      }
      //System.out.println(visited[i]);
    }
    System.out.println(allPageVisited);

    //Figure out the shortest path with BFS
    Arrays.fill(visited, false);
    visited[0] = true;

    Queue<Integer> adjacent = new LinkedList<Integer>();
    Queue<Integer> children = new LinkedList<Integer>();
    
    //Add the choices from the first page
    for (int i = 0; i < choices[0].size(); i++)
    {
      adjacent.add(choices[0].get(i));
      visited[choices[0].get(i) - 1] = true;
    }

    //Check if the first page is the end
    if (numChoices[0] == 0)
    {
      finished = true;
    }

    //System.out.println("Adjacent: " + adjacent);
    //System.out.println("Shortest Path: " + shortestPath);

    //System.out.println("Am I finished: " + finished);

    one:
    while (finished == false)
    {
      shortestPath++;
      //System.out.println("Shortest Path: " + shortestPath);
      //System.out.println("Visited: " + Arrays.toString(visited));
      //System.out.println("Finished? " + finished);

      two:
      while (adjacent.size() > 0)
      {
        //System.out.println("Head page: " + adjacent.element());
        if (numChoices[adjacent.element() - 1] == 0)
        {
          shortestPath++;
          System.out.println(shortestPath);
          finished = true;
          break one;
        }
        else
        {
          //System.out.println("What are its choices?" + choices[adjacent.element() - 1]);

          for (int j = 0; j < choices[adjacent.element() - 1].size(); j++)
          {
            //System.out.println("j: " + j + ". size of the arraylist at the page: " + choices[adjacent.element() - 1].size());
            //System.out.println(choices[adjacent.element() - 1].get(j));

            //System.out.println(choices[adjacent.element() - 1].get(j) - 1 + ": " +  visited[choices[adjacent.element() - 1].get(j) - 1]);
            if (visited[choices[adjacent.element() - 1].get(j) - 1] == false)
            {
              children.add(choices[adjacent.element() - 1].get(j));
              visited[choices[adjacent.element() - 1].get(j) - 1] = true;
              System.out.println(Arrays.toString(visited));

              if (numChoices[choices[adjacent.element() - 1].get(j) - 1] == 0)
              {
                shortestPath++;
                //System.out.println("Done in " + shortestPath);
                finished = true;
                break one;
              }
            }
          }

          adjacent.poll();
          //System.out.println("Adjacent: " + adjacent);
          //System.out.println("Children: " + children);
          System.out.println(Arrays.toString(visited));
        }
      }

      while (children.size() > 0)
      {
        adjacent.add(children.element());
        children.poll();
      }

      //System.out.println("Adjacent: " + adjacent);
      //System.out.println("Children: " + children);
    }
    
    //System.out.println("Outta that loop!");
  }
}