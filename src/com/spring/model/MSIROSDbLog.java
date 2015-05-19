package com.spring.model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Id;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author Rohit Katyal
 * @category Hibernate Entity Class
 */

public class MSIROSDbLog {

	private String UserId;
	private Timestamp Dated;
	private String LogLevel;
	private String Message;
	@Id
	private int LogId;

	/**
	 * @return the userId
	 */
	public void setLog(String logLevel, String message) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		Dated = new Timestamp(sqlDate.getTime());
		LogLevel = logLevel;
		Message = message;
	}

	public String getUserId() {
		return UserId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		UserId = userId;
	}

	/**
	 * @return the dated
	 */
	public Timestamp getDated() {
		return Dated;
	}

	/**
	 * @param dated
	 *            the dated to set
	 */
	public void setDated(Timestamp dated) {
		Dated = dated;
	}

	/**
	 * @return the logLevel
	 */
	public String getLogLevel() {
		return LogLevel;
	}

	/**
	 * @param logLevel
	 *            the logLevel to set
	 */
	public void setLogLevel(String logLevel) {
		LogLevel = logLevel;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * @return the logId
	 */
	public int getLogId() {
		return LogId;
	}

	/**
	 * @param logId
	 *            the logId to set
	 */
	public void setLogId(int logId) {
		LogId = logId;
	}

}