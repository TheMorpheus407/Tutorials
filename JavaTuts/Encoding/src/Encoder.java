import java.math.BigInteger;
import java.util.ArrayList;

public class Encoder {
	String decoded;
	String encoded;
	ArrayList<Wrapper> list = new ArrayList<Wrapper>();

	public Encoder(String string) {
		this.decoded = string;
		this.encoded = this.toBinary();
		this.encode();
	}

	private String toBinary() {
		String binary = new BigInteger(this.decoded.getBytes()).toString(2);

		return binary;
	}

	public void encode() {
		for (int i = 0; i < encoded.length(); i++) {
			char c = encoded.charAt(i);
			Wrapper w = new Wrapper();
			w.amount = 1;
			w.digit = c;
			while ((i+1) < encoded.length() && c == encoded.charAt(i + 1)) {
				w.amount++;
				i++;
			}
			list.add(w);
		}
	}

}
