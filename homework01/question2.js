// Noah Thompson
// 28 January 2026
// question2.js

// inputs
nums1 = [33,33,30,33,33,33];
nums2 = [33,0,33,33,0,33];
nums3 = [33,-10,33,33,8,3,33,33,9,33,33,33,33,33,33];
nums4 = [33,33,5,33,33,33];
nums5 = [null, "house", 9, undefined, "33"];
nums6 = [33,33,30,33,33,33.0];

function find(nums) {
    let streak = 0;
    let streak2 = 0;
    for (let i = 0; i < nums.length; i++)
    {
        if (nums[i] === Number(33)){ // this is making sure 33 is a number and not any other type
            streak = streak + 1; // streak increment
        }
        else {
            streak = 0; // reset streak
        }

        if (streak2 < streak) {     // want longest streak, streak2 only changes if active streak is longer
            streak2 = streak;
        }
    }
    return Number(streak2); // function must return integer
}

// printing outputs
console.log(find(nums1));
console.log(find(nums2));
console.log(find(nums3));
console.log(find(nums4));
console.log(find(nums5));
console.log(find(nums6));