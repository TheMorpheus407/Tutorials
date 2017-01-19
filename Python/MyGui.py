import sys
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtCore import *
import time

class Button(QPushButton):
    def __init__(self, title, parent):
        super().__init__(title, parent)
        self.setAcceptDrops(True)

    def dragEnterEvent(self, e):
        if e.mimeData().hasFormat('text/plain'):
            e.accept()
        else:
            e.ignore()

    def dropEvent(self, e):
        self.setText(e.mimeData().text())

class Fenster(QWidget):
    def __init__(self):
        super().__init__()
        self.initMe()

    def initMe(self):
        edit = QLineEdit('Drop me hard', self)
        edit.setDragEnabled(True)
        edit.move(100,100)
        btn = Button("Drop it on me.", self)

        self.setGeometry(50,50,1000,500)
        self.setWindowTitle("My first GUI")
        self.setWindowIcon(QIcon("email.png"))
        self.show()


app = QApplication(sys.argv)
w = Fenster()
sys.exit(app.exec_())