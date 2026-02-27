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
        # get points
        x2  = p2.x
        x1 = p1.x
        y2 = p2.y
        y1 = p1.y
        dis = ((x2-x1)**2 + (y2-y1)**2)**(1/2)
        return dis

    # check p1 > p2
    def __gt__(p1, p2):
        # get points
        zero = Point(0,0)

        #get distances from origin
        dist_p1 = Point.distance(p1, zero)
        dist_p2 = Point.distance(p2, zero)
        if dist_p2 < dist_p1:
            return True
        return False
    
    # check P1 >=P2
    def __ge__(p1, p2):
        # get points
        zero = Point(0,0)

        #get distances from origin
        dist_p1 = Point.distance(p1, zero)
        dist_p2 = Point.distance(p2, zero)
        if dist_p2 <= dist_p1:
            return True
        return False
    
    def __eq__(p1, p2):
        # get points
        zero = Point(0,0)

        #get distances from origin
        dist_p1 = Point.distance(p1, zero)
        dist_p2 = Point.distance(p2, zero)
        if dist_p2 == dist_p1:
            return True
        return False

    # compare distance P1 < P2
    def __lt__(p1, p2):
        # get points
        zero = Point(0,0)

        #get distances from origin
        dist_p1 = Point.distance(p1, zero)
        dist_p2 = Point.distance(p2, zero)

        if dist_p2 > dist_p1:
            return True
        return False
    
    # compare P1 <= P2
    def __le__(p1, p2):
        # get points
        zero = Point(0,0)

        #get distances from origin
        dist_p1 = Point.distance(p1, zero)
        dist_p2 = Point.distance(p2, zero)

        if dist_p2 >= dist_p1:
            return True
        return False

def main():
    # Example outputs
    p1 = Point(2,3)  
    p2 = Point(-3,1) 
    p3 = Point(-2,-3)
    print(p1 > p2)
    print(p1 == p2)
    print(p1 < p2)
    print(p1 == p3)

if __name__ == "__main__":
    main()