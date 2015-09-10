class AllTheColorsOfTheRainbow	{
	int anIntegerRepresentingColor = 0;
	int hue = 0;
	int changeTheHueOfTheColor(int newHue){
		hue = newHue;
		return hue;
	}
}

public class Ex8AllTheColorsOfTheRainbow	{
	public static void main(String [] args){
		AllTheColorsOfTheRainbow atc = new AllTheColorsOfTheRainbow();
		System.out.println("Hue before " + atc.hue);
		System.out.println("Hue after calling method " + atc.changeTheHueOfTheColor(3));
	}
}