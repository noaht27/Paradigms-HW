#!/usr/bin/env python3
# Noah Thompson
# 16 March 2026
# question1.py

# output of move_robot(n) is a list
def move_robot(n):
    # initializing steps list and adding origin / step 0
    steps_list = []
    steps_list.append((0, 0))

    step_count = 1
    turn_track = 1 # i used this to track the 90 degree turns
    curr_x = 0
    curr_y = 0

    for i in range(n):
        if turn_track == 1: # north
            curr_y += step_count # y increases by step when moving north
            curr_step = (curr_x, curr_y) # instructions say " each element is a tuple" so i did like this
            steps_list.append(curr_step)
            step_count += 1
            turn_track += 1

        elif turn_track == 2: # east
            curr_x += step_count # x increases by step when moving east
            curr_step = (curr_x, curr_y)
            steps_list.append(curr_step)
            step_count += 1
            turn_track += 1

        elif turn_track == 3: # south
            curr_y -= step_count # y decreases by step when moving south
            curr_step = (curr_x, curr_y)
            steps_list.append(curr_step)
            step_count += 1
            turn_track += 1

        elif turn_track == 4: # west
            curr_x -= step_count # x decreases when moving west
            curr_step = (curr_x, curr_y)
            steps_list.append(curr_step)
            step_count += 1
            turn_track = 1 # this resets it cuz next we want to go north now

    return steps_list

def main():
    # these are test cases from examples, and \n is just for spacing on output
    for v in move_robot(4):
        print(v)
    print("\n")

    for v in move_robot(0):
        print(v)
    print("\n")

    for v in move_robot(2):
        print(v)

if __name__ == "__main__":
    main()