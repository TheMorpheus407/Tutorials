import sys
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtCore import *
import time

class Fenster(QWidget):
    def __init__(self):
        super().__init__()
        self.initMe()

    def initMe(self):
        grid = QGridLayout()
        namen = ['1', '2','3', '4','5', '6','7', '8']
        posis = [(0,0), (0,1), (0,2), (1,0),(1,2), (2,0),(2,2) ]
        for pos, name in zip(posis, namen):
            button = QPushButton(name)
            grid.addWidget(button, *pos)

        self.setLayout(grid)
        self.setGeometry(50,50,1000,500)
        self.setWindowTitle("My first GUI")
        self.setWindowIcon(QIcon("email.png"))
        self.show()


app = QApplication(sys.argv)
w = Fenster()
sys.exit(app.exec_())