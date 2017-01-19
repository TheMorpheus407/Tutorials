struct Rechteck {
    x: f64,
    y: f64,
}
trait FlaecheDa {
    fn flaeche(&self) -> f64;
}

impl FlaecheDa for Rechteck {
    fn flaeche(&self) -> f64 {
        self.x * self.y
    }
}
impl Rechteck {
	fn new() -> Rechteck {
		Rechteck{x: 3.0, y: 2.0,}
	}
    fn umfang(&self) -> f64 {
    	2.0 * (self.x + self.y)
    }
    fn destroy(self) -> Rechteck {
    	self
    }
}

fn print_flaeche<T>(x: T) {
    print!("{}", x.flaeche());
}

fn main() {
	let r = Rechteck::new();
	print_flaeche(r);
}