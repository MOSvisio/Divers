class Array2D:
    def __init__(self, dimOne, dimTwo):
        """
        Object builder
        :param nbrows:  number of rows
        :param nbcols:  number of cols
        """
        self.dimOne = dimOne
        self.dimTwo = dimTwo
        self.grid = dict()

    def setvalue(self, i, j, value):
        """
        Store a given value at a given coordinate
        :param i: first dimension coordinate
        :param j: second dimension coordinate
        :param value: the value to store
        :return: nothing
        """
        if 0 <= i <= self.dimOne and 0 <= j <= self.dimTwo:
            self.grid[i, j] = value

    def getvalue(self, i, j):
        """
        Get the value stored at a give coordinate
        An exception is raised if no value is stored at the given location
        :param i: first dimension coordinate
        :param j: second dimension coordinate
        :return: the value stored
        """
        return self.grid[i, j]

    def isvalue(self, i, j):
        """
        Test if a value is stored at a given coordinate
        :param i: first dimension coordinate
        :param j: second dimension coordinate
        :return: True if there is a value stored at the given coordinate, False otherwise
        """
        return (i, j) in self.grid

    def getdimone(self):
        """
        :return: the size of the first dimension
        """
        return self.dimOne

    def getdimtwo(self):
        """
        :return: the size of the second dimension
        """
        return self.dimTwo