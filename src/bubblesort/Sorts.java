package bubblesort;

//Importing necessary objects
import java.util.ArrayList;

import javax.swing.JFrame;

public class Sorts {

	public static void main(String[] args) {
		
		//Initialising a GUI object
		GUI g = new GUI();
		g.bubbleSort.setSize(500, 150);
		g.bubbleOutput.setSize(400, 400);
		g.bubbleSort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.bubbleOutput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		@SuppressWarnings("unused")
		Controller c = new Controller(g);
		
		g.bubbleSort.setVisible(true);
		g.bubbleOutput.setVisible(true);

	}

	//Bubble sort function to sort the array from lowest to highest
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> array, GUI g) {
		
		g.outputBubbles.setText("<html><p>Pass 0: " + g.inputTF.getText() + "<p>");
		
		boolean swapped = true;

		//For loop that sweeps through to change items
		for (int sweep = 1; sweep < array.size() && swapped; sweep++) {
			swapped = false;
			for (int pos = 0; pos < array.size() - 1; pos++) {
				if (array.get(pos) > array.get(pos + 1)) {
					swapped = true;
					int temp = array.get(pos);
					array.set(pos, array.get(pos + 1));
					array.set(pos + 1, temp);
				}
			}
			
			String string = "";
			
			for (int i = 0; i < array.size(); i++) {
				if (i == array.size() - 1) {
					string += array.get(i);
				} else {
					string += array.get(i) + ",";
				}
			}
			
			//Uses HTML formatting to allow the JLabel to go onto separate lines
			g.outputBubbles.setText(g.outputBubbles.getText() + "<p>Pass " + sweep + ": " + string + "<p>");
		}

		return array;
	}

}
