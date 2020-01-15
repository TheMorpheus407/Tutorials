import org.junit.Assert.*

internal class MyClassTest {
    var x: Int = 0
    var obj: MyClass = MyClass()

    @org.junit.Before
    fun setUp(){
        x = 42
    }

    @org.junit.After
    fun tearDown(){
        x = 0
    }

    @org.junit.Test
    fun foo() {
        print(obj.x)
        var res = obj.foo(1)
        assertEquals(x+1, res)
        obj.x = 55
        print(obj.x)
    }

    @org.junit.Test
    fun bar() {
        print(obj.x)
        var res = obj.foo(1)
        assertEquals(x+1, res)
        obj.x = 62
        print(obj.x)
    }
}