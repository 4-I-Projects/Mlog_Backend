<!DOCTYPE html>
<html>
<head>
    <title>Login - MyTheme</title>
    <link rel="stylesheet" href="${url.resourcesPath}/css/custom.css" />
</head>
<body class="kc-body">

<div class="kc-container">
    <div class="kc-card">
        <h1 class="kc-title">Đăng nhập</h1>

        <form action="${url.loginAction}" method="post">
            <label>Email hoặc Username</label>
            <input type="text" name="username" required>

            <label>Mật khẩu</label>
            <input type="password" name="password" required>

            <button type="submit" class="kc-btn">Đăng nhập</button>
        </form>

        <a class="kc-link" href="${url.registrationUrl}">Tạo tài khoản</a>
    </div>
</div>

</body>
</html>
