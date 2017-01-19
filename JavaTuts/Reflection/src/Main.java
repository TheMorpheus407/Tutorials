import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.morpheus.de.SomeObject;


public class Main {

	public static void main(String args[])
	{
		ClassLoader classLoader = Main.class.getClassLoader();
		
		try
		{
			Class myClass = classLoader.loadClass("com.morpheus.de.SomeObject");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
