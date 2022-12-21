package com.online_shopping.employee.serviceImpl;

public final class RestEndpoints {

  public static final String BASE_URL = "/api/v1/";
  public static final String ID = "/{id}";

  public static final String EMPLOYEE_API = BASE_URL + "employee";
  public static final String EMPLOYEE_POST_API = EMPLOYEE_API;
  public static final String EMPLOYEE_BULK_POST_API = BASE_URL + "employees";
  public static final String EMPLOYEE_GET_ALL_API = BASE_URL + "employees";
  public static final String EMPLOYEE_GET_BY_ID_API = EMPLOYEE_API + ID;
  public static final String EMPLOYEE_GET_BY_EMAIL_API = EMPLOYEE_API + "/email";
  public static final String EMPLOYEE_UPDATE_API = EMPLOYEE_API + ID;
  public static final String EMPLOYEE_DELETE_API = EMPLOYEE_API + ID;

}
