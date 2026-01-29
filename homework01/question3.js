// Noah Thompson
// 28 January 2026
// question3.js

function enumerate(i,j) {
    const outputs = []
    while (i <=0) {         //want null when i is negative or 0
        outputs.push(null);
        i = i + 1;
    }

    const final = pyramid(j);
    while (i <= j) {                //now i'm getting all values between positive i and j
        outputs.push(final[i-1]);   // index from i-1 and not just i
        i +=1;
    }
    return outputs;
}

// This pyramid function will do the pyramid pattern so enumerate isn't messy
function pyramid(end) { 
    let numerator = 2;          // always starts at 2/2
    let denominator = 2;
    let increase = 2;           // when numerator and denominator increase or decrease, always by 2
    let decrease = -2;
    let step = 0;               // keep track of steps until equal to j
    let state = "down";         // first state is always down
    const final = []
    
    while (step < end) {        // only want to go up to j value (from enumerate function)
        final.push(String(numerator + '/' + denominator)) // put string in array

        if (state == "down"){                   // on state down
            numerator = numerator + increase;   // numerator increases down
            state = "up right";                 // next move always up right
        }
        else if (state == "up right"){
            numerator = numerator + decrease;
            denominator = denominator + increase;
            if (numerator == 2) {       // when numerator is 2 go right
                state = "right";
            }
        }
        else if (state == "right"){
            state = "down left";
            denominator = denominator + increase;
        }
        else if (state == "down left"){
            denominator = denominator + decrease;
            numerator = numerator + increase;
            if (denominator == 2)        // when denominator is 2 you go down
            {
                state = "down";
            }
        }
        step += 1;                      // step increases each time moving through pattern
    }
    return final;
}
// testing inputs
console.log(enumerate(1, 2));
console.log(enumerate(3, 6));
console.log(enumerate(-1, 4));
console.log(enumerate(-4, 0));
console.log(enumerate(1, 1));
