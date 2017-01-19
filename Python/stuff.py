import math
class A(object):
    y = 0

    def __init__(self):
        self.z = 42

    def foo(self, x):
        print("foo(%s,%s)" % (self, x))

    @classmethod
    def class_foo(cls, x):
        print("class_foo(%s,%s)" % (cls, x))

    @staticmethod
    def static_foo(x):
        print("static_foo(%s)" % x)

a = A()
b = A()

a.foo(1)

a.class_foo(1)

a.static_foo(1)

A.static_foo('hi')

