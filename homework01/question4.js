// Noah Thompson
// 28 January 2026
// question4.js

function reversedSum(num1, num2) {
    // I decided to attack problem using string operations
    // First i convert nums to strings, split them into individual digits, reverse the order, 
    //then rejoin the digits as a whole number (string type though)
    let flipped1 = String(num1).split('').reverse().join("");
    let flipped2 = String(num2).split('').reverse().join("");

    // now add the two flipped strings but must be converted to Number before addition or else wrong
    let value =  Number(flipped1) + Number(flipped2);

    // finally convert back to string, split into an array, reverse the order of array and rejoin to single string
    let final_solution = String(value).split('').reverse().join("");

    return Number(final_solution); // function needs to return a Number

}

// testing inputs
console.log(reversedSum("24", 1));
console.log(reversedSum(4358, "754"));
console.log(reversedSum(305, 794));
console.log(reversedSum("30", 0));