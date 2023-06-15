<%@ page import="models.Groups" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

	<title>uMessage</title>
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body>
    <div id = "chats-header">
        <h1>uMessenger</h1>
        <h5 id = "header-nav"><a href="/uMessenger/logout">Log out</a></h5>
    </div>
    <div id = "chats-footer">
        <div id = "chats-groups">
            <div id = "new-group-creator">
                <h5 id = "header-nav"><a href="/uMessenger/groups">Create new group</a></h5>
            </div>
            <div>
                <ul id = "chats-selector">

                </ul>
            </div>
        </div>
        <div id = "chats-messages">
            chats-messages
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script>
        <% Groups groups[] = (Groups[])request.getAttribute("chats"); %>
        var html = "";
        html += "<li>"+"</li>";
        document.getElementById("chats-selector").innerHTML += html;

        var chats ;
    </script>
    <script>
        var i = 0;
        while(i < chats.length){

            i++;
        }
    </script>
</body>
</html>