
public class Camera {
	private int l = -Output.WIDTH/2;
	private int r = l * -1;
	private int t = Output.HEIGHT/2;
	private int b = t * -1;
	
	private Vector3D UP = new Vector3D(0, 1, 0);
	private Vector3D eye = new Vector3D(0, 0, -10);
	private Vector3D Z = new Vector3D(0, 0, 0);
	
	private Vector3D W = eye.subtract(Z).normalize();
	private Vector3D U = UP.cross(W).normalize();
	private Vector3D V = W.cross(U).normalize();
	
	private double d = t/Math.tan(Math.PI/4)/2;

	private Vector3D W_d_negated = W.skalarmultiplication(d*-1); 
	
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public Vector3D getUP() {
		return UP;
	}
	public void setUP(Vector3D uP) {
		UP = uP;
	}
	public Vector3D getEye() {
		return eye;
	}
	public void setEye(Vector3D eye) {
		this.eye = eye;
	}
	public Vector3D getZ() {
		return Z;
	}
	public void setZ(Vector3D z) {
		Z = z;
	}
	public Vector3D getW() {
		return W;
	}
	public void setW(Vector3D w) {
		W = w;
	}
	public Vector3D getU() {
		return U;
	}
	public void setU(Vector3D u) {
		U = u;
	}
	public Vector3D getV() {
		return V;
	}
	public void setV(Vector3D v) {
		V = v;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public Vector3D getW_d_negated() {
		return W_d_negated;
	}
	public void setW_d_negated(Vector3D w_d_negated) {
		W_d_negated = w_d_negated;
	}
}
