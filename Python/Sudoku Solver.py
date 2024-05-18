# A sudoku solver that uses backtracking and recursion
# Following a tutorial and making a few additions of my own for my edification
# credit to: https://github.com/kying18

# If there is a conflict with the rules of Sudoku, returns true, otherwise returns false
def conflict(puzzle, guess, row, col):

    # Get row values
    puzzleRow = puzzle[row]

    # If we are inserting into a row that already has this number, there is a conflict
    if guess in puzzleRow:
        return True

    # Same for the columns--get the column values
    # In python there is a way to shorten syntax for creating lists if the list values
    # are based on an already existing list -list comprehension
    puzzleCol = [puzzle[rowIdx][col] for rowIdx in range(9)]
    if guess in puzzleCol:
        return True
    
    # Same for 3x3 square the number is in
    # if you divide the row of your guess by three and truncate it (e.g 5 // 3 = 1), you always get the (vertical) set
    # 3 squares that your guess is in. Then multiply by three to get the row where the start of the square is
    
    # the row where the 3x3 square starts
    squareStartRow = (row // 3) * 3

    # Same logic for the columns (you get the horizontal set) if you have both the vertical and horizontal set, there is 
    # only one 3x3 square that can be in both sets
    # the column where the 3x3 square starts
    squareStartCol = (col // 3) * 3

    # If that doesn't make sense, think about how you traverse rows and columns. To move from column to column you move horizontally, to move from row
    # to row you move vertically

    # iterate through the rows and columns in that square to check for guess
    # basically a double for loop where the number of iterations is determined using python's range function
    for r in range(squareStartRow, squareStartRow + 3):
        for c in range(squareStartCol, squareStartCol + 3):
            if puzzle[r][c] == guess:
                return True

    return False

# Finds an empty slot for the next number to be inserted
def findEmptySlot(puzzle):
    
    # Just iterate through every spot on the puzzle going from top left to bottom right
    for row in range(9):
        for col in range(9):
            if puzzle[row][col] == -1:
                return row, col
            
    return None, None

def solveRec(puzzle):
    
    # Find an empty slot 
    row, col = findEmptySlot(puzzle)
    
    # If there's nowhere else to insert then we must be done and the puzzle is solved
    if row is None:
        print("Puzzle solved!")
        return True
    
    # range (1,10); this is 1-9 inclusive
    # Guess every number in the allowable range for sudoku
    for guess in range(1, 10): 

        # Check the guess for any conflicts with the rules, if not insert it
        if not conflict(puzzle, guess, row, col):
            puzzle[row][col] = guess

            # Cool now let's keep solving the puzzle
            if solveRec(puzzle):
                return True
        
        # If we don't find a solution to the puzzle with guess, reset that spot
        puzzle[row][col] = -1

    # If nothing works, there is no solution
    return False

def printPuzzle(puzzle):
    for row in puzzle:
        print(" ".join(str(num) if num != -1 else '.' for num in row))

# Example usage
puzzle = [
    [5, 3, -1, -1, 7, -1, -1, -1, -1],
    [6, -1, -1, 1, 9, 5, -1, -1, -1],
    [-1, 9, 8, -1, -1, -1, -1, 6, -1],
    [8, -1, -1, -1, 6, -1, -1, -1, 3],
    [4, -1, -1, 8, -1, 3, -1, -1, 1],
    [7, -1, -1, -1, 2, -1, -1, -1, 6],
    [-1, 6, -1, -1, -1, -1, 2, 8, -1],
    [-1, -1, -1, 4, 1, 9, -1, -1, 5],
    [-1, -1, -1, -1, 8, -1, -1, 7, 9]
]

# Solve and print if solvable
if solveRec(puzzle):
    printPuzzle(puzzle)
    
# if not print that
else:
    print("No solution exists")
