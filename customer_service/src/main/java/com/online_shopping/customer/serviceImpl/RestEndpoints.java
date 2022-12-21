package com.online_shopping.customer.serviceImpl;

public final class RestEndpoints {

  public static final String BASE_URL = "/api/v1/";
  public static final String ID = "/{id}";

  public static final String CUSTOMER_API = BASE_URL + "customer";
  public static final String CUSTOMER_POST_API = CUSTOMER_API;
  public static final String CUSTOMER_BULK_POST_API = BASE_URL + "customers";
  public static final String CUSTOMER_GET_ALL_API = BASE_URL + "customers";
  public static final String CUSTOMER_GET_BY_ID_API = CUSTOMER_API + ID;
  public static final String CUSTOMER_GET_BY_EMAIL_API = CUSTOMER_API + "/email";
  public static final String CUSTOMER_UPDATE_API = CUSTOMER_API + ID;
  public static final String CUSTOMER_DELETE_API = CUSTOMER_API + ID;

}
