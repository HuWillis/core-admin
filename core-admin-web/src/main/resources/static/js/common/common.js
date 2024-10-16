/**
 * 发送 GET 请求
 * @param {string} url - 请求的 URL
 * @param {object} params - 请求参数对象
 * @param {function} successCallback - 请求成功后的回调函数
 * @param {function} errorCallback - 请求失败后的回调函数
 */
function getRequest(url, params, successCallback, errorCallback) {
  $.ajax({
    url: url,
    type: 'GET',
    data: params,
    // 由业务自行处理成功响应
    success: successCallback,
    // 由业务自行处理失败响应
    error: errorCallback
  });
}

/**
 * 发送 POST 请求
 * @param {string} url - 请求的 URL
 * @param {object} data - 请求体中的数据对象
 * @param {function} successCallback - 请求成功后的回调函数
 * @param {function} errorCallback - 请求失败后的回调函数
 */
function postRequest(url, data, successCallback, errorCallback) {
  $.ajax({
    url: url,
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(data),
    // 由业务自行处理成功响应
    success: successCallback,
    // 由业务自行处理失败响应
    error: errorCallback
  });
}

/**
 * 根据错误码跳转到不同的错误页面
 * @param {number} errorCode - 错误码
 */
function handleErrorCode(errorCode) {
  switch (errorCode) {
    case 400:
      // 跳转到 400 错误页面
      window.location.href = '/error/400';
      break;
    case 401:
      // 跳转到 401 错误页面
      window.location.href = '/error/401';
      break;
    case 403:
      // 跳转到 403 错误页面
      window.location.href = '/error/403';
      break;
    case 404:
      // 跳转到 404 错误页面
      window.location.href = '/error/404';
      break;
    case 500:
      // 跳转到 500 错误页面
      window.location.href = '/error/500';
      break;
    default:
      // 跳转到默认错误页面
      window.location.href = '/error/default';
      break;
  }
}
