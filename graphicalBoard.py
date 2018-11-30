import tkinter


def mouseclick(event, queue, sideLength):
    queue.put((int(event.y / sideLength), int(event.x / sideLength)))


class GraphicWindow:
    def __init__(self, nbmaxres, nbrows, nbcols, queue):
        self.queue = queue

        # Size computations
        self.nbMaxRes = nbmaxres
        self.nbRows = nbrows
        self.nbCols = nbcols

        if nbrows > nbcols:
            self.sidelength = int(nbmaxres / nbrows)
        else:
            self.sidelength = int(nbmaxres / nbcols)

        self.rowLength = int(self.sidelength * nbcols)
        self.colLength = int(self.sidelength * nbrows)

        # Window creation
        self.root = tkinter.Tk()

        self.root.title('Reversi')
        self.root.geometry(str(self.rowLength)+'x'+str(self.colLength))
        self.root.resizable(False, False)

        # Canvas creation
        self.canvas = tkinter.Canvas(self.root, width=self.nbMaxRes, height=self.nbMaxRes, bg="ivory")
        for i in range(1, nbrows):
            self.canvas.create_line(0, i * self.sidelength, self.rowLength, i * self.sidelength, width=2, fill='black')
        for i in range(1, nbcols):
            self.canvas.create_line(i * self.sidelength, 0, i * self.sidelength, self.colLength, width=2, fill='black')
        self.canvas.pack()

        self.canvas.focus_set()
        self.canvas.bind("<Button-1>", lambda event: mouseclick(event, queue, self.sidelength))

    def draw(self):
        self.root.mainloop()

    def drawdisk(self, x, y, color):
        """
        Draw a disk at the coordinate (x, y) of the color in color
        :param x: line number
        :param y: column number
        :param color: color of the disk
        :return: nothing
        """
        self.canvas.create_oval(y * self.sidelength + 10, x * self.sidelength + 10,
                                (y + 1) * self.sidelength - 10, (x + 1) * self.sidelength - 10,
                                width=2, outline=color, fill=color)
        self.root.update()

    def drawbluedisk(self, x, y):
        self.drawdisk(x, y, 'Blue')

    def drawreddisk(self, x, y):
        self.drawdisk(x, y, 'red')

    def drawsquare(self, x, y, color):
        """
        Draw a disk at the coordinate (x, y) of the color in color
        :param x: line number
        :param y: column number
        :param color: color of the disk
        :return: nothing
        """
        self.canvas.create_rectangle(y * self.sidelength+1, x * self.sidelength+1,
                                     (y + 1) * self.sidelength-2, (x + 1) * self.sidelength-2,
                                     outline=color, fill=color)
        self.root.update()

    def drawgreensquare(self, x, y):
        self.drawsquare(x, y, 'green')

    def drawwhitesquare(self, x, y):
        self.drawsquare(x, y, 'ivory')

    def drawyellowsquare(self, x, y):
        self.drawsquare(x, y, 'yellow')

    def update(self):
        self.root.update()
