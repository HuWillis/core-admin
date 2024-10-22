// request.js
layui.use(['jquery'], function() {
  var $ = layui.jquery;

  // 封装GET请求
  function get(url, params, callback) {
    $.ajax({
      url: url,
      type: 'GET',
      data: params,
      success: function(response) {
        if (callback) callback(response);
      },
      error: function(xhr, status, error) {
        handleAjaxError(xhr, status, error);
      }
    });
  }

  // 封装POST请求
  function post(url, data, callback) {
    $.ajax({
      url: url,
      type: 'POST',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function(response) {
        if (callback) callback(response);
      },
      error: function(xhr, status, error) {
        handleAjaxError(xhr, status, error);
      }
    });
  }

  // 封装PUT请求
  function put(url, data, callback) {
    $.ajax({
      url: url,
      type: 'PUT',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function(response) {
        if (callback) callback(response);
      },
      error: function(xhr, status, error) {
        handleAjaxError(xhr, status, error);
      }
    });
  }

  // 封装DELETE请求
  function del(url, callback) {
    $.ajax({
      url: url,
      type: 'DELETE',
      success: function(response) {
        if (callback) callback(response);
      },
      error: function(xhr, status, error) {
        handleAjaxError(xhr, status, error);
      }
    });
  }

  // 统一处理AJAX错误
  function handleAjaxError(xhr, status, error) {
    switch (xhr.status) {
      case 403:
        console.error('请求失败: 403 Forbidden');
        window.location.href = ctx + '/error/403';
        break;
      case 404:
        console.error('请求失败: 404 Not Found');
        break;
      case 500:
        console.error('请求失败: 500 Internal Server Error');
        // 可以在这里添加具体的处理逻辑，例如显示服务器内部错误的提示
        break;
      default:
        console.error('请求失败:', error);
        // 处理其他未预见的错误
        break;
    }
  }

  // 导出这些函数以便外部调用
  window.request = {
    get: get,
    post: post,
    put: put,
    delete: del
  };
});
