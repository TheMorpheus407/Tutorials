import java.awt.Color;
import java.util.ArrayList;


public class Scene {
	private static Scene scene;
	public ArrayList<Object3D> objects = new ArrayList<Object3D>();
	public ArrayList<Light> lights = new ArrayList<Light>();
	
	public Scene()
	{
		objects.add(new Sphere(5, new Vector3D(), Color.green));
		objects.add(new Sphere(3, new Vector3D(10, 0, 0), Color.red));
		lights.add(new PointLight(new Vector3D(0, 10, 10), new Vector3D(10,10,10)));
		lights.add(new PointLight(new Vector3D(-10, -10, 0), new Vector3D(10,10,10)));
		lights.add(new PointLight(new Vector3D(0, 10, 0), new Vector3D(10,10,10)));
		lights.add(new PointLight(new Vector3D(10, 10, 0), new Vector3D(10,10,10)));
	}
	
	public static Scene getScene()
	{
		if(scene == null)
		{
			Scene.scene = new Scene();
		}
		return scene;
	}

}
