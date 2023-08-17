public class FourColor {
	
	int map[][];
	enum Color {NONE, RED, YELLOW, GREEN, BLUE}

	Color NONE = Color.NONE;
	Color[] mapColors = { NONE, NONE, NONE, NONE,NONE, NONE, NONE };


	void createMap() {
		map = new int[7][];
		map[0] = new int[] { 1, 4, 2, 5 };
		map[1] = new int[] { 0, 4, 6, 5 };
		map[2] = new int[] { 0, 4, 3, 6, 5 };
		map[3] = new int[] { 2, 4, 6 };
		map[4] = new int[] { 0, 1, 6, 3, 2 };
		map[5] = new int[] { 2, 6, 1, 0 }; 
		map[6] = new int[] { 2, 3, 4, 1, 5 };
	}

	boolean explore(int country, Color color) {
		boolean done = false;

        if (okToColor(country, color)) {
            if (country == map.length - 1) {
                mapColors[country] = color;
                done = true;
            } else {
                mapColors[country] = color;
                done = explore(country + 1, Color.RED);
                if (!done) {
                    done = explore(country + 1, Color.YELLOW);
                }
                if (!done) {
                    done = explore(country + 1, Color.GREEN);
                }
                if (!done) {
                    done = explore(country + 1, Color.BLUE);
                }
            }
        }

        return done;
	}

	boolean okToColor(int country, Color color) {
        for (int c : map[country]) {
            if (color == mapColors[c]) {
                return false;
            }
        }

        return true;
	}

	void printMap() {
		for (int i = 0; i < mapColors.length; i++) {
			System.out.println("map[" + i + "] is " + mapColors[i]);
		}
	}



    public static void main (String[] args){
    	FourColor m = new FourColor();
		m.createMap();
		boolean result = m.explore(0, Color.RED);
		System.out.println(result);
		m.printMap();

    }
}

