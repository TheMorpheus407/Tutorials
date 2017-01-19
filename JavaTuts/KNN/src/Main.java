import java.util.ArrayList;

public class Main {
	public static int k = 5;

	public static void main(String[] args) {
		ArrayList<DataObject> objs = new ArrayList<DataObject>();
		objs.add(new DataObject(5, 1, 0));
		objs.add(new DataObject(6, 1, 0));
		objs.add(new DataObject(5, 2, 0));
		objs.add(new DataObject(6, 2, 0));
		objs.add(new DataObject(7, 1, 0));
		objs.add(new DataObject(0, 4, 1));
		objs.add(new DataObject(1, 4, 1));
		objs.add(new DataObject(0, 5, 1));
		objs.add(new DataObject(1, 5, 1));
		DataObject o = new DataObject(2, 3);

		System.out.println(kNN(o, objs));
	}

	public static int kNN(DataObject o, ArrayList<DataObject> objs) {
		int[] indices = new int[k];
		double[] mins = new double[k];
		for (int i = 0; i < k; i++) {
			mins[i] = Double.MAX_VALUE;
		}

		for (int i = 0; i < objs.size(); i++) {
			double dist = distance(o, objs.get(i));
			double max = Double.MIN_VALUE;
			int maxIdx = 0;
			for (int j = 0; j < k; j++) {
				if (max < mins[j]) {
					max = mins[j];
					maxIdx = j;
				}
			}
			if (mins[maxIdx] > dist) {
				mins[maxIdx] = dist;
				indices[maxIdx] = i;
			}
		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < k; i++) {
			if (objs.get(indices[i]).klasse == 0) {
				a++;
			} else {
				b++;
			}
		}
		if (a > b) {
			return 0;
		} else {
			return 1;
		}
	}

	public static double distance(DataObject o, DataObject ref) {
		return (o.x - ref.x) * (o.x - ref.x) + (o.y - ref.y) * (o.y - ref.y);
	}
}
