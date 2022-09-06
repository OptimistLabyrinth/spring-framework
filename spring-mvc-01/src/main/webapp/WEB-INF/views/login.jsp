<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/login.do" method="POST">
        <div>
            Name : <input name="name" type="text" />
        </div>
        <div>
            Password : <input name="password" type="password" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form>
</body>
</html>