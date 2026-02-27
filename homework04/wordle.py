#!/usr/bin/env python3
# Noah Thompson
# 26 February 2026
# wordle.py
import random

class Wordle:
    def __init__(self, user_guess, answer):
        # converting to lists allows to get individual character instead of string
        self.guess = list(user_guess)
        self.answer = list(answer)
    
    def goodLetters(self, good):
        # go through each letter in guess list, and check if in answer
        for letter in self.guess:
            if letter in self.answer:
                if letter not in good: # this is because we dont want repeated letters in array
                    good.append(letter)
        return good

    def badLetters(self, bad):
        for letter in self.guess:
            if letter not in self.answer:
                if letter not in bad: # this is because we dont want repeated letters in array
                    bad.append(letter)
        return bad

    def correctLetters(self, correct):
        # check index of letter in guess and compare with index of letter in answer
        for index in range(len(self.guess)):
            if self.guess[index] == self.answer[index]:
                correct[index] = self.guess[index]
        return correct
    
    def correctWord(self):
        if self.guess == self.answer:
            return True
        return False

def main():
    # converting words.txt into a list
    with open('words.txt', 'r') as f:
        words_list = [line.rstrip('\n') for line in f]

    # getting a random word
    num_words = len(words_list)
    random_number = random.randint(0, num_words - 1)
    answer = words_list[random_number]

    # chosen word saved to answer.txt
    with open('answer.txt', 'w') as f:
        f.write(answer)

    guesses = 0 # to track number guesses
    right = 0 # determine if user guessed it in 6 tries or not
    correct = ["", "", "", "", ""] # correct to pass to Wordle method
    good = []
    bad = []

    # get input while user has not guessed more than 6 times
    while (guesses < 6):
        user_guess = input("Enter your guess: ").upper() # converting to uppercase to match words.txt

        # here i check for a valid guess and don't increment guesses on a wrong guess
        if (user_guess not in words_list or len(user_guess) != 5):
            print("Error. Please enter a valid 5 letter word\n")
            continue
        else:
            current_guess = Wordle(user_guess, answer)
            print(f"Good Letters = {current_guess.goodLetters(good)}")
            print(f"Bad Letters = {current_guess.badLetters(bad)}")
            print(f"Correct Letters = {current_guess.correctLetters(correct)}")
            print("\n")
            guesses += 1

            # if guess is correct, game over and user wins! 
            if (current_guess.correctWord()):
                print(f"Congratulations, you correctly identified the word after {guesses} attempts!")
                right = 1
                break
    
    # if user never guesses right i print answer out
    if right == 0:
        print(f"The answer is {answer}. You did not correctly guess it within 6 tries")

if __name__ == "__main__":
    main()