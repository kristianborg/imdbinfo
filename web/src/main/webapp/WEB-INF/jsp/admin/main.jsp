<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>admin console</title>
        <link rel="stylesheet" href="/web/css/admin.css" type="text/css">
    </head>
    <body>

        <div id="header">
            number of movies: <c:out value="${numMovies}"/> number of actors: <c:out value="${numActors}"/><br/>
        </div>

        <div id="menu">
            <span<c:if test="${pageName=='movies'}"> class="active"</c:if>><a href="movies">List Movies</a></span>
            <span<c:if test="${pageName=='actors'}"> class="active"</c:if>><a href="actors">List Actors</a></span>
            <span<c:if test="${pageName=='add'}"> class="active"</c:if>><a href="add">Add Data</a></span>
        </div>

        <c:import url="${pageName}.jsp"/>


    </body>
</html>
