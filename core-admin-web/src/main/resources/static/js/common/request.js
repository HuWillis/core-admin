// request.js
layui.use(['jquery'], function () {
  var $ = layui.jquery;

  // 封装GET请求
  function get(url, params, callback) {
    $.ajax({
      url: ctx + url,
      type: 'GET',
      data: params,
      success: function (response) {
        handleAjaxSuccess(response, callback);
      },
      error: function (xhr, status, error) {
        handleAjaxError(xhr, status, error, url);
      }
    });
  }

  // 封装POST请求
  function post(url, data, callback) {
    $.ajax({
      url: ctx + url,
      type: 'POST',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function (response) {
        handleAjaxSuccess(response, callback);
      },
      error: function (xhr, status, error) {
        handleAjaxError(xhr, status, error, url);
      }
    });
  }

  // 封装PUT请求
  function put(url, data, callback) {
    $.ajax({
      url: ctx + url,
      type: 'PUT',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function (response) {
        handleAjaxSuccess(response, callback);
      },
      error: function (xhr, status, error) {
        handleAjaxError(xhr, status, error, url);
      }
    });
  }

  // 封装DELETE请求
  function del(url, callback) {
    $.ajax({
      url: ctx + url,
      type: 'DELETE',
      success: function (response) {
        handleAjaxSuccess(response, callback);
      },
      error: function (xhr, status, error) {
        handleAjaxError(xhr, status, error, url);
      }
    });
  }

  // 统一处理AJAX成功
  function handleAjaxSuccess(response, callback) {
    if (response.code !== 200) {
      layer.msg(response.msg, {
        icon: 2,
        time: 1000,
        offset: 'rt',
        success: function (layero) {
          layero.find('.layui-layer-content').css('color', 'red');
        }
      });
    } else {
      if (callback) {
        callback(response);
      }
    }
  }

  // 统一处理AJAX错误
  function handleAjaxError(xhr, status, error, url) {
    switch (xhr.status) {
      case 403:
        // 未授权
        window.location.href = ctx + '/error/403';
        break;
      case 404:
        console.error('请求失败: 404 Not Found');
        // 弹出右上角的提示框，1秒后自动消失
        layer.msg(url + '接口不存在', {
          icon: 7,
          time: 1000,
          offset: 'rt',
          success: function (layero) {
            // 调整图标的大小
            layero.find('.layui-layer-content').css({
              'color': '#FFA500'
            });
          }
        });
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
