<!DOCTYPE html>
<html>
<head>
    <title>Register - MyTheme</title>
    <link rel="stylesheet" href="${url.resourcesPath}/css/custom.css" />
</head>
<body class="kc-body">

<div class="kc-container">
    <div class="kc-card">
        <h1 class="kc-title">Tạo tài khoản</h1>

        <form action="${url.registrationAction}" method="post">

            <label>Họ tên</label>
            <input type="text" name="firstName" required>

            <label>Email</label>
            <input type="email" name="email" required>

            <label>Mật khẩu</label>
            <input type="password" name="password" required>

            <button type="submit" class="kc-btn">Đăng ký</button>
        </form>

        <a class="kc-link" href="${url.loginUrl}">Đã có tài khoản? Đăng nhập</a>
    </div>
</div>

</body>
</html>
