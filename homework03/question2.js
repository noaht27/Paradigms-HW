// Noah Thompson
// 23 February 2026
// question2.js

// "operation checking whether current state is the desired one" from hw3 hints
function isGoal(state, amount){
    return (state.filter(element => element === amount).length === 1 && 
        state.filter(element => element === 0).length === state.length - 1);
}

//operation performing permutations among bottles (make empty, full, pour)
function statesForBFS(state, bottles){
    let nextState = []; // i used this to keep track of all possible next states just like from hw3 hints 
    let numBottles = state.length;

    for (let i = 0; i < numBottles; i++){
        // fill bottle if not full, fill to top add to nextState
        if (state[i] < bottles[i]) {
            let newState = state.slice();
            newState[i] = bottles[i];
            nextState.push(newState);
        }

        // empty a bottle
        if (state[i] > 0){
            let newState = state.slice();
            newState[i] = 0;
            nextState.push(newState);
        }

        // make a pour
        for (let j = 0; j < numBottles; j++){
            // cant pour into same bottle, cant pour nothing and cant pour into something greater
            if (i !==j && state[i] > 0 && state[j] < bottles[j]){
                let newState = state.slice();
                let space = bottles[j] - state[j]; // space left
                if (state[i] < space){
                    var amount = state[i]; // getting amount to pour
                }
                else {
                    var amount = space;
                }
                newState[i] -= amount; // pouring out
                newState[j] += amount; // pouring into other state
                nextState.push(newState);
            }
        }
    }
    return nextState;
}

// Search which tracks the path, came from hw3 hints
function bfsWithPathTracking(rootState, amount, bottles) {
    let queue = [ [[], rootState] ];  // queue has both the initial state and an empty path history
    let visited = new Set() ;         // tracks visited nodes

    while (queue.length > 0) {
        let currentArray = queue.shift();
        let currentState = currentArray[1]; // gets current state
        let currentPath = currentArray[0].concat([currentState]); // this tracking history

        if (!visited.has(currentState.toString())) {
            visited.add(currentState.toString()); // mark state as visited
            // checking here if we reached goal, one bottle has correct amount and rest MUST be empty
            if (isGoal(currentState, amount)){
                return currentPath;
            }
            var nextStates = statesForBFS(currentState, bottles);
            nextStates.forEach(x => {
                if (!visited.has(x.toString())) {
                queue.push([currentPath, x]);
                }
            });
        }
    }
    return null; // if queue is empty and no solution return null
}

// constraints safely assume: 2 <= bottle.length <= 1000, bottles[i] > 0 and amount >= 0
function solve(amount, bottles) {
    num_bottles = bottles.length;
    // quick filter, if none of the bottles can hold the amount return null
    array2 = bottles.filter((n) => n >= amount);
    if (array2.length == 0 || amount == 0){
        return null;
    }

    initial_state = []
    // each bottle  begins empty
    for (let i = 0; i < num_bottles; i++){
        initial_state.push(0);
    }
    return bfsWithPathTracking(initial_state, amount, bottles)
}

// Examples from hw3 document
console.log(solve(2, [5,3]));
console.log(solve(1, [2,4]));
console.log(solve(8, [10, 2, 1]));
console.log(solve(8, [3, 4, 2, 1]));