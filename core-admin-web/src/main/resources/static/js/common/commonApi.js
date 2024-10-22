// commonApi.js
layui.define(['jquery', 'layer'], function(exports) {
  const $ = layui.jquery;
  const layer = layui.layer;
  /*const baseUrl = 'http://your.api.url'; */
  // 替换为你的API基础URL
  var baseUrl = "http://127.0.0.1:10101/core-admin";
  console.log(baseUrl);

  // 通用请求函数
  const request = (method, url, data = {}, customErrorHandler) => {
    return new Promise((resolve, reject) => {
      $.ajax({
        method: method,
        url: `${baseUrl}${url}`,
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        success: function(response) {
          if (response.code === 0) {
            resolve(response.data);
          } else {
            if (customErrorHandler) {
              // 执行自定义错误处理函数
              customErrorHandler(response);
            } else {
              handleError(response); // 执行默认错误处理
            }
            reject(response);
          }
        },
        error: function(jqXHR) {
          handleAjaxError(jqXHR);
          reject(jqXHR);
        }
      });
    });
  };

  // 处理常见错误
  const handleError = (response) => {
    let message = response.message || '发生了一个未知错误！';
    switch (response.code) {
      case 400:
        message = '请求错误，请检查您的输入！';
        break;
      case 401:
        message = '未授权，请登录！';
        // 可以添加重定向到登录页的逻辑
        break;
      case 403:
        message = '您没有权限访问该资源！';
        break;
      case 404:
        message = '请求的资源未找到！';
        break;
      case 409:
        message = '请求冲突，请检查您的数据！';
        break;
      case 500:
        message = '服务器内部错误，请稍后重试！';
        break;
      default:
        // 可以对非标准错误码进行处理
        layer.msg(message, { icon: 2 });
        return; // 直接返回，避免重复提示
    }
    // 显示错误信息的模态框
    layer.open({
      title: '错误',
      content: message,
      icon: 2,
      btn: ['确定']
    });
  };

  // 处理AJAX请求错误
  const handleAjaxError = (jqXHR) => {
    console.log('AJAX请求错误：', jqXHR)

    const errorMsg = jqXHR.status ? `Error: ${jqXHR.status} ${jqXHR.statusText}` : '网络错误，请检查您的连接！';
    layer.msg(errorMsg, { icon: 2 });
  };

  // 封装RESTful接口方法
  const commonApi = {
    get: (url, params, customErrorHandler) => {
      const queryParams = params ? '?' + $.param(params) : '';
      return request('GET', url + queryParams, null, customErrorHandler);
    },
    post: (url, data, customErrorHandler) => request('POST', url, data, customErrorHandler),
    put: (url, data, customErrorHandler) => request('PUT', url, data, customErrorHandler),
    delete: (url, data, customErrorHandler) => request('DELETE', url, data, customErrorHandler)
  };

  // 导出API接口
  exports('commonApi', commonApi);
});
