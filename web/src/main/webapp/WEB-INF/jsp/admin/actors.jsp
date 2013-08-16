<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="object_list">
    <ul>
        <c:forEach var="actor" items="${actors}">
            <li>${actor.name}</li>
        </c:forEach>
    </ul>
</div>