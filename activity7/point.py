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

p1 = Point(3, 7)
p2 = Point(-1, -2)
distance(p1,p2)