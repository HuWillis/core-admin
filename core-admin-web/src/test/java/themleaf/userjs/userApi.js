var userApi = {
  // 获取用户列表
  getUsers: function (callback) {
    fetch('/api/users', {
      method: 'GET'
    }).then(response => response.json())
    .then(data => callback(data));
  },

  // 根据ID获取单个用户信息
  getUserById: function (id, callback) {
    fetch('/api/users/' + id, {
      method: 'GET'
    }).then(response => response.json())
    .then(data => callback(data));
  },

  // 添加用户
  addUser: function (formData, callback) {
    fetch('/api/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    }).then(response => response.json())
    .then(data => callback(data));
  },

  // 更新用户
  updateUser: function (id, formData, callback) {
    fetch('/api/users/' + id, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    }).then(response => response.json())
    .then(data => callback(data));
  },

  // 删除用户
  deleteUser: function (id, callback) {
    fetch('/api/users/' + id, {
      method: 'DELETE'
    }).then(response => response.json())
    .then(data => callback(data));
  }
};
