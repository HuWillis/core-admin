layui.use('form', function(){
  var form = layui.form;

  // 监听提交
  form.on('submit(login)', function(data){
    // 在这里可以进行表单数据的处理，比如发起登录请求
    console.log(data.field); // 获取表单数据
    // 进行 AJAX 请求，示例：
    /*
    $.ajax({
        url: '/api/login',
        type: 'POST',
        data: data.field,
        success: function(res) {
            if (res.success) {
                // 登录成功，重定向或其他操作
                window.location.href = '/dashboard';
            } else {
                // 登录失败，显示错误信息
                layer.msg(res.message);
            }
        }
    });
    */
    layer.msg('登录成功'); // 仅为示例
    return false; // 阻止表单提交
  });
});
