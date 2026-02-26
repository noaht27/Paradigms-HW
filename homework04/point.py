#!/usr/bin/env python3
# Noah Thompson
# 26 February 2026
# point.py

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def print(self):
        print(f"({self.x}, {self.y})")
    
    def distance(p1, p2):
        x2  = p2.x
        x1 = p1.x
        y2 = p2.y
        y1 = p1.y
        dis = ((x2-x1)**2 + (y2-y1)**2)**(1/2)
        print(f"The points distance is {dis}")

    # check p1 > p2
    def __gt__(p1, p2):
        x2  = p2.x
        y2 = p2.y

        x1 = p1.x
        y1 = p1.y
        dist_p1 = ((0-x1)**2 + (0-y1)**2)**(1/2)
        dist_p2 = ((x2-0)**2 + (y2-0)**2)**(1/2)
        if dist_p2 < dist_p1:
            return True
        return False

p1 = Point(2,3)  
p2 = Point(-3,1) 
p3 = Point(-2,-3)
print(p1 > p2)