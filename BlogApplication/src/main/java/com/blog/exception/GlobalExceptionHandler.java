package com.blog.exception;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails>UserExceptionHandle(UserException ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());
        myErrorDetails.setMessage(ex.getMessage());
        myErrorDetails.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails>AdminExceptionHandle(AdminException ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());
        myErrorDetails.setMessage(ex.getMessage());
        myErrorDetails.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<MyErrorDetails>CategoryExceptionHandle(CategoryException ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());
        myErrorDetails.setMessage(ex.getMessage());
        myErrorDetails.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostException.class)
    public ResponseEntity<MyErrorDetails>PostExceptionHandle(PostException ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());
        myErrorDetails.setMessage(ex.getMessage());
        myErrorDetails.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommentException.class)
    public ResponseEntity<MyErrorDetails> PostExceptionHandle(CommentException ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());
        myErrorDetails.setMessage(ex.getMessage());
        myErrorDetails.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> ValidationExceptionHandle(MethodArgumentNotValidException ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());

        myErrorDetails.setMessage("Validation failed !!");

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
e
        List<String> errorMessages = MethodArgumentNotValidException.errorsToStringList(allErrors);


        myErrorDetails.setDescription(String.join(", ", errorMessages));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandle(Exception ex, WebRequest wr){
        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setTimeStamp(LocalDate.now());
        myErrorDetails.setMessage(ex.getMessage());
        myErrorDetails.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
