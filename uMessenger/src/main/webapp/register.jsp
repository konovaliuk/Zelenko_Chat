<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<title>uMessenger</title>
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body>
    <div id = "header">
        <h1>
            Enter your details, please:
        </h1>
    </div>
    <div class="card">
        <div class="card-header">
            Register form
        </div>
        <div class="card-body">
            <form action="./register" method="POST">
                <div class="form-group">
                    <label for="Username">Username</label>
                        <label class="err"> ${user_error_message}</label>
                    <input type="text" class="form-control" id="Username" name="Username" placeholder="stepan_andrijovich09">
                </div>

                <div class="form-group">
                    <label for="PhoneNumber">Phone Number +380</label> 

                        <label class="err">${phone_error_message}</label>

                    <input type="tel" class="form-control" id="PhoneNumber" name="PhoneNumber" placeholder="950000000">
                </div>

                <div class="form-group">
                    <label for="Password">Password</label>
                    <input type="password" class="form-control" id="Password" name="Password">
                </div>

                <div class="form-group">
                    <label for="PasswordConfirm">Confirm Password</label>


                        <label class="err">${pass_error_message}</label>

                    
                    <input type="password" class="form-control" id="PasswordConfirm" name="PasswordConfirm">
                </div>

                
                <button type="submit" class="btn btn-primary">Sign up</button>
            </form>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
</body>
</html>