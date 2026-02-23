// Noah Thompson
// 23 February 2026
// question1.js

// fibonacci generator function returning fibonacci number each time sequence is invoked
function fibonacci(){
    let steps = [] // gonna store the sequence so we know previous two states

    return () => {
        let length = steps.length;
        // if nothing generated yet, push 0 and return it
        if (length == 0){
            steps.push(0);
            return 0;
        }
        else if (length == 1){
            // other wise if length is only 1, push 1
            steps.push(1);
            return 1;
        }
        // once i have first two states, the rest works fine!
        let f_curr = steps[length-1] + steps[length-2];
        steps.push(f_curr);
        length = length + 1;
        return f_curr;
    }
}

// get output (from homework4 document)
let fibGenerator1 = fibonacci(); // fibonacci() returns a closure
let fibGenerator2 = fibonacci(); // fibonacci() returns a closure

console.log(fibGenerator1()); // prints 0, i.e., F(0) = 0
console.log(fibGenerator1()); // prints 1, i.e., F(1) = 1
console.log(fibGenerator1()); // prints 1, i.e., F(2) = 1
console.log(fibGenerator1()); // prints 2, i.e., F(3) = 2
console.log(fibGenerator1()); // prints 3, i.e., F(4) = 3
console.log("\n"); // space so i can see seperation

console.log(fibGenerator2()); // prints 0, i.e., F(0)
console.log(fibGenerator2()); // prints 1, i.e., F(1)
console.log(fibGenerator2()); // prints 1, i.e., F(2)
console.log(fibGenerator2()); // prints 2, i.e., F(3)
console.log(fibGenerator2()); // prints 3, i.e., F(4)