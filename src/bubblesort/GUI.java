package bubblesort;

//Importing necessary objects
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	//Declaring JFrames - two separate windows
	JFrame bubbleSort, bubbleOutput;
	
	//Initialising labels to display text
	JLabel inputLabel = new JLabel("Enter array: ", JLabel.LEFT);
	JLabel outputTitle = new JLabel("Output: ", JLabel.LEFT);
	JLabel outputLabel = new JLabel("", JLabel.LEFT);
	JLabel outputBubbles = new JLabel("", JLabel.LEFT);
	JLabel numItems = new JLabel("No items");
	JLabel min = new JLabel("Min");
	JLabel max = new JLabel("Max");
	
	//Initialising textfields for input
	JTextField inputTF = new JTextField(18);
	JTextField numItemsTF = new JTextField(4);
	JTextField minTF = new JTextField(4);
	JTextField maxTF = new JTextField(4);

	//Initialising buttons
	JButton inputButton = new JButton("Sort");
	JButton randomButton = new JButton("Random");

	//Declaring necessary JPanels for use inside JFrames
	JPanel content, top, middle, bottom, bubbles;

	//GUI object constructor
	public GUI() {

		bubbleSort = new JFrame("Bubble Sort");
		bubbleOutput = new JFrame("Bubble Output");
		layoutComponents();

	}

	//Procedure to format and add components to the JPanels
	public void layoutComponents() {

		content = new JPanel(new BorderLayout());
		bubbleSort.setContentPane(content);
		
		top = new JPanel(new FlowLayout());
		top.add(numItems);
		top.add(numItemsTF);
		top.add(min);
		top.add(minTF);
		top.add(max);
		top.add(maxTF);
		middle = new JPanel(new FlowLayout());
		middle.add(inputLabel);
		middle.add(inputTF);
		middle.add(inputButton);
		middle.add(randomButton);
		bottom = new JPanel(new FlowLayout());
		bottom.add(outputTitle);
		bottom.add(outputLabel);
		content.add(top, BorderLayout.NORTH);
		content.add(middle, BorderLayout.CENTER);
		content.add(bottom, BorderLayout.SOUTH);
		
		bubbles = new JPanel(new FlowLayout());
		bubbleOutput.setContentPane(bubbles);
		bubbles.add(outputBubbles);

	}

}