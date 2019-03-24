
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	//All the non-numbered buttons
	JFrame RecFrame = new JFrame();
	JButton ClearBTN = new JButton("AC");
	JButton ChangeBTN = new JButton("+/-");
	JButton PercentBTN = new JButton("%");
	JButton DivideBTN = new JButton("/");
	JButton MultiplyBTN = new JButton("x");
	JButton MinusBTN = new JButton("-");
	JButton AddBTN = new JButton("+");
	JButton EqualBTN = new JButton("=");
	//All the numbered buttons
	JButton One = new JButton("1");
	JButton Two = new JButton("2");
	JButton Three = new JButton("3");
	JButton Four = new JButton("4");
	JButton Five = new JButton("5");
	JButton Six = new JButton("6");
	JButton Seven = new JButton("7");
	JButton Eight = new JButton("8");
	JButton Nine = new JButton("9");
	JButton Decimal = new JButton(".");
	JButton Zero = new JButton("0");
	JButton Blank = new JButton(" ");
	
	//The operation and number strings and integers variables
	int CurrentOperation = 0;
	String Num1;
	String Num2;
	double getNum1;
	double getNum2;
	double Answer = 0;
	
	String Operator = "";
	String Label = "";
	//The text box
	JLabel ResultLabel = new JLabel(" ");

