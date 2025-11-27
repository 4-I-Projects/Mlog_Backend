# CommentsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1CommentsCommentIdDelete**](CommentsApi.md#apiV1CommentsCommentIdDelete) | **DELETE** /api/v1/comments/{comment_id} | Soft delete a comment
[**apiV1CommentsCommentIdPut**](CommentsApi.md#apiV1CommentsCommentIdPut) | **PUT** /api/v1/comments/{comment_id} | Update comment content
[**apiV1CommentsCommentIdRepliesGet**](CommentsApi.md#apiV1CommentsCommentIdRepliesGet) | **GET** /api/v1/comments/{comment_id}/replies | Get replies of a comment (Lazy loading)
[**apiV1CommentsPost**](CommentsApi.md#apiV1CommentsPost) | **POST** /api/v1/comments | Create a comment or reply
[**apiV1PostsPostIdCommentsGet**](CommentsApi.md#apiV1PostsPostIdCommentsGet) | **GET** /api/v1/posts/{post_id}/comments | Get root comment for a post

<a name="apiV1CommentsCommentIdDelete"></a>
# **apiV1CommentsCommentIdDelete**
> apiV1CommentsCommentIdDelete(commentId)

Soft delete a comment

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Object commentId = null; // Object | 
try {
    apiInstance.apiV1CommentsCommentIdDelete(commentId);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#apiV1CommentsCommentIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commentId** | [**Object**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="apiV1CommentsCommentIdPut"></a>
# **apiV1CommentsCommentIdPut**
> CommentResponse apiV1CommentsCommentIdPut(body, commentId)

Update comment content

User can only edit the content, not the postId or parentId.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
CommentUpdateRequest body = new CommentUpdateRequest(); // CommentUpdateRequest | 
Object commentId = null; // Object | 
try {
    CommentResponse result = apiInstance.apiV1CommentsCommentIdPut(body, commentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#apiV1CommentsCommentIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CommentUpdateRequest**](CommentUpdateRequest.md)|  |
 **commentId** | [**Object**](.md)|  |

### Return type

[**CommentResponse**](CommentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiV1CommentsCommentIdRepliesGet"></a>
# **apiV1CommentsCommentIdRepliesGet**
> CommentListResponse apiV1CommentsCommentIdRepliesGet(commentId, cursor, limit)

Get replies of a comment (Lazy loading)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Object commentId = null; // Object | 
Object cursor = null; // Object | 
Object limit = 5; // Object | 
try {
    CommentListResponse result = apiInstance.apiV1CommentsCommentIdRepliesGet(commentId, cursor, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#apiV1CommentsCommentIdRepliesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commentId** | [**Object**](.md)|  |
 **cursor** | [**Object**](.md)|  | [optional]
 **limit** | [**Object**](.md)|  | [optional] [default to 5]

### Return type

[**CommentListResponse**](CommentListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1CommentsPost"></a>
# **apiV1CommentsPost**
> CommentResponse apiV1CommentsPost(body)

Create a comment or reply

Send &#x60;parentId&#x60; to reply, leave null for root comment.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
CommentCreateRequest body = new CommentCreateRequest(); // CommentCreateRequest | 
try {
    CommentResponse result = apiInstance.apiV1CommentsPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#apiV1CommentsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CommentCreateRequest**](CommentCreateRequest.md)|  |

### Return type

[**CommentResponse**](CommentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiV1PostsPostIdCommentsGet"></a>
# **apiV1PostsPostIdCommentsGet**
> CommentListResponse apiV1PostsPostIdCommentsGet(postId, cursor, limit)

Get root comment for a post

Fetches only top-level comments (parentId &#x3D; null).  Use &#x60;replyCount&#x60; in response to decide whether to fetch replies. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Object postId = null; // Object | 
Object cursor = null; // Object | ID/Time cursor for pagination
Object limit = 10; // Object | 
try {
    CommentListResponse result = apiInstance.apiV1PostsPostIdCommentsGet(postId, cursor, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#apiV1PostsPostIdCommentsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | [**Object**](.md)|  |
 **cursor** | [**Object**](.md)| ID/Time cursor for pagination | [optional]
 **limit** | [**Object**](.md)|  | [optional] [default to 10]

### Return type

[**CommentListResponse**](CommentListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

