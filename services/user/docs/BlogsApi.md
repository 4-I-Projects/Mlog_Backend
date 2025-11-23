# BlogsApi

All URIs are relative to *http://localhost:5000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiV1BlogsBlogIdDelete**](BlogsApi.md#apiV1BlogsBlogIdDelete) | **DELETE** /api/v1/blogs/{blog_id} | Delete blog using id
[**apiV1BlogsBlogIdGet**](BlogsApi.md#apiV1BlogsBlogIdGet) | **GET** /api/v1/blogs/{blog_id} | Getting blog by id
[**apiV1BlogsBlogIdPatch**](BlogsApi.md#apiV1BlogsBlogIdPatch) | **PATCH** /api/v1/blogs/{blog_id} | Edit a blog using id
[**apiV1BlogsBlogIdPut**](BlogsApi.md#apiV1BlogsBlogIdPut) | **PUT** /api/v1/blogs/{blog_id} | Edit a blog using id
[**apiV1BlogsGet**](BlogsApi.md#apiV1BlogsGet) | **GET** /api/v1/blogs | Returns list of all blogs
[**apiV1BlogsPost**](BlogsApi.md#apiV1BlogsPost) | **POST** /api/v1/blogs | Creates a new blog

<a name="apiV1BlogsBlogIdDelete"></a>
# **apiV1BlogsBlogIdDelete**
> apiV1BlogsBlogIdDelete()

Delete blog using id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BlogsApi;


BlogsApi apiInstance = new BlogsApi();
try {
    apiInstance.apiV1BlogsBlogIdDelete();
} catch (ApiException e) {
    System.err.println("Exception when calling BlogsApi#apiV1BlogsBlogIdDelete");
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

<a name="apiV1BlogsBlogIdGet"></a>
# **apiV1BlogsBlogIdGet**
> BlogResponse apiV1BlogsBlogIdGet()

Getting blog by id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BlogsApi;


BlogsApi apiInstance = new BlogsApi();
try {
    BlogResponse result = apiInstance.apiV1BlogsBlogIdGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlogsApi#apiV1BlogsBlogIdGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BlogResponse**](BlogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiV1BlogsBlogIdPatch"></a>
# **apiV1BlogsBlogIdPatch**
> BlogResponse apiV1BlogsBlogIdPatch(body)

Edit a blog using id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BlogsApi;


BlogsApi apiInstance = new BlogsApi();
BlogPatchRequest body = new BlogPatchRequest(); // BlogPatchRequest | 
try {
    BlogResponse result = apiInstance.apiV1BlogsBlogIdPatch(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlogsApi#apiV1BlogsBlogIdPatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**BlogPatchRequest**](BlogPatchRequest.md)|  |

### Return type

[**BlogResponse**](BlogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiV1BlogsBlogIdPut"></a>
# **apiV1BlogsBlogIdPut**
> BlogResponse apiV1BlogsBlogIdPut(body)

Edit a blog using id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BlogsApi;


BlogsApi apiInstance = new BlogsApi();
BlogCreateRequest body = new BlogCreateRequest(); // BlogCreateRequest | 
try {
    BlogResponse result = apiInstance.apiV1BlogsBlogIdPut(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlogsApi#apiV1BlogsBlogIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**BlogCreateRequest**](BlogCreateRequest.md)|  |

### Return type

[**BlogResponse**](BlogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiV1BlogsGet"></a>
# **apiV1BlogsGet**
> Object apiV1BlogsGet()

Returns list of all blogs

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BlogsApi;


BlogsApi apiInstance = new BlogsApi();
try {
    Object result = apiInstance.apiV1BlogsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlogsApi#apiV1BlogsGet");
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

<a name="apiV1BlogsPost"></a>
# **apiV1BlogsPost**
> BlogResponse apiV1BlogsPost(body)

Creates a new blog

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BlogsApi;


BlogsApi apiInstance = new BlogsApi();
BlogCreateRequest body = new BlogCreateRequest(); // BlogCreateRequest | 
try {
    BlogResponse result = apiInstance.apiV1BlogsPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlogsApi#apiV1BlogsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**BlogCreateRequest**](BlogCreateRequest.md)|  |

### Return type

[**BlogResponse**](BlogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

