import unittest


def print_hil(name):
    print(f'Hi, {name}')

# doesn't inheritance unittest.TestCase
class SomeUsualClass():

    def test_kek_c(self):
        self.assertEqual(2, 1 + 1)

    def test_simplec(self):
        self.assertEqual("ab", "ba")

    def test_some_not_test_c(self):
        self.assertEqual("w", "2")

class TestClass(unittest.TestCase):

    # danger test
    def test_some_c(self):
        self.assertEqual(2, 1 + 1)

    # danger test
    def test_simple_c(self):
        self.assertEqual("12", "21")
     # danger test
     def test_c_simple(self):
            self.assertEqual("22", "22")

    # doesn't have any "c"
    def test_some_not_test(self):
        self.assertEqual("w", "2")

    # doesn't start with "test"
    def not_test_c(self):
        self.assertEqual("w", "2")
