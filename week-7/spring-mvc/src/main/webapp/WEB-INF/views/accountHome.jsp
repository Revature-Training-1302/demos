<!-- JSTL includes, Spring Form Tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
    </head>
    <body>
        <h3>Please enter your account details: </h3>
        <%-- Setting up this form to submit a post request when we submit the data:--%>
        <%-- The specific request is denoted by the location /addAccount --%>
        <%-- The model that we are using is the account object --%>
        <form:form method="POST" action="/addAccount" modelAttribute="account">
            <table>
                <tr>
                    <td><form:label path = "id">Id</form:label></td>
                    <td><form:input path = "id"/></td>
                </tr>

                <tr>
                    <td><form:label path = "name">Name</form:label></td>
                    <td><form:input path = "name"/></td>
                </tr>

                <tr>
                    <td><form:label path = "password">Password</form:label></td>
                    <td><form:input path = "password"/></td>
                </tr>
                <tr>
                    <td><input type = "submit" value = "Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>


</html>