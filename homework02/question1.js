// Noah Thompson
// 9 February 2026
// question1.js

// users for testing
var users = [
    {id: 1, name: "Marta", height: 1.74, weight: 59}, 
    {id: 2, name: "Josh", height: 1.80, weight: 88},
    {id: 3, name: "Achilles", height: 1.68, weight: 63}, 
    {id: 4, name: "Julius", height: 1.93, weight: 97},
];

function findUserById(users, id){
    // hints suggested find, find finds an instance otherwise is undefined, but if
    // defined get the name or otherwise return null
    return (users.find((n) => n.id == id) || {}).name || null;
}


function computeBMIs(users){
    // declarative style using map
    return users.map((n) => n.weight / (n.height * n.height));
}

// Two examples being printed out
console.log(findUserById(users, 2))
console.log(computeBMIs(users))