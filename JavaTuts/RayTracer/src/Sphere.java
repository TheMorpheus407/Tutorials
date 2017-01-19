import java.awt.Color;

public class Sphere implements Object3D{
	double radius;
	Vector3D center;
	Material m = new Material(new Vector3D(0,1,0));
	{
		m.setReference(this);
	}

	public Sphere(double radius, Vector3D center) {
		this.radius = radius;
		this.center = center;
	}

	public Sphere(int radius, Vector3D center, Color c)
	{
		this.radius = radius;
		this.center = center;
		this.m = new Material(new Vector3D(c.getRed()/255, c.getGreen()/255, c.getBlue()/255), this);
		m.setReference(this);
	}

	@Override
	public double intersect(Ray ray) {
		Vector3D dir = ray.direction;
		Vector3D origin = ray.position;
		double a = dir.prod(dir);
		Vector3D ec = origin.subtract(center);
		double b = 2 * dir.prod(ec);
		double c = ec.prod(ec) - radius*radius;
		Vector3D result = Util.mitternachtsformel(a, b, c);
		switch((int)Math.round(result.z))
		{
		case 0:
			return Double.MAX_VALUE;
		case 1:
			return result.x;
		case 2:
			if(result.x < 0)
			{
				if(result.y < 0)
				{
					return Double.MAX_VALUE;
				}
				else
				{
					return result.y;
				}
			}
			else
			{
				if(result.y < 0)
				{
					return result.x;
				}
				else
				{
					return Math.min(result.x, result.y);
				}
			}
			default:
				return Double.MAX_VALUE;
		}
	}

	@Override
	public int getColor(Vector3D position, int depth) {
		return m.getRGB(position, depth);
	}

	@Override
	public Vector3D getNormal(Vector3D position)
	{
		return position.subtract(center).normalize();
	}

}
