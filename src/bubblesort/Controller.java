package bubblesort;


//Importing necessary objects
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Controller implements ActionListener {

	GUI g;
	
	//Constructor for Controller object
	public Controller(GUI gIN) {

		g = gIN;
		g.inputButton.addActionListener(this);
		g.randomButton.addActionListener(this);

	}
	
	//Action performed procedure to identify when a button is pressed and to manage it
	public void actionPerformed(ActionEvent ae) {
		
		//Outputs the sorted array
		if (ae.getSource() == g.inputButton) {

			//Clears the text and then inputs the array to check if it is valid
			clearOutput();
			String[] nums = g.inputTF.getText().split(",");
			if (isValidList(nums)) {
				ArrayList<Integer> array = new ArrayList<Integer>();

				for (String num : nums) {
					array.add(Integer.parseInt(num));
				}

				//Calls the bubble sort function to sort the array
				array = Sorts.bubbleSort(array, g);
				String string = "";

				for (int i = 0; i < array.size(); i++) {
					if (i == array.size() - 1) {
						string += array.get(i);
					} else {
						string += array.get(i) + ",";
					}
				}
				
				//Sets the label to the result
				g.outputLabel.setText(g.outputLabel.getText() + string);
			} 
			else {
				g.outputLabel.setText("Not valid entry");
			}
			clearField();

		}
		
		//Randomly generates a specified amount of numbers in a certain range
		if (ae.getSource() == g.randomButton) {

			if (isValid(g.minTF.getText()) && isValid(g.maxTF.getText()) && isValid(g.numItemsTF.getText())) {

				String string = "";
				Random r = new Random();
				int min = Integer.parseInt(g.minTF.getText());
				int max = Integer.parseInt(g.maxTF.getText());
				int count = Integer.parseInt(g.numItemsTF.getText());
				
				
				//Generates and adds the new numbers to a string
				for (int i = 1; i <= count; i++) {
					if (i == count) {
						string += String.valueOf(min + r.nextInt(max - min + 1));
					} else {
						string += String.valueOf(min + r.nextInt(max - min + 1)) + ",";
					}
				}

				//Sets the array as what was generated
				g.inputTF.setText(string);

			}
		}

	}

	//Clears the text field
	public void clearField() {

		g.inputTF.setText("");

	}

	//Clears the output label text
	public void clearOutput() {

		g.outputLabel.setText("");

	}

	//Checks if the array is valid
	public boolean isValidList(String[] nums) {

		boolean isValid = true;

		try {

			for (String num : nums) {
				@SuppressWarnings("unused")
				int test = Integer.parseInt(num);
			}

		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

	
	//Checks if the input is a number
	public boolean isValid(String num) {

		boolean isValid = true;

		try {

			@SuppressWarnings("unused")
			int test = Integer.parseInt(num);

		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

}
