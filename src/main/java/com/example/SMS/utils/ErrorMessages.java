package com.example.SMS.utils;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELDS("Missing required fields, Please fill the required fields"),
    RECORD_ALREADY_EXIST("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    RECORD_NOT_FOUND("Record with provided id is not found"),
    COUlD_NOT_UPDATE_RECORD("Could not update the Record"),
    COULD_NOT_DELETE_RECORD("Could not delete the Record"),
    COURSE_ADDED_FAILED("Course can't be Enrolled"),
    COURSE_ALREADY_ENROLLED("Student already enrolled to this course"),
    NO_ENROLLMENT_FOUND("No enrollment found with this id");

    private String errorMessage;

    ErrorMessages(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}
