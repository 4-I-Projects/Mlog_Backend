# UsersApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1UsersGet**](UsersApi.md#apiV1UsersGet) | **GET** /api/v1/users | Get all users
[**apiV1UsersMeGet**](UsersApi.md#apiV1UsersMeGet) | **GET** /api/v1/users/me | Get my user info
[**apiV1UsersUserIdFollowingsGet**](UsersApi.md#apiV1UsersUserIdFollowingsGet) | **GET** /api/v1/users/{user_id}/followings | Get all users who user_id follows
[**apiV1UsersUserIdGet**](UsersApi.md#apiV1UsersUserIdGet) | **GET** /api/v1/users/{user_id} | Get a specific user with the user_id

<a name="apiV1UsersGet"></a>
# **apiV1UsersGet**
> Object apiV1UsersGet()

Get all users

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
try {
    Object result = apiInstance.apiV1UsersGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#apiV1UsersGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1UsersMeGet"></a>
# **apiV1UsersMeGet**
> UserResponse apiV1UsersMeGet()

Get my user info

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
try {
    UserResponse result = apiInstance.apiV1UsersMeGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#apiV1UsersMeGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1UsersUserIdFollowingsGet"></a>
# **apiV1UsersUserIdFollowingsGet**
> Object apiV1UsersUserIdFollowingsGet()

Get all users who user_id follows

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
try {
    Object result = apiInstance.apiV1UsersUserIdFollowingsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#apiV1UsersUserIdFollowingsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1UsersUserIdGet"></a>
# **apiV1UsersUserIdGet**
> UserResponse apiV1UsersUserIdGet()

Get a specific user with the user_id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsersApi;


UsersApi apiInstance = new UsersApi();
try {
    UserResponse result = apiInstance.apiV1UsersUserIdGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#apiV1UsersUserIdGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

