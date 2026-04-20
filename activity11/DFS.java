// Noah Thompson
// 20 April 2026
// DFS.java
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public List<String> traverse(String root, Map<String,List<String>> graph){

        // create the stack
        Stack<String> toVisit = new Stack<>();
        toVisit.add(root);

        // track output
        List<String> output = new ArrayList<>();

        // visited nodes
        Set<String> visited = new HashSet<>();

        while(!toVisit.isEmpty()){
            String node = toVisit.pop();
            // checking if node not visited already
            if(!visited.contains(node)){
                output.add(node);

                // marking as visited
                visited.add(node);

                // iterating over node children and adding to queue
                List<String> children = graph.get(node);
                for (int i = children.size() - 1; i>=0; i--){
                    toVisit.add(children.get(i));
                }
            }
        }
    
        return output;
    
    }
    
    public static void main(String[] args){
        DFS out = new DFS();
        DFS out1 = new DFS();
        DFS out2 = new DFS();

        String root = "a";
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", Arrays.asList("b", "e"));
        graph.put("b", Arrays.asList("c", "d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("b"));
        graph.put("e", Arrays.asList("a", "f"));
        graph.put("f", Arrays.asList());
        System.out.println(out.traverse(root, graph));


        Map<String, List<String>> graph1 = new HashMap<>();
        graph1.put("a", Arrays.asList("b"));
        graph1.put("b", Arrays.asList("c", "d"));
        graph1.put("c", new ArrayList<>());
        graph1.put("d", new ArrayList<>());
        System.out.println(out1.traverse(root, graph1));

        String root2 = "b";
        Map<String, List<String>> graph3 = new HashMap<>();
        graph3.put("a", Arrays.asList("b"));
        graph3.put("b", Arrays.asList("a"));
        System.out.println(out2.traverse(root2, graph3));
    }
}
