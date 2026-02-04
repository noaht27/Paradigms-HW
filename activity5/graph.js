// Noah Thompson
// 4 February 2026
// graph.js

class Graph {
    
    // constructor declaration (initializing adjacency list)
    constructor(){
        this.adjacencyList = new Map()
    }

    // method to add a Node 'n' to the graph if it doesnt exist yet
    addNode(n) {
        if(!this.adjacencyList.has(n)){
            this.adjacencyList.set(n, []);
        }
    }

    // method to add edge n1 -> n2
    addEdge(n1, n2){
        this.addNode(n1);
        this.addNode(n2);
        this.adjacencyList.get(n1).push(n2);
    }

    // method to traverse the graph in BFS fashion
    bfs(startNode){
        let queue = [];
        queue.push(startNode);

        // node already visisted
        let visited = new Set();

        let result = [] // output that will be returned

        while (queue.length != 0){
            let current = queue.shift();

            if (!visited.has(current)){
                visited.add(current);
                result.push(current);
            }
            //traverse neighbors now
            let neighbor = this.adjacencyList.get(current);
            for (let i = 0; i < neighbor.length; i++){
                queue.push(neighbor[i]);
            }
        }
        return result;
    }

    // method to traverse the graph in DFS fashion
    dfs(startNode){
        let stack = []; // or you can do = new Array()
        stack.push(startNode);
        
        let visited = new Set(); // nodes already visited

        let result = []; // the output that will be returned

        while (stack.length != 0){
            // pop current node from stack
            let current = stack.pop();

            // want nodes not yet visited
            if (!visited.has(current)){
                // push node to output
                result.push(current);

                // add node to visited
                visited.add(current);

                //traverse child nodes now
                let children = this.adjacencyList.get(current);
                for (let i = children.length - 1; i >=0; i--){
                    stack.push(children[i]);
                }
            }
        }
        return result;
    }
}

let g1 = new Graph();
g1.addEdge("+", "*");
g1.addEdge("+", 3);
g1.addEdge("*", 2);
g1.addEdge("*", 7);

console.log(g1.dfs("+"));

let g3 = new Graph();
g3.addEdge("+", "*");
g3.addEdge("+", 3);
g3.addEdge("*", 2);
g3.addEdge("*", 7);

console.log(g3.bfs("+"));

let g2 = new Graph();
g2.addEdge(0, 1);
g2.addEdge(0, 3);
g2.addEdge(1, 2);
g2.addEdge(1, 3);
g2.addEdge(2, 3);
g2.addEdge(2, 1);
g2.addEdge(3, 0);
g2.addEdge(3, 1);

console.log(g2.dfs(0));