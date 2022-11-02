package com.exalt.transportationbookingsystem.exception;

/**
 * The type Already exist exception.
 */
public class AlreadyExistException extends Exception{

  /**
   * Instantiates a new Already exist exception.
   * This exception is thrown to prevent redundant duplicate objects in database
   * @param errorMessage the error message
   */
  public AlreadyExistException (String errorMessage){
    super(errorMessage);
  }

}
