# LikesApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1PostsPostIdLikesDelete**](LikesApi.md#apiV1PostsPostIdLikesDelete) | **DELETE** /api/v1/posts/{post_id}/likes | Unlike a post
[**apiV1PostsPostIdLikesGet**](LikesApi.md#apiV1PostsPostIdLikesGet) | **GET** /api/v1/posts/{post_id}/likes | Get list of users who liked the post
[**apiV1PostsPostIdLikesPost**](LikesApi.md#apiV1PostsPostIdLikesPost) | **POST** /api/v1/posts/{post_id}/likes | Like a post

<a name="apiV1PostsPostIdLikesDelete"></a>
# **apiV1PostsPostIdLikesDelete**
> apiV1PostsPostIdLikesDelete(postId)

Unlike a post

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LikesApi;


LikesApi apiInstance = new LikesApi();
Object postId = null; // Object | 
try {
    apiInstance.apiV1PostsPostIdLikesDelete(postId);
} catch (ApiException e) {
    System.err.println("Exception when calling LikesApi#apiV1PostsPostIdLikesDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | [**Object**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1PostsPostIdLikesGet"></a>
# **apiV1PostsPostIdLikesGet**
> UserListResponse apiV1PostsPostIdLikesGet(postId, page, limit)

Get list of users who liked the post

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LikesApi;


LikesApi apiInstance = new LikesApi();
Object postId = null; // Object | 
Object page = 1; // Object | 
Object limit = 20; // Object | 
try {
    UserListResponse result = apiInstance.apiV1PostsPostIdLikesGet(postId, page, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LikesApi#apiV1PostsPostIdLikesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | [**Object**](.md)|  |
 **page** | [**Object**](.md)|  | [optional] [default to 1]
 **limit** | [**Object**](.md)|  | [optional] [default to 20]

### Return type

[**UserListResponse**](UserListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1PostsPostIdLikesPost"></a>
# **apiV1PostsPostIdLikesPost**
> apiV1PostsPostIdLikesPost(postId)

Like a post

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LikesApi;


LikesApi apiInstance = new LikesApi();
Object postId = null; // Object | 
try {
    apiInstance.apiV1PostsPostIdLikesPost(postId);
} catch (ApiException e) {
    System.err.println("Exception when calling LikesApi#apiV1PostsPostIdLikesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | [**Object**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

