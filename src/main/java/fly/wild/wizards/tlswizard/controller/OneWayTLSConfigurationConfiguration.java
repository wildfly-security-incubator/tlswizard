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

package fly.wild.wizards.tlswizard.controller;

public class OneWayTLSConfigurationConfiguration {

	private String keyStoreFileNameValue;
	private String firstAndLastNameValue;
	private String organizationalUnitValue;
	private String organizationValue;
	private String cityOrLocalityValue;
	private String stateOrProvinceValue;
	private String countryCodeValue;
	
	public OneWayTLSConfigurationConfiguration () {
		
		this.keyStoreFileNameValue = "Unknown";
		this.firstAndLastNameValue = "Unknown";
		this.organizationalUnitValue = "Unknown";
		this.organizationValue = "Unknown";
		this.cityOrLocalityValue = "Unknown";
		this.stateOrProvinceValue = "Unknown";
		this.countryCodeValue = "Unknown";
		
	}
	
	public String getKeyStoreFileNameValue() {
		return keyStoreFileNameValue;
		
	}
	public void setKeyStoreFileNameValue(String keyStoreFileNameValue) {
		this.keyStoreFileNameValue = keyStoreFileNameValue;
		
	}
	public String getFirstAndLastNameValue() {
		return firstAndLastNameValue;
		
	}
	public void setFirstAndLastNameValue(String firstAndLastNameValue) {
		this.firstAndLastNameValue = firstAndLastNameValue;
		
	}
	public String getOrganizationalUnitValue() {
		return organizationalUnitValue;
		
	}
	public void setOrganizationalUnitValue(String organizationalUnitValue) {
		this.organizationalUnitValue = organizationalUnitValue;
		
	}
	public String getOrganizationValue() {
		return organizationValue;
		
	}
	public void setOrganizationValue(String organizationValue) {
		this.organizationValue = organizationValue;
		
	}
	public String getCityOrLocalityValue() {
		return cityOrLocalityValue;
		
	}
	public void setCityOrLocalityValue(String cityOrLocalityValue) {
		this.cityOrLocalityValue = cityOrLocalityValue;
		
	}
	public String getStateOrProvinceValue() {
		return stateOrProvinceValue;
		
	}
	public void setStateOrProvinceValue(String stateOrProvinceValue) {
		this.stateOrProvinceValue = stateOrProvinceValue;
		
	}
	public String getCountryCodeValue() {
		return countryCodeValue;
		
	}
	public void setCountryCodeValue(String countryCodeValue) {
		this.countryCodeValue = countryCodeValue;
		
	}
	
	@Override
	public String toString () {
		String result = "";
		
		result += this.keyStoreFileNameValue + ", " + this.firstAndLastNameValue +
				", " + this.organizationalUnitValue + ", " + this.organizationValue +
				", " + this.cityOrLocalityValue + ", " + this.stateOrProvinceValue +
				", " + this.countryCodeValue;
		
		return result;
	}
	
}
