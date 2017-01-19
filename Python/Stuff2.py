import sys
from PyQt5.QtWidgets import QApplication, QWidget
from PyQt5.QtGui import QIcon

app = QApplication(sys.argv)

w = QWidget()
w.setGeometry(50,50,500,500)
w.setWindowTitle('Simple')
w.setWindowIcon(QIcon("email.png"))
w.show()
sys.exit(app.exec_())