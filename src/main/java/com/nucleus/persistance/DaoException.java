package com.nucleus.persistance;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public DaoException(String arg0) {
		super(arg0);
		
	}

	public DaoException(Throwable arg0) {
		super(arg0);
		
	}

}
