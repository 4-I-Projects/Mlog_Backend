# KeycloakApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1AuthCallbackGet**](KeycloakApi.md#apiV1AuthCallbackGet) | **GET** /api/v1/auth/callback | OAuth2 callback endpoint for Keycloak
[**apiV1AuthGet**](KeycloakApi.md#apiV1AuthGet) | **GET** /api/v1/auth | Redirect to Keycloak account management page
[**apiV1AuthLoginGet**](KeycloakApi.md#apiV1AuthLoginGet) | **GET** /api/v1/auth/login | Redirect user to Keycloak for login
[**apiV1AuthLogoutGet**](KeycloakApi.md#apiV1AuthLogoutGet) | **GET** /api/v1/auth/logout | Logout user and end Keycloak session
[**apiV1AuthPasswordResetGet**](KeycloakApi.md#apiV1AuthPasswordResetGet) | **GET** /api/v1/auth/password/reset | Redirect to Keycloak password reset page
[**apiV1AuthRegisterGet**](KeycloakApi.md#apiV1AuthRegisterGet) | **GET** /api/v1/auth/register | Redirect to Keycloak registration page

<a name="apiV1AuthCallbackGet"></a>
# **apiV1AuthCallbackGet**
> apiV1AuthCallbackGet(code)

OAuth2 callback endpoint for Keycloak

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.KeycloakApi;


KeycloakApi apiInstance = new KeycloakApi();
Object code = null; // Object | 
try {
    apiInstance.apiV1AuthCallbackGet(code);
} catch (ApiException e) {
    System.err.println("Exception when calling KeycloakApi#apiV1AuthCallbackGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | [**Object**](.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1AuthGet"></a>
# **apiV1AuthGet**
> apiV1AuthGet()

Redirect to Keycloak account management page

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.KeycloakApi;


KeycloakApi apiInstance = new KeycloakApi();
try {
    apiInstance.apiV1AuthGet();
} catch (ApiException e) {
    System.err.println("Exception when calling KeycloakApi#apiV1AuthGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1AuthLoginGet"></a>
# **apiV1AuthLoginGet**
> apiV1AuthLoginGet()

Redirect user to Keycloak for login

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.KeycloakApi;


KeycloakApi apiInstance = new KeycloakApi();
try {
    apiInstance.apiV1AuthLoginGet();
} catch (ApiException e) {
    System.err.println("Exception when calling KeycloakApi#apiV1AuthLoginGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1AuthLogoutGet"></a>
# **apiV1AuthLogoutGet**
> apiV1AuthLogoutGet()

Logout user and end Keycloak session

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.KeycloakApi;


KeycloakApi apiInstance = new KeycloakApi();
try {
    apiInstance.apiV1AuthLogoutGet();
} catch (ApiException e) {
    System.err.println("Exception when calling KeycloakApi#apiV1AuthLogoutGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1AuthPasswordResetGet"></a>
# **apiV1AuthPasswordResetGet**
> apiV1AuthPasswordResetGet()

Redirect to Keycloak password reset page

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.KeycloakApi;


KeycloakApi apiInstance = new KeycloakApi();
try {
    apiInstance.apiV1AuthPasswordResetGet();
} catch (ApiException e) {
    System.err.println("Exception when calling KeycloakApi#apiV1AuthPasswordResetGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1AuthRegisterGet"></a>
# **apiV1AuthRegisterGet**
> apiV1AuthRegisterGet()

Redirect to Keycloak registration page

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.KeycloakApi;


KeycloakApi apiInstance = new KeycloakApi();
try {
    apiInstance.apiV1AuthRegisterGet();
} catch (ApiException e) {
    System.err.println("Exception when calling KeycloakApi#apiV1AuthRegisterGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

