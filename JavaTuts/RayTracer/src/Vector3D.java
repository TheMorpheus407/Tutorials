
public class Vector3D {
	double x;
	double y;
	double z;
	
	public Vector3D() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public Vector3D(double x) {
		this.x = x;
		this.y = 0;
		this.z = 0;
	}
	

	public Vector3D(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void add(Vector3D b)
	{
		this.x += b.x;
		this.y += b.y;
		this.z += b.z;
	}
	
	
	public double skalarproduct(Vector3D b) 
	{
		return Math.sqrt(this.x * b.x + this.y * b.y + this.z * b.z);
	}
	
	public Vector3D skalarmultiplication(double d)
	{
		return new Vector3D(d*this.x, d*this.y, d*this.z);
	}

	public Vector3D subtract(Vector3D b)
	{
		return new Vector3D(this.x - b.x, this.y - b.y, this.z - b.z);
	}
	
	public Vector3D normalize()
	{
		double length = skalarproduct(this);
		if(Math.abs(length) == 0)
		{
			return new Vector3D();
		}
		return new Vector3D(this.x/length, this.y/length, this.z/length);
	}
	
	public Vector3D cross(Vector3D b){
		return new Vector3D(this.y * b.z - this.z * b.y, 
							this.z * b.x - this.x * b.z, 
							this.x * b.y - this.y * b.x);
	}
	
	public double prod(Vector3D b) 
	{
		return this.x * b.x + this.y * b.y + this.z * b.z;
	}

	public Vector3D move(double epsilon, Vector3D positionToLight)
	{
		return Util.add(this, positionToLight.skalarmultiplication(epsilon));
	}

	public Vector3D multiply(Vector3D b)
	{
		return new Vector3D(this.x * b.x, this.y * b.y, this.z * b.z);
	}

	public double length()
	{
		return this.skalarproduct(this);
	}

}
