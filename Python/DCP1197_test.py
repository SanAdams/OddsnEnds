import unittest
from DCP1197 import stack

class TestStack(unittest.TestCase):
    def test_stack_operations(self):
        my_stack = stack()

        # Push elements onto the stack
        my_stack.push(5)
        my_stack.push(3)
        my_stack.push(5)
        my_stack.push(2)

        # Check max value
        self.assertEqual(my_stack.max(), 5)

        # Pop an element
        popped_item = my_stack.pop()
        self.assertEqual(popped_item, 2)

        # Check max value after popping
        self.assertEqual(my_stack.max(), 5)

        # Pop another element
        popped_item = my_stack.pop()
        self.assertEqual(popped_item, 5)

        # Check max value after popping again
        self.assertEqual(my_stack.max(), 5)

        # Pop remaining elements
        my_stack.pop()
        my_stack.pop()

        # Check max value after popping all elements
        self.assertIsNone(my_stack.max())

if __name__ == '__main__':
    unittest.main()
