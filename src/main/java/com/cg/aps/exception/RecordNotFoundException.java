package com.cg.aps.exception;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}

}
