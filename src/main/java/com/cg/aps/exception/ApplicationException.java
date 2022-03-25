package com.cg.aps.exception;

public class ApplicationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg : Error message
	 */
	public ApplicationException(String msg) {
		super(msg);
	}

}
