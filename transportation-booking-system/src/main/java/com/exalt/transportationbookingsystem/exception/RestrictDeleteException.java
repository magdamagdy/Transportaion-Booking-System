package com.exalt.transportationbookingsystem.exception;

/**
 * The type Restrict delete exception.
 */
public class RestrictDeleteException extends Exception{

  /**
   * Instantiates a new Restrict delete exception.
   * This exception is thrown on trying to delete an object that is referenced by another object in database
   * @param errorMessage the error message
   */
  public RestrictDeleteException (String errorMessage){
    super(errorMessage);
  }

}
