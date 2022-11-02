package com.exalt.transportationbookingsystem.exception;

public class AlreadyExistException extends Exception{

  public AlreadyExistException (String errorMessage){
    super(errorMessage);
  }

}
