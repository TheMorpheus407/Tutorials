
public interface Object3D {

	public double intersect(Ray ray);

	public int getColor(Vector3D position, int depth);
	
	public Vector3D getNormal(Vector3D position);

}
