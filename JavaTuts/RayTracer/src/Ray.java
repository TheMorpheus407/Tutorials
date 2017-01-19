import java.awt.Color;

public class Ray {
	public Vector3D position;
	public Vector3D direction;

	public Ray(Vector3D pos, Vector3D dir)
	{
		this.direction = dir.normalize();
		this.position = pos;
	}

	public Ray(Vector3D from_point, Vector3D to_point, boolean dummy)
	{
		this.position = from_point;
		this.direction = to_point.subtract(from_point).normalize();
	}

	public int castPrimary(int depth)
	{
		if(depth > Util.maxRecursionDepth)
		{
			return Color.BLACK.getRGB();
		}
		Object3D intersect = null;
		double t = Double.MAX_VALUE - 1;
		for (Object3D o : Scene.getScene().objects)
		{
			double t2 = o.intersect(this);
			if (t2 > 0 && t2 < t)
			{
				intersect = o;
				t = t2;
			}
		}

		if (intersect != null)
		{
			return intersect.getColor(this.getPosition(t), depth);
		}
		else
		{
			return Color.BLACK.getRGB();
		}
	}
	
	public boolean castShadow()
	{
		double t = Double.MAX_VALUE - 1;
		for (Object3D o : Scene.getScene().objects)
		{
			double t2 = o.intersect(this);
			if (t2 > 0 && t2 < t)
			{
				return true;
			}
		}
		return false;
	}

	private Vector3D getPosition(double t)
	{
		return Util.add(this.position, this.direction.skalarmultiplication(t));
	}
}
