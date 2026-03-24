#!/usr/bin/env python3
# Noah Thompson
# 16 March 2026
# question2.py

# given, node class
class Node:
	def __init__(self, value, left, right):
		self.value = value
		self.left = left
		self.right = right
	
	def __str__(self):
		return self.value
	
def traverse(root):
    # what is being returned, the visited nodes
    nodes_visited = []

    # gonna use a queue to track what's been visited
    queue = [root]
    level = 1  # track the level, begins at 1 (top)

    while queue:
        num_nodes = len(queue)  # each level has different number of nodes
        nodes_level = [] # get each node at the level
        while num_nodes > 0:
            node = queue.pop(0)
            nodes_level.append(node.value) # appending top of queue to the level array
            num_nodes -= 1

            # i check because node.left or right can be none
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        # if odd level, its flipped because want to visit from left to right
        if level % 2 == 0:  # even level
            nodes_visited += nodes_level
        elif level % 2 == 1: # odd level needs reversed (visit 1, 2 instead of 2, 1)
            nodes_level.reverse()
            nodes_visited += nodes_level
        level += 1

    return nodes_visited

def main(): 
    # examples from hw5 
    e = Node("E", None, None)
    d = Node("D", None, None)
    c = Node("C", d, e)
    b = Node("B", None, None)
    root = Node("A", b, c)
    for v in traverse(root):
        print(v)
    print("\n")
		
    gg = Node("G", None, None)
    f = Node("F", None, None)
    e = Node("E", None, None)
    d = Node("D", None, None)
    c = Node("C", f, gg)
    b = Node("B", d, e)
    root = Node("A", b, c)
    for v in traverse(root):
        print(v)
    print("\n")
    
    node9 = Node("Node9", None, None)
    node10 = Node("Node10", None, None)
    node7 = Node("Node7", None, None)
    node8 = Node("Node8", node9, node10)
    node5 = Node("Node5", None, None) 
    node6 = Node("Node6", node7, node8)
    node3 = Node("Node3", None, None)  
    node4 = Node("Node4", node5, node6)
    node1 = Node("Node1", node3, node4)
    node2 = Node("Node2", None, None)  
    root = Node("Root", node1, node2)
    for v in traverse(root):
        print(v)
		
if __name__ == "__main__":
    main()