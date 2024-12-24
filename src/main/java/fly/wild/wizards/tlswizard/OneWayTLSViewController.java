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

import fly.wild.wizards.serverside.ServerConnector;
import fly.wild.wizards.tlswizard.controller.OneWayTLSConfigurationConfiguration;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OneWayTLSViewController {

	@FXML
	TextField KeyStoreFileName;
	@FXML
	TextField FirstAndLastName;
	@FXML
	TextField OrganizationalUnit;
	@FXML
	TextField Organization;
	@FXML
	TextField CityOrLocality;
	@FXML
	TextField StateOrProvince;
	@FXML
	TextField CountryCode;
	@FXML
	Label errorLabelKeyStore;
	@FXML
	TextArea result;
	@FXML
	Button configureTLSButton;
	
	OneWayTLSConfigurationConfiguration oneWayTLSConfiguration;
	
	@FXML
	private void handleButtonPreviousEvent () {
		
		try {
			App.setRoot("TLSWizardView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void handleButtonNextEvent () {
		
		oneWayTLSConfiguration = new OneWayTLSConfigurationConfiguration();
		
		if (validateOneWayTLSViewForm()) {
			
			oneWayTLSConfiguration.setKeyStoreFileNameValue(KeyStoreFileName.getText());
			
			if (!FirstAndLastName.getText().isBlank()) {
				oneWayTLSConfiguration.setFirstAndLastNameValue(FirstAndLastName.getText());
			}
			
			if (!OrganizationalUnit.getText().isBlank()) {
				oneWayTLSConfiguration.setOrganizationalUnitValue(OrganizationalUnit.getText());
			}
			
			if (!Organization.getText().isBlank()) {
				oneWayTLSConfiguration.setOrganizationValue(Organization.getText());
			}
			
			if (!CityOrLocality.getText().isBlank()) {
				oneWayTLSConfiguration.setCityOrLocalityValue(CityOrLocality.getText());
			}
			
			if (!StateOrProvince.getText().isBlank()) {
				oneWayTLSConfiguration.setStateOrProvinceValue(StateOrProvince.getText());
			}
			
			if (!CountryCode.getText().isBlank()) {
				oneWayTLSConfiguration.setCountryCodeValue(CountryCode.getText());
			}
			
			//System.out.println (oneWayTLSConfiguration.toString());
			//System.out.println (App.tlsConfiguration.getServerIP());
			
			ServerConnector serverConnector = new ServerConnector(App.tlsConfiguration, oneWayTLSConfiguration);
			boolean success = serverConnector.configureOneWayTLS();
			if (success) {
				result.setText(serverConnector.getConfigurationDetails());
				result.setVisible(true);
			}
			else {
				result.setText("Sorry something went wrong.\nCheck if your server is running and the IP addess you provided is correct.");
				result.setVisible(true);
			}
			
			configureTLSButton.setDisable(true);
		}
		
	}
	
	private boolean validateOneWayTLSViewForm () {
		
		boolean isValid = false;
		if (KeyStoreFileName.getText().isBlank()) {
			
			errorLabelKeyStore.setVisible(true);
			
		}
		
		else {
			isValid = true;
		}
		
		return isValid;
	}
}
