<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<body>
    <div>
        <div>
            <h1>About us</h1>
            <h2>Hello ${message}</h2>
             Click on this <strong><a href="/">link</a></strong> to visit previous page.
             
             <h3>Subscribe to newsletter</h3>
		    <form action="#" th:action="@{/newsletter}" th:object="${greeting}" method="post">
		    	<p>Id: <input type="text" th:field="*{id}" /></p>
		        <p>Message: <input type="text" th:field="*{content}" /></p>
		        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
		    </form>
             
        </div>
    </div>
</body>
</html>