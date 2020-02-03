<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html>
<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now ${now.x.x}</p>
    
    <c:forEach var="i" begin="0" end="10" step="2">
  	  <p>Un message n°<c:out value="${ i }" /> !</p>
	</c:forEach>
  
  </body>
</html>