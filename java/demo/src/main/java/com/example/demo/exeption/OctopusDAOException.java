


package com.example.demo.exeption;

public class OctopusDAOException extends Exception {
    private static final long serialVersionUID = 1997753363232807009L;

    // Default fault code and message
    public static String FAULT_CODE = "NOK";
    public static String OK_CODE = "OK";
    public static String FAULT_MESSAGE = "Internal Error occurred";
    private String faultcode = FAULT_CODE;
    private String faultstring = FAULT_MESSAGE;

    // Customer-related exception codes
    public static String CUSTOMER_ALREADY_EXIST = "CUS116";
    public static String CUSTOMER_DOES_NOT_EXIST = "CUS106";
    public static String CUSTOMER_ADD_FAIL = "CUS115";

    // Constructors
    public OctopusDAOException() {
        super(FAULT_MESSAGE);
    }

    public OctopusDAOException(String message) {
        super(message);
        this.faultstring = message;
    }

    public OctopusDAOException(String message, String faultcode) {
        super(message);
        this.faultstring = message;
        this.faultcode = faultcode;
    }

    // Getter for the fault code
    public String getFaultCode() {
        return faultcode;
    }

    // Getter for the fault message
    public String getFaultMessage() {
        return faultstring;
    }

    // Example for setting custom messages and fault codes
    public static OctopusDAOException customerAlreadyExists() {
        return new OctopusDAOException("Customer already exists", CUSTOMER_ALREADY_EXIST);
    }

    public static OctopusDAOException customerDoesNotExist() {
        return new OctopusDAOException("Customer does not exist", CUSTOMER_DOES_NOT_EXIST);
    }

    public static OctopusDAOException failedToAddCustomer() {
        return new OctopusDAOException("Failed to add customer", CUSTOMER_ADD_FAIL);
    }
}



