layui.use(['table', 'layer'], function () {
  var table = layui.table;
  var layer = layui.layer;

  // 初始化用户表格
  table.render({
    elem: '#userTable',
    url: '/api/users',  // 获取用户数据的API
    page: true,
    cols: [[
      {field: 'id', title: 'ID', sort: true},
      {field: 'name', title: '姓名'},
      {field: 'email', title: '邮箱'},
      {field: 'phone', title: '电话'},
      {fixed: 'right', title: '操作', toolbar: '#actionBar'}
    ]]
  });

  // 监听工具条
  table.on('tool(userTable)', function (obj) {
    var data = obj.data;
    var event = obj.event;

    if (event === 'edit') {
      location.href = 'userForm.html?id=' + data.id;  // 传递用户ID，跳转到编辑页面
    } else if (event === 'delete') {
      deleteUser(data.id);
    }
  });
});

// 删除用户
function deleteUser(userId) {
  layer.confirm('确定删除该用户吗？', function (index) {
    userApi.deleteUser(userId, function (response) {
      if (response.success) {
        layui.table.reload('userTable');
        layer.close(index);
      }
    });
  });
}
