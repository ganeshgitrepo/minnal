/**
 * 
 */
package org.minnal.core.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.minnal.core.db.C3P0DataSourceProvider;
import org.minnal.core.db.DataSourceProvider;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ganeshs
 *
 */
public class DatabaseConfiguration {

	@JsonProperty(required=true)
	private String url;
	
	@JsonProperty(required=true)
	private String username;
	
	private String password = "";
	
	@JsonProperty(required=true)
	private String driverClass;
	
	private int idleConnectionTestPeriod = 300;
	
	private int maxSize = 100;
	
	private int minSize = 10;
	
	private List<String> packagesToScan = new ArrayList<String>();
	
	private Map<String, String> providerProperties = new HashMap<String, String>();
	
	private boolean readOnly = false;
	
	@JsonIgnore
	private DataSourceProvider dataSourceProvider;
	
	public DatabaseConfiguration() {
		 setDataSourceProvider(new C3P0DataSourceProvider());
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the driverClass
	 */
	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * @param driverClass the driverClass to set
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	/**
	 * @return the idleConnectionTestPeriod
	 */
	public int getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	/**
	 * @param idleConnectionTestPeriod the idleConnectionTestPeriod to set
	 */
	public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the minSize
	 */
	public int getMinSize() {
		return minSize;
	}

	/**
	 * @param minSize the minSize to set
	 */
	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	/**
	 * @return the providerProperties
	 */
	public Map<String, String> getProviderProperties() {
		return providerProperties;
	}

	/**
	 * @param providerProperties the providerProperties to set
	 */
	public void setProviderProperties(Map<String, String> providerProperties) {
		this.providerProperties = providerProperties;
	}

	/**
	 * @return the packagesToScan
	 */
	public List<String> getPackagesToScan() {
		return packagesToScan;
	}

	/**
	 * @param packagesToScan the packagesToScan to set
	 */
	public void setPackagesToScan(List<String> packagesToScan) {
		this.packagesToScan = packagesToScan;
	}

	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * @return the dataSourceProvider
	 */
	public DataSourceProvider getDataSourceProvider() {
		return dataSourceProvider;
	}

	/**
	 * @param dataSourceProvider the dataSourceProvider to set
	 */
	public void setDataSourceProvider(DataSourceProvider dataSourceProvider) {
		dataSourceProvider.setConfiguration(this);
		this.dataSourceProvider = dataSourceProvider;
	}

	@Override
	public String toString() {
		return "DatabaseConfiguration [url=" + url + ", username=" + username
				+ ", password=" + password + ", driverClass=" + driverClass
				+ ", idleConnectionTestPeriod=" + idleConnectionTestPeriod
				+ ", maxSize=" + maxSize + ", minSize=" + minSize
				+ ", packagesToScan=" + packagesToScan
				+ ", providerProperties=" + providerProperties + ", readOnly="
				+ readOnly + "]";
	}

}
