layui.use(function () {
  var form = layui.form;
  var layer = layui.layer;


  form.on('submit(login)', function (data) {
    // 获取表单字段值
    var field = data.field;
    // 显示填写结果，仅作演示用
    layer.alert(JSON.stringify(field), {
      title: '当前填写的字段值'
    });
    postRequest("/core-admin//auth/login/login", field,function () {

    })
    // 阻止默认 form 跳转
    return false;

  });
})

