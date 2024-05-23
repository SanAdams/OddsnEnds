# Solving Daily Coding Problem 1197
# Basically implementing a stack with push, pop, and max functions

class stack:
    def __init__(self) -> None:
        self.maxstack = []
        self.stack = []

# When invoked, remove and return the top item from the stack
    def pop(self):

        # If the stack is empty, return none
        if self.stack is None:
            return None
        
        # Otherwise pop!
        else:

            # Save the value so it can be returned
            topItem = self.stack[-1]

            # Delete it from the array
            del self.stack[-1]

            # Check if it was the maximum value and delete if so
            if self.maxstack[-1] == topItem:
                del self.maxstack[-1]

        return topItem

# When given a value, put item on top of the stack
    def push(self, value):

        # Put the item on top of the stack
        self.stack.append(value)

        # Check to see if it is the max or if the maxstack is empty
        if not self.maxstack or value >= self.maxstack[-1]:

            # Put it at the top of the maxstack
            self.maxstack.append(value)
        

# When invoked, return the greatest value within the stack
    def max(self):
        if self.maxstack:
            return self.maxstack[-1]
        else: 
            return None