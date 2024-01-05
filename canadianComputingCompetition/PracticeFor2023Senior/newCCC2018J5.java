import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class Node
{
  int pageNum;
  ArrayList<Node> children = new ArrayList<Node>();
  boolean visited = false;
  
  Node (int pageNum)
  {
    this.pageNum = pageNum;
  }

  public void AddChild(Node child)
  {
    children.add(child);
  }
}

class Main 
{
  static int numPages;
  
  static HashMap<Integer, Node> directory = new HashMap<Integer, Node>();
  static ArrayList<Node> visitedPages = new ArrayList<Node>();
  
  public static void main(String[] args) throws Exception
  {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);

    numPages = Integer.parseInt(br.readLine());
    int numOptions;
    String[] options;
    int count = 1;
    
    for (int i = 1; i <= numPages; i++)
    {
      directory.put(i, new Node(i));
    }
    
    for (int i = 0; i < numPages; i++)
    {
      options = br.readLine().split(" ");
      numOptions = Integer.parseInt(options[0]);
      
      for (int j = 0; j < numOptions; j++)
      {
        directory.get(i + 1).AddChild(directory.get(Integer.parseInt(options[j + 1])));
      }
    }

    DetermineIfAllPagesAreReachable(directory.get(1));
    FindShortestPath(directory.get(1), count);
  }

  private static void FindShortestPath(Node page, int count)
  {
    if (page.children.isEmpty())
    {
      System.out.println(count);
      System.exit(0);
    }
    else
    {
      if (!page.visited)
      {
        page.visited = true;
        
        for (Node option : page.children)
        {
          FindShortestPath(option, count + 1);
        }
      }
    }
  }

  private static void DetermineIfAllPagesAreReachable(Node page)
  {
    Queue<Node> pages = new LinkedList<Node>();
    pages.add(page);
    
    while (pages.size() > 0 && visitedPages.size() < numPages)
    {
      if (!pages.element().visited)
      {
        for (Node child : pages.element().children)
        {
          pages.add(child);
        }
        
        pages.element().visited = true;
        visitedPages.add(pages.poll());
      }
    }

    if (visitedPages.size() == numPages)
    {
      System.out.println("Y");
    }
    else
    {
      System.out.println("N");
    }

    for (Node p : visitedPages)
    {
      p.visited = false;
    }
  }
}