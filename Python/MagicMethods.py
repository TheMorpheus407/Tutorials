class A:
    a = 10
    def __call__(self, x):
        print(self.a + x)

a = A()
b = A()

a(5)

