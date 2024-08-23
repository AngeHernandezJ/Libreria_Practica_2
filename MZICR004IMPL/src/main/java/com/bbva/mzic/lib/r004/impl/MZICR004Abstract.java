package com.bbva.mzic.lib.r004.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.mzic.lib.r004.MZICR004;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class MZICR004Abstract extends AbstractLibrary implements MZICR004 {

	protected ApplicationConfigurationService applicationConfigurationService;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

}