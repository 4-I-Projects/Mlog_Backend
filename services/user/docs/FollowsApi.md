# FollowsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1UsersTargetUserIdFollowDelete**](FollowsApi.md#apiV1UsersTargetUserIdFollowDelete) | **DELETE** /api/v1/users/{target_user_id}/follow | Unfollow a user
[**apiV1UsersTargetUserIdFollowPost**](FollowsApi.md#apiV1UsersTargetUserIdFollowPost) | **POST** /api/v1/users/{target_user_id}/follow | Follow a user (author)
[**apiV1UsersUserIdFollowersGet**](FollowsApi.md#apiV1UsersUserIdFollowersGet) | **GET** /api/v1/users/{user_id}/followers | Get list of followers
[**apiV1UsersUserIdFollowingGet**](FollowsApi.md#apiV1UsersUserIdFollowingGet) | **GET** /api/v1/users/{user_id}/following | Get list of following

<a name="apiV1UsersTargetUserIdFollowDelete"></a>
# **apiV1UsersTargetUserIdFollowDelete**
> apiV1UsersTargetUserIdFollowDelete(targetUserId)

Unfollow a user

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FollowsApi;


FollowsApi apiInstance = new FollowsApi();
Object targetUserId = null; // Object | 
try {
    apiInstance.apiV1UsersTargetUserIdFollowDelete(targetUserId);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowsApi#apiV1UsersTargetUserIdFollowDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **targetUserId** | [**Object**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1UsersTargetUserIdFollowPost"></a>
# **apiV1UsersTargetUserIdFollowPost**
> apiV1UsersTargetUserIdFollowPost(targetUserId)

Follow a user (author)

Action: Current logged-in user follows &#x60;target_user_id&#x60;. Use case: Use this when clicking \&quot;Follow\&quot; on a Profile or on a Post (get authorId from post data). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FollowsApi;


FollowsApi apiInstance = new FollowsApi();
Object targetUserId = null; // Object | The ID of the user/author to follow
try {
    apiInstance.apiV1UsersTargetUserIdFollowPost(targetUserId);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowsApi#apiV1UsersTargetUserIdFollowPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **targetUserId** | [**Object**](.md)| The ID of the user/author to follow |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1UsersUserIdFollowersGet"></a>
# **apiV1UsersUserIdFollowersGet**
> UserListResponse apiV1UsersUserIdFollowersGet(userId, page, limit)

Get list of followers

List of people who are following &#x60;user_id&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FollowsApi;


FollowsApi apiInstance = new FollowsApi();
Object userId = null; // Object | 
Object page = 1; // Object | 
Object limit = 20; // Object | 
try {
    UserListResponse result = apiInstance.apiV1UsersUserIdFollowersGet(userId, page, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowsApi#apiV1UsersUserIdFollowersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | [**Object**](.md)|  |
 **page** | [**Object**](.md)|  | [optional] [default to 1]
 **limit** | [**Object**](.md)|  | [optional] [default to 20]

### Return type

[**UserListResponse**](UserListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1UsersUserIdFollowingGet"></a>
# **apiV1UsersUserIdFollowingGet**
> UserListResponse apiV1UsersUserIdFollowingGet(userId, page, limit)

Get list of following

List of people that &#x60;user_id&#x60; is following.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FollowsApi;


FollowsApi apiInstance = new FollowsApi();
Object userId = null; // Object | 
Object page = 1; // Object | 
Object limit = 20; // Object | 
try {
    UserListResponse result = apiInstance.apiV1UsersUserIdFollowingGet(userId, page, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowsApi#apiV1UsersUserIdFollowingGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | [**Object**](.md)|  |
 **page** | [**Object**](.md)|  | [optional] [default to 1]
 **limit** | [**Object**](.md)|  | [optional] [default to 20]

### Return type

[**UserListResponse**](UserListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

