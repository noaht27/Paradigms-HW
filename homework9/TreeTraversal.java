// Noah Thompson
// 21 April 2026
// TreeTraversal.java

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
import java.util.Collections; //https://www.geeksforgeeks.org/java/collections-reverse-method-in-java-with-examples/
// found this for reversing an array in java!

public class TreeTraversal {
    // this is an instance method, doesnt exist until an object or instance of it is created
    public List<String> traverse(String root, Map<String,List<String>> tree){
        List<String> output = new ArrayList<>();

        // going to track level to know direction of arrow for traversal
        int level = 1;

        // i decided to use a queue for this
        Queue<String> toVisit = new LinkedList<>();
        toVisit.add(root);

        // while queue has items
        while(!toVisit.isEmpty()) {
            // number of items in queue
            int num_items = toVisit.size();
            List<String> curr_level = new ArrayList<>();

            while (num_items > 0) {
                String node = toVisit.remove();
                curr_level.add(node);
                num_items -= 1;
                
                List<String> children = tree.get(node);
                for (String child : children) {
                    toVisit.add(child);
                }
            }
        // even level we dont change order
        if (level % 2 == 0){
            output.addAll(curr_level);
        }
        // odd level we need to reverse order based on picture
        else if (level % 2 == 1){
            Collections.reverse(curr_level); // looked this one up i supplied link above
            output.addAll(curr_level);
        }
        level += 1;
        }

        // returning visited nodes
        return output;
    }    

    public static void main(String[] args){
        // creating an object of tree traversal
        TreeTraversal out = new TreeTraversal();
        

        // example output 1
        String root1 = "a";
        Map<String, List<String>> tree = new HashMap<>();
        tree.put("a", Arrays.asList("b", "c"));
        tree.put("b", Arrays.asList());
        tree.put("c", Arrays.asList("d", "e"));
        tree.put("d", Arrays.asList());
        tree.put("e", Arrays.asList());
        System.out.println(out.traverse(root1, tree));

        // example output 2
        String root2 = "A";
        Map<String, List<String>> tree2 = new HashMap<>();
        tree2.put("A", Arrays.asList("B", "C"));
        tree2.put("B", Arrays.asList("D", "E"));
        tree2.put("C", Arrays.asList("F", "G"));
        tree2.put("D", Arrays.asList());
        tree2.put("E", Arrays.asList());
        tree2.put("F", Arrays.asList());
        tree2.put("G", Arrays.asList());
        System.out.println(out.traverse(root2, tree2));
    }
}
