
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main implements ActionListener{
	public static JFrame PaniFrame = new JFrame();
	public static JPanel MainPanel = (JPanel) PaniFrame.getContentPane();
	public static ImageModifier ModifyImage = new ImageModifier();
	
	//Pictures
	public static BufferedImage PaniPic;
	public static BufferedImage RiverPic;
	public static BufferedImage Map;
	
	//All JButtons
	public JButton GoToMapBTN = new JButton("Click For Map");
	public JButton DonateBTN = new JButton("Donate!");
	
	//We made an Array of JButtons instead
	public JButton[] Provinces = {new JButton("Mahakali [1]"), new JButton("Kamali [2]"), new JButton("Gandaki [3]"),
	new JButton("Bagmati [4]"), new JButton("Lumbini [5]"), new JButton("Narayani [6]"), new JButton("Mechi [7]")};
	
	//All JPanels
	JPanel WelcomePanel = new JPanel();
	JPanel RiverPanel = new JPanel();
	JPanel GoToMapPanel = new JPanel();
	JPanel MapPanel = new JPanel();
	JPanel AddMapButtonsPanel = new JPanel();
	
	//Extra Variables
	public static String Donated;
	
	/* OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO*/
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		BufferedImage PaniResizedImage = null;
		BufferedImage RiverResizedImage = null;
		
		// Declaring and/or Initializing Local Variables
		Border EmptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		JLabel WelcomeLabel = new JLabel("Welcome to Project Sanitization!");
		WelcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		WelcomeLabel.setForeground(Color.MAGENTA);

		// Setting up the JFrame
		PaniFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PaniFrame.setTitle("Project Pani");
		PaniFrame.setSize(250, 250);

		// Setting the MainPanel Layout
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
		MainPanel.setBorder(EmptyBorder);
		
		// Adding a Welcome Panel and Picture
		try {
			RiverPic = ImageIO.read(new File("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/NarayaniRiver.jpg"));
			PaniPic = ImageIO.read(new File("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/ProjectSanitization.png"));
			RiverResizedImage = ModifyImage.Resize(RiverPic, 250, 150); //Resize
			PaniResizedImage = ModifyImage.Resize(PaniPic, 75, 75); // Resize	
		} catch (IOException e) {
			System.out.println("Picture could not load.");
		}
		
		//Add ActionListener
		GoToMapBTN.addActionListener(this);
		
		//Picture JLabels
		JLabel PaniPicLabel = new JLabel(new ImageIcon(PaniResizedImage));
		JLabel RiverPicLabel = new JLabel(new ImageIcon(RiverResizedImage));
		
		//Set BTN colors
		GoToMapBTN.setBackground(Color.RED);
		GoToMapBTN.setOpaque(true);
		
		//Add Items to JPanels
		WelcomePanel.add(WelcomeLabel);
		WelcomePanel.add(PaniPicLabel);
		RiverPanel.add(RiverPicLabel);
		RiverPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		GoToMapPanel.add(GoToMapBTN);
		
		//Main Panel adds JPanels
		MainPanel.add(WelcomePanel);
		MainPanel.add(RiverPanel);
		MainPanel.add(GoToMapPanel);
		//Essentials to the JFrame
		MainPanel.setBackground(Color.BLACK);
		PaniFrame.pack();
		PaniFrame.setVisible(true);
	}
	/* OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO*/
	public void CreateMap()
	{
		BufferedImage MapResizedImage = null;
		
		try {
			Map = ImageIO.read(new File("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/NepalProvinces.png"));
			MapResizedImage = ModifyImage.Resize(Map, 500, 350); //Resize
		} catch (IOException e) {
			System.out.println("Picture could not load.");
		}
		
		//Picture JLabels
		JLabel PaniPicLabel = new JLabel(new ImageIcon(MapResizedImage));
		PaniPicLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10));
		
		//ActionListener
		Provinces[0].addActionListener(this);
		Provinces[1].addActionListener(this);
		Provinces[2].addActionListener(this);
		Provinces[3].addActionListener(this);
		Provinces[4].addActionListener(this);
		Provinces[5].addActionListener(this);
		Provinces[6].addActionListener(this);
		DonateBTN.addActionListener(this);
		
		//JPanels
		AddMapButtonsPanel.add(Provinces[0]);
		AddMapButtonsPanel.add(Provinces[1]);
		AddMapButtonsPanel.add(Provinces[2]);
		AddMapButtonsPanel.add(Provinces[3]);
		AddMapButtonsPanel.add(Provinces[4]);
		AddMapButtonsPanel.add(Provinces[5]);
		AddMapButtonsPanel.add(Provinces[6]);
		
		MapPanel.add(PaniPicLabel);
		MapPanel.add(DonateBTN);
		//Main Panel adds JPanels
		MainPanel.add(MapPanel);
		MainPanel.add(AddMapButtonsPanel);
		
		PaniFrame.pack();
		PaniFrame.setVisible(true);
	}
	/* OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO*/
	public void actionPerformed(ActionEvent E) {
		Object GetObject = E.getSource();
		if(GetObject == GoToMapBTN)
		{
			MainPanel.remove(WelcomePanel);
			MainPanel.remove(RiverPanel);
			MainPanel.remove(GoToMapPanel);
			
			//We made a new method to call for a creation of the map instead
			CreateMap();
			
			MainPanel.revalidate(); //Re positions JPanels once removed
			MainPanel.repaint(); //Will update the JFrame
		}
		if(GetObject == Provinces[0])
		{
			   ImageIcon IconMahakali = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Mahakali.jpg");
		       Image image = IconMahakali.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconMahakali = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "According to the Mahakali Treaty of 1996 India and Nepal are in alliance for water resources; "
		       		+ "\nhowever, since the Nepal earthquake of 2015, India has not supported the"
		       		+ "\nMahakali province in terms of providing sanitized water for the country."
		       		+ "\nMahakali significantly requires agriculture for its primary food source, without water the villages "
		       		+ "\ncannot produce enough rice, which is the main food, within the region. "
		       		+ "\nIn order for Mahakali to achieve better resources, the public"
		       		+ "\nmust be aware of this problem and donate for the cause. ", "Mahakali", JOptionPane.WARNING_MESSAGE, IconMahakali);
		}
		if(GetObject == Provinces[1])
		{
			   ImageIcon IconKamali = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Kamali.jpg");
		       Image image = IconKamali.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconKamali = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "Kamali's drinking water quality is in ruins ever since"
		       		+ "\nthe earthquake in 2015; furthermore, this has led to mass famine and "
		       		+ "\ndehydration within the province. Although the irrigation water is deemed safe "
		       		+ "\nin terms of quality, that water cannot be utilized for drinking."
		       		+ "\nCurrently Red Cross and the World Health Organization have initiated a plan to provide "
		       		+ "\npurified water and medical care to Kamali's citizens.", "Kamali", JOptionPane.WARNING_MESSAGE, IconKamali);
		}
		if(GetObject == Provinces[2])
		{
			   ImageIcon IconGandaki = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Gandaki.jpg");
		       Image image = IconGandaki.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconGandaki = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "The Gandaki River is one of the major water resources within Nepal, yet since the 2015"
		       		+ "\nearthquake the river consists of debreeze and rapid erosoion of solids, which hurt the production of plants."
		       		+ "\nGandaki's water is also heavily produced from glaciers, with the earthquake occuring the glaciers have broken apart"
		       		+ "\nand its been an ardous task to extract water resources and purify it."
		       		+ "\nCurrently the Gandaki river is receiving donations from NGOs like The Water Project"
		       		+ "\nto eliminate any bacteria and particles from the rivers and glaciers to insure safe drinking.", "Gandaki", JOptionPane.WARNING_MESSAGE, IconGandaki);
		}
		if(GetObject == Provinces[3])
		{
			   ImageIcon IconBagmati = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Bagmati.jpg");
		       Image image = IconBagmati.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconBagmati = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "The Bagmati River is similar to the Gandaki River's significance, the people utilize it everyday."
		       		+ "\nThe river consists of much sewage pollution because people use it as a sewage, while others use it for drinking."
		       		+ "\nThis has led to constant health complications within the Bagmati River and people are having to migrate to other"
		       		+ "\nlocations to receive sanitized waters. Since 2000 Bagmati took efforts to clean the water, and it is successfully"
		       		+ "\ncleaning the water, and as of 2014 the situation was resolved by 50%, "
		       		+ "\nyet it is still known as a hazardous location for water.", "Bagmati", JOptionPane.WARNING_MESSAGE, IconBagmati);
		}
		if(GetObject == Provinces[4])
		{
			   ImageIcon IconLumbini = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Lumbini.jpg");
		       Image image = IconLumbini.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconLumbini = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "According to the Global Resources Insitute of Lumbini, only water resources from the 8/17 regions they observed were clean."
		       		+ "\nThe water contained from these samples consisted of 20 to 30 colony forming units (CFU) of E. Coli, a bacteria that is extremely dangerous for"
		       		+ "\ndrinking and containing within any organism's body. Only consisting of 25 to 30 wells within the Lumbini region, only a few consist of"
		       		+ "\nbacteria-free sources. Water quality can be improved with well sanitization methods and education towards the people on what to perform"
		       		+ "\nwith the region's water supply. Therefore, NGOs and awareness can help bring this cause to an end.", "Lumbini", JOptionPane.WARNING_MESSAGE, IconLumbini);
		}
		if(GetObject == Provinces[5])
		{
			   ImageIcon IconNarayani = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Narayani.jpg");
		       Image image = IconNarayani.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconNarayani = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "The Narayani river is the most significant river system within Nepal."
		       		+ "\nMany people utilize this river for transporation, drinking, fishing, agriculture, and sewage. "
		       		+ "\nEven with the 2015 Nepal earthquake, Narayani has not seen too many troubles with its water troubles."
		       		+ "\nAlthough, there were some problems with bacteria, Narayani is extremely significant to the Nepali peoplpe"
		       		+ "\nso most sanitization systems are implaced within this river. The river itself is not too destroyed to discuss"
		       		+ "\nabout its need for help, but it does require aid in removing E. coli bacteria from the sewages.", "Narayani", JOptionPane.WARNING_MESSAGE, IconNarayani);
		}
		if(GetObject == Provinces[6])
		{
			   ImageIcon IconMechi = new ImageIcon("C:/Users/Pravat Bhusal/Dropbox/GitHub/Archives/High-School/Project-Sanitization/pictures/Mechi.jpg");
		       Image image = IconMechi.getImage(); // Get the original image, and make it a Image object
		       Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // Width, Height resizing an Image
		       IconMechi = new ImageIcon(newimg);  // Cast it back into an IconImage
		      
		       JOptionPane.showMessageDialog(null, "Mechi was sufficent in food production, but since 1990s the region depleted this aspect."
		       		+ "\nDue to droughts and famine from the 2015 Nepal earthquake, production fell short"
		       		+ "\nof 21553 metric tonnes and by 179910 metric tonnes in 2015; therefore,"
		       		+ "\nconstant natural disasters and health hazards have occured within the region."
		       		+ "\nRed Cross and the Nepali government are currently instigating plans to help achieve better"
		       		+ "\nproduce of clean water.", "Mehchi", JOptionPane.WARNING_MESSAGE, IconMechi);
		}
		if(GetObject == DonateBTN)
		{  
			boolean Failed = false;
			Double DoubDonated = null;
			Donated = JOptionPane.showInputDialog("How much would you like to donate? In USD!");
			try{
			DoubDonated = Double.parseDouble(Donated);
			} catch (NumberFormatException e)
			{
				Failed = true;
				JOptionPane.showMessageDialog(null, "Sorry, but " + Donated + " is not a real number...");
			}
			if(Failed == false)
			{
			JOptionPane.showMessageDialog(null, "Thanks for donating: " + DoubDonated + "$" + " to help develop Nepal!");
			}
		}
	}
}