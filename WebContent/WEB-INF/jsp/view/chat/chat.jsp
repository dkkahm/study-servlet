<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<h1>Chat Server</h1>
	
	<form>
		<input type="text" name="message" id="message" />
		<input type="button" onclick="button1_clicked();" value="보내기" />
	</form>
	
	<script type="text/javascript" language="javascript">
		var button1_clicked;
		$(document).ready(function() {
			var server;
            try {
                server = new WebSocket('ws://' + window.location.host + '<c:url value="/chat/room" />');
                
                server.open = function(event) {
                	console.log("connection open");
                }
                
                server.onclose = function(event) {
                	console.log("connection closed");
                }
                
                server.onerror = function(event) {
                	console.log("connection error");
                }
                
                server.onmessage = function(event) {
                	var message = event.data;
                	console.log("message: " + message);
                }
            } catch(error) {
            	console.log("Error occured:" + error);
            }
            
    		button1_clicked = function() {
    			// console.log("button clicked");
    			var message = $("#message").val();
    			console.log("Sending message: '" + message + "''");
    			server.send(message);
    		}
		});
		
	</script>
</body>
</html>