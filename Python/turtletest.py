import time
import turtle

turtle.left(90)
turtle.backward(300)

abc = 300
while abc > 2:
    turtle.forward(abc)
    turtle.left(20)
    turtle.forward(abc)
    turtle.backward(abc)
    turtle.left(20)
    turtle.forward(abc)
    turtle.backward(abc)
    turtle.right(40)

    abc /= 2

time.sleep(5)
