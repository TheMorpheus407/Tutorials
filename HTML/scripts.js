function meinEvent() {
	var x = new Date().getTime();
	var y = new Date(x + 7*24*60*60*1000);
	window.alert(y);
}

function meinEvent2() {
    function Pinguin(name, alter, geschw) {
        this.name = name;
		this.alter = alter;
		this.schwimmgeschwindkeit = geschw;
		this.gottagofast = function (schneller) {
			this.schwimmgeschwindkeit =
				this.schwimmgeschwindkeit + schneller;
			return 42;
		};
    }
    var franz = new Pinguin("Franz", 40, 4);
    var franziska = new Pinguin("Franziska", 39, 5);

	Pinguin.prototype.slowbro = function () {
		this.schwimmgeschwindkeit = 1;
	};
	franziska.gottagofast(4);
	window.alert(franziska.schwimmgeschwindkeit);
	franziska.slowbro();
	window.alert(franziska.schwimmgeschwindkeit);
}

function meineFkt() {
	document.getElementById("para2").addEventListener("mouseover", meineFkt);
	var x = document.getElementById("div1");
	var add = 0;
	var id = setInterval(function () {
		if (add >= 500) {
			clearInterval(id);
		}
		else {
			x.style.marginLeft = add + 'px';
			x.style.marginTop = add + 'px';
			add++;
		}
	}, 5); 
}