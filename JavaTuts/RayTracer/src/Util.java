public class Util {
	public static final double EPSILON = 0.00004;
	public static final int maxRecursionDepth = 3;

	public static Vector3D add(Vector3D a, Vector3D b)
	{
		return new Vector3D(a.x+b.x, a.y+b.y, a.z+b.z);
	}
	public static Vector3D add(Vector3D a, Vector3D b, Vector3D c)
	{
		return Util.add(a, Util.add(b, c));
	}
	
	public static Vector3D mitternachtsformel(double a, double b, double c)
	{
		double diskriminante = b*b-4*a*c;
		if(a == 0)
		{
			return new Vector3D();
		}
		if(diskriminante < 0)
		{
			return new Vector3D();
		}
		else if(diskriminante == 0)
		{
			return new Vector3D(-b/(2*a), 0, 1);
		}
		else
		{
			double rightPart = Math.sqrt(diskriminante);
			return new Vector3D((-b+rightPart)/(2*a), (-b-rightPart)/(2*a), 2);
		}
	}
}
