<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<body>
<body>
  <div class="container">
    <h1>This is secured!</h1>
    <p>
      Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>
    </p>
  </div>
</html>