public static void main(String[] args) {
		
		new Calculator();
}

	//Constructor
	public Calculator() {
		
		//Set the title to Calculator, the size to 225x250 and the visibility to true
		RecFrame.setTitle("Calculator");
		RecFrame.setSize(225, 250);
		RecFrame.setVisible(true);
			//A JPanel for the rectangular shape of the calculator
			JPanel myPanel = (JPanel)RecFrame.getContentPane();
			myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
			//The top panel of the calculator (the text)
			JPanel topPanel = new JPanel();
			topPanel.setLayout(new FlowLayout());
			topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			topPanel.add(ResultLabel); //Add the text into the panel
		
			//The bottom panel of the calculator (the numbers and operators buttons)
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(new GridLayout(5,4,2,2));
			//Add the buttons to the bottom panel
			bottomPanel.add(ClearBTN);
			bottomPanel.add(ChangeBTN);
			bottomPanel.add(PercentBTN);
			bottomPanel.add(DivideBTN);
			bottomPanel.add(Seven);
			bottomPanel.add(Eight);
			bottomPanel.add(Nine);
			bottomPanel.add(MultiplyBTN);
			bottomPanel.add(Four);
			bottomPanel.add(Five);
			bottomPanel.add(Six);
			bottomPanel.add(MinusBTN);
			bottomPanel.add(One);
			bottomPanel.add(Two);
			bottomPanel.add(Three);
			bottomPanel.add(AddBTN);
			bottomPanel.add(Blank);
			bottomPanel.add(Zero);
			bottomPanel.add(Decimal);
			bottomPanel.add(EqualBTN);
			
			//Each button has an actionlistener to listen when it is clicked
			ClearBTN.addActionListener(this);
			ChangeBTN.addActionListener(this);
			PercentBTN.addActionListener(this);
			DivideBTN.addActionListener(this);
			Seven.addActionListener(this);
			Eight.addActionListener(this);
			Nine.addActionListener(this);
			MultiplyBTN.addActionListener(this);
			Four.addActionListener(this);
			Five.addActionListener(this);
			Six.addActionListener(this);
			MinusBTN.addActionListener(this);
			One.addActionListener(this);
			Two.addActionListener(this);
			Three.addActionListener(this);
			AddBTN.addActionListener(this);
			Zero.addActionListener(this);
			Decimal.addActionListener(this);
			EqualBTN.addActionListener(this);
			
			//JFrame adds the two panels
			myPanel.add(topPanel);
			myPanel.add(bottomPanel);
			
			//Make sure it's visible
			RecFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		
		Object GetObject = event.getSource();
		
		//Check which button we clicked, then make the text convey that operator/number
		if(GetObject == ClearBTN)
		{
			Label = "";
			ResultLabel.setText(Label);
		}
		if(GetObject == ChangeBTN)
		{
			Label = "" + (-Answer);
			ResultLabel.setText(Label);
		}
		if(GetObject == PercentBTN)
		{
			Label = "" + (Answer) + "%";
			ResultLabel.setText(Label);
		}
		if(GetObject == DivideBTN)
		{
			Operator = "/";
			Label += Operator;
			ResultLabel.setText(Label);
		}
		if(GetObject == MinusBTN)
		{
			Operator = "-";
			Label += Operator;
			ResultLabel.setText(Label);
		}
		if(GetObject == MultiplyBTN)
		{
			Operator = "x";
			Label += Operator;
			ResultLabel.setText(Label);
		}
		if(GetObject == AddBTN)
		{
			Operator = "+";
			Label += Operator;
			ResultLabel.setText(Label);
		}
		if(GetObject == Seven)
		{
			Label += "7";
			ResultLabel.setText(Label);
		}
		if(GetObject == Eight)
		{
			Label += "8";
			ResultLabel.setText(Label);
		}
		if(GetObject == Nine)
		{
			Label += "9";
			ResultLabel.setText(Label);
		}
		if(GetObject == Four)
		{
			Label += "4";
			ResultLabel.setText(Label);
		}
		if(GetObject == Five)
		{
			Label += "5";
			ResultLabel.setText(Label);
		}
		if(GetObject == Six)
		{
			Label += "6";
			ResultLabel.setText(Label);
		}
		if(GetObject == One)
		{
			Label += "1";
			ResultLabel.setText(Label);
		}
		if(GetObject == Two)
		{
			Label += "2";
			ResultLabel.setText(Label);
		}
		if(GetObject == Three)
		{
			Label += "3";
			ResultLabel.setText(Label);
		}
		if(GetObject == Zero)
		{
			Label += "0";
			ResultLabel.setText(Label);
		}
		if(GetObject == Decimal)
		{
			Label += ".";
			ResultLabel.setText(Label);
		}
		//When we click the Equal button
		if(GetObject == EqualBTN)
		{
			//If we picked the addition operator
			if(Operator == "+")
			{
				try { //Then we add the two numbers by parsing them and cutting their stirngs into workable numbers
				CurrentOperation = Label.lastIndexOf("+");
				Num1 = Label.substring(0, CurrentOperation);
				getNum1 = Double.parseDouble(Num1);
				Num2 = Label.substring(CurrentOperation + 1, Label.length());
				getNum2 = Double.parseDouble(Num2);
				Answer = getNum1 + getNum2;
				Label = "" + Answer;
				ResultLabel.setText(Label);
				Operator = "";
				}
				catch (NumberFormatException e) {
				ResultLabel.setText("Error");
				}
			} 
			//If we picked the subtract operator
			if(Operator == "-")
			{
				try {//Then we subtract the two numbers by parsing them and cutting their stirngs into workable numbers
				CurrentOperation = Label.lastIndexOf("-");			
				System.out.println(CurrentOperation);
				Num1 = Label.substring(0, CurrentOperation);
				getNum1 = Double.parseDouble(Num1);
				Num2 = Label.substring(CurrentOperation + 1, Label.length());
				getNum2 = Double.parseDouble(Num2);
				Answer = getNum1 - getNum2;
				Label = "" + Answer;
				ResultLabel.setText(Label);
				Operator = "";
				}
				catch (NumberFormatException e) {
				ResultLabel.setText("Error");
				}
			} 
			//If we picked the divide operator
			if(Operator == "/")
			{
				try { //Then we divide the two numbers by parsing them and cutting their stirngs into workable numbers
				CurrentOperation = Label.lastIndexOf("/");
				Num1 = Label.substring(0, CurrentOperation);
				getNum1 = Double.parseDouble(Num1);
				Num2 = Label.substring(CurrentOperation + 1, Label.length());
				getNum2 = Double.parseDouble(Num2);
				Answer = getNum1 / getNum2;
				Label = "" + Answer;
				ResultLabel.setText(Label);
				Operator = "";
				}
				catch (NumberFormatException e) {
				ResultLabel.setText("Error");
				}
			} 
			//If we picked the multiply operator
			if(Operator == "x")
			{
				try { //Then we multiply the two numbers by parsing them and cutting their stirngs into workable numbers
				CurrentOperation = Label.lastIndexOf("x");
				Num1 = Label.substring(0, CurrentOperation);
				getNum1 = Double.parseDouble(Num1);
				Num2 = Label.substring(CurrentOperation + 1, Label.length());
				getNum2 = Double.parseDouble(Num2);
				Answer = getNum1 * getNum2;
				Label = "" + Answer;
				ResultLabel.setText(Label);
				Operator = "";
				}
				catch (NumberFormatException e) {
					ResultLabel.setText("Error");
				}
			}
			
		}
			
}
}