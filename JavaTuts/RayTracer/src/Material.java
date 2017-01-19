import java.awt.Color;

public class Material {
	Object3D reference;

	Vector3D ambient;
	Vector3D diffus = new Vector3D(0.7, 0.7, 0.7);
	Vector3D specular = new Vector3D(0.3, 0.3, 0.3);

	double phongExponent = 5;

	double reflectionIdx = 0.5;

	public Material(Vector3D color)
	{
		this.ambient = color;
	}
	
	public Material(Vector3D color, Object3D ref)
	{
		this.ambient = color;
		this.reference = ref;
	}

	public int getRGB(Vector3D position, int depth)
	{
		if(reference == null)
		{
			return 0;
		}

		Vector3D sum = new Vector3D();
		for(Light l : Scene.getScene().lights)
		{
			Vector3D positionToLight = l.getPosition().subtract(position).normalize();
			Ray shadow = new Ray(position.move(Util.EPSILON, positionToLight), positionToLight);
			boolean shadowed = shadow.castShadow();
			
			Vector3D ret = new Vector3D();
			ret.add(ambient.multiply(l.getIntensity(position)));
			
			if(!shadowed)
			{
				Vector3D normal = this.reference.getNormal(position);
				double NL = Math.max(normal.prod(positionToLight), 0);
				ret.add(diffus.multiply(l.getIntensity(position)).skalarmultiplication(NL));
				
				Vector3D refl = normal.skalarmultiplication(NL*2).subtract(positionToLight).normalize();
				Vector3D V = RayTracer.camera.getEye().subtract(position).normalize();
				double RV = Math.max(refl.prod(V), 0);
				ret.add(specular.multiply(l.getIntensity(position)).skalarmultiplication(Math.pow(RV, phongExponent)));
			}
			double dist = l.getPosition().subtract(position).length();
			sum.add(ret.skalarmultiplication(1/(dist*dist)).skalarmultiplication(255));
		}
		if(this.reflectionIdx > 0)
		{
			Vector3D normal = this.reference.getNormal(position);
			Vector3D V = RayTracer.camera.getEye().subtract(position).normalize();
			double NV = Math.max(normal.prod(V), 0);
			Vector3D refl = normal.skalarmultiplication(NV*2).subtract(V).normalize();
			Ray reflection = new Ray(position.move(Util.EPSILON, refl), refl);
			int res = reflection.castPrimary(depth + 1);
			Color c = new Color(res);
			Vector3D v = new Vector3D(c.getRed(), c.getGreen(), c.getBlue());
			v.skalarmultiplication(reflectionIdx);
			sum.add(v);
		}
		sum.x = Math.min(255, sum.x);
		sum.y = Math.min(255, sum.y);
		sum.z = Math.min(255, sum.z);

		sum.x = Math.max(0, sum.x);
		sum.y = Math.max(0, sum.y);
		sum.z = Math.max(0, sum.z);
		
		Color c = new Color((int)Math.round(sum.x), (int)Math.round(sum.y), (int)Math.round(sum.z));
		return c.getRGB();
	}

	public void setReference(Object3D ref)
	{
		this.reference = ref;
	}

}
