public class RayTracer {
	static Camera camera = new Camera();

	public void trace() {
		for (int i = 0; i < Output.WIDTH; i++) 
		{
			for (int j = 0; j < Output.WIDTH; j++) 
			{
				double u = camera.getL() + (camera.getR() - camera.getL()) * (i+0.5)/Output.WIDTH;
				double v = camera.getT() + (camera.getB() - camera.getT()) * (j+0.5)/Output.HEIGHT;
				
				Vector3D s = Util.add(camera.getU().skalarmultiplication(u), camera.getV().skalarmultiplication(v), camera.getW_d_negated());
				Vector3D dir = s.normalize();
				
				Ray r = new Ray(camera.getEye(), dir);
				
				int res_color = r.castPrimary(0);
				Output.setPixel(i, j, res_color);
			}
		}
	}

}
