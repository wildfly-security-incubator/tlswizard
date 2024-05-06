/*
 * JBoss, Home of Professional Open Source
 * Copyright 2018, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fly.wild.wizards.tlswizard;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fly.wild.wizards.tlswizard.controller.TLSConfiguration;
import fly.wild.wizards.tlswizard.controller.TLSConfiguration.Secure;
import fly.wild.wizards.tlswizard.controller.TLSConfiguration.TLSTypes;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class TLSWizardViewController {


	@FXML
	private TextField serverIP;
	@FXML
	private Label errorLabelIP;
	@FXML
	private ToggleGroup tlsType;
	@FXML
	private RadioButton oneWayTLS;
	@FXML
	private RadioButton twoWayTLS;
	@FXML
	private ToggleGroup secure;
	@FXML
	private RadioButton applications;
	@FXML
	private RadioButton managementInterfaces;
	
	
	@FXML
	private void handleButtonHomeNextEvent () {
	
		
		if (isIPAddressValid(serverIP.getText())) {

			try {

				//TLSConfiguration tlsConfiguration = new TLSConfiguration();
				
				App.tlsConfiguration.setServerIP(serverIP.getText());

				RadioButton selected = (RadioButton) tlsType.getSelectedToggle();
				//System.out.println (selected.getText());
				
				RadioButton secured = (RadioButton) secure.getSelectedToggle();
				
				if (secured.getText().equals("applications")) {
					App.tlsConfiguration.setSecure(Secure.APPLICATIONS);
				}
				
				else if (secured.getText().equals("management interfaces")) {
					App.tlsConfiguration.setSecure(Secure.MANAGEMENT_INTERFACES);
				}
				
				//System.out.println (App.tlsConfiguration.getServerIP() 
				//		+ App.tlsConfiguration.getTlsType() 
				//		+ App.tlsConfiguration.getSecure());
				
				if (selected.getText().equals("One-way TLS")) {
					App.tlsConfiguration.setTlsType(TLSTypes.ONEWAYTLS);
					App.setRoot("OneWayTLSView");
				}
				
				else if (selected.getText().equals("Two-way TLS")) {
					App.tlsConfiguration.setTlsType(TLSTypes.TWOWAYTLS);
					App.setRoot("TwoWayTLSView");
				}
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			
		}	
	
        
	}
	
	
	private boolean isIPAddressValid (String ipAddress) {
		
		boolean valid = false;
		
		if (ipAddress.isEmpty()) {
			errorLabelIP.setVisible(true);
			return false;
		}
			
		
		String zeroTo255
        = "(\\d{1,2}|(0|1)\\"
          + "d{2}|2[0-4]\\d|25[0-5])";
		
		String regex
        = zeroTo255 + "\\."
          + zeroTo255 + "\\."
          + zeroTo255 + "\\."
          + zeroTo255;
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(ipAddress);
	
		valid = m.matches();
		
		if (!valid) {
			errorLabelIP.setVisible(true);
		}
		
		return valid;
	}
	
}
