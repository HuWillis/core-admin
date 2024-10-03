layui.use(['form', 'layer'], function () {
  var form = layui.form;
  var layer = layui.layer;
  var userId = getQueryVariable('id');  // 获取URL中的用户ID参数

  // 如果有用户ID，加载用户数据
  if (userId) {
    userApi.getUserById(userId, function (data) {
      if (data) {
        form.val('userForm', {
          'name': data.name,
          'email': data.email,
          'phone': data.phone
        });
      }
    });
  }

  // 监听提交事件
  form.on('submit(saveUser)', function (data) {
    if (userId) {
      userApi.updateUser(userId, data.field, function (response) {
        if (response.success) {
          layer.msg('更新成功', {icon: 1, time: 2000}, function () {
            location.href = 'userList.html';
          });
        }
      });
    } else {
      userApi.addUser(data.field, function (response) {
        if (response.success) {
          layer.msg('添加成功', {icon: 1, time: 2000}, function () {
            location.href = 'userList.html';
          });
        }
      });
    }
    return false;  // 阻止表单提交
  });
});

// 获取URL中的参数
function getQueryVariable(variable) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    if (pair[0] == variable) {
      return pair[1];
    }
  }
  return false;
}
