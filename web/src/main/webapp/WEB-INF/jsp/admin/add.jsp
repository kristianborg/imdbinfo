<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" commandName="crawlUrl">
    <div class="form">
        <label>
            <span>IMDB Url to crawl</span>
            <form:input path="imdbUrl" type="text" class="input_text"/>
        </label>
        <label>
            <span>IMDB Url to crawl</span>
            <form:select path="crawlDepth" class="input_text">
                <form:option value="1"/>
                <form:option value="2"/>
                <form:option value="3"/>
            </form:select>
        </label>
        <label>
            <input type="submit" class="button"/>
        </label>
    </div>
</form:form>