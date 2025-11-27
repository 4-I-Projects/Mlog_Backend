# AdminApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1AdminUsersUserIdBanPost**](AdminApi.md#apiV1AdminUsersUserIdBanPost) | **POST** /api/v1/admin/users/{user_id}/ban | Ban user with user_id
[**apiV1AdminUsersUserIdUnbanPost**](AdminApi.md#apiV1AdminUsersUserIdUnbanPost) | **POST** /api/v1/admin/users/{user_id}/unban | Unban user with user_id

<a name="apiV1AdminUsersUserIdBanPost"></a>
# **apiV1AdminUsersUserIdBanPost**
> apiV1AdminUsersUserIdBanPost(body, userId)

Ban user with user_id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminApi;


AdminApi apiInstance = new AdminApi();
UserIdBanBody body = new UserIdBanBody(); // UserIdBanBody | Informations about why the user is banned
Object userId = null; // Object | 
try {
    apiInstance.apiV1AdminUsersUserIdBanPost(body, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminApi#apiV1AdminUsersUserIdBanPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserIdBanBody**](UserIdBanBody.md)| Informations about why the user is banned |
 **userId** | [**Object**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="apiV1AdminUsersUserIdUnbanPost"></a>
# **apiV1AdminUsersUserIdUnbanPost**
> apiV1AdminUsersUserIdUnbanPost(body, userId)

Unban user with user_id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminApi;


AdminApi apiInstance = new AdminApi();
UserIdUnbanBody body = new UserIdUnbanBody(); // UserIdUnbanBody | Informations about why the user is unbanned
Object userId = null; // Object | 
try {
    apiInstance.apiV1AdminUsersUserIdUnbanPost(body, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminApi#apiV1AdminUsersUserIdUnbanPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserIdUnbanBody**](UserIdUnbanBody.md)| Informations about why the user is unbanned |
 **userId** | [**Object**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

