// 通用模块 common.js

var common = {
  // 全局 API 基础路径
  apiBaseUrl: '/api',

  // 通用的 Fetch 请求封装
  fetchData: function (url, method, body, callback) {
    fetch(common.apiBaseUrl + url, {
      method: method,
      headers: {
        'Content-Type': 'application/json'
      },
      body: body ? JSON.stringify(body) : null
    }).then(response => response.json())
    .then(data => callback(data))
    .catch(error => {
      console.error('请求出错', error);
    });
  },

  // 获取URL中的参数
  getQueryVariable: function (variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
      var pair = vars[i].split("=");
      if (pair[0] == variable) {
        return pair[1];
      }
    }
    return false;
  },

  // 通用的日期格式化
  formatDate: function (date, format) {
    var d = new Date(date);
    var year = d.getFullYear();
    var month = (d.getMonth() + 1).toString().padStart(2, '0');
    var day = d.getDate().toString().padStart(2, '0');
    var hours = d.getHours().toString().padStart(2, '0');
    var minutes = d.getMinutes().toString().padStart(2, '0');
    var seconds = d.getSeconds().toString().padStart(2, '0');

    return format.replace('yyyy', year)
    .replace('MM', month)
    .replace('dd', day)
    .replace('HH', hours)
    .replace('mm', minutes)
    .replace('ss', seconds);
  },

  // 通用的弹窗提示
  showToast: function (message) {
    layui.layer.msg(message);
  }
};
