
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="form-validation.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript">
        $().ready(function(){
            var url = "${contextPath}/countries";
            $.ajax({
                url: url,
                dataType: "json",
                type: "GET",
                success: function(response) {
                    var selOpts = "";
                    for (i=0;i<response.length;i++)
                    {
                        var id = response[i]['id'];
                        var val = response[i]['name'];
                        selOpts += "<option value='"+val+"'>"+val+"</option>";
                    }
                    $('#country').append(selOpts);

                },
                error: function(jqxhr, status, errorMsg) {
                    alert(status + ": " + errorMsg);
                }
            });
        });
    </script>
</head>

<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h2>Clients</h2>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
    <div class="row">
        <div class="col-md-12 order-md-1">
            <form:form method="POST" action="${contextPath}/editClient" modelAttribute="clientForm" class="needs-validation">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="id" value="${clientById.id}"/>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <spring:bind path="userName">
                            <label for="firstName">First name</label>
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="firstName" class="form-control" placeholder="firstName"
                                            autofocus="true" value="${clientById.firstName}"></form:input>
                                <form:errors path="firstName"></form:errors>
                            </div>
                        </spring:bind>
                    </div>
                    <div class="col-md-6 mb-3">
                        <spring:bind path="lastName">
                            <label for="lastName">Last name</label>
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="lastName" class="form-control" placeholder="lastName"
                                            autofocus="true" value="${clientById.lastName}"></form:input>
                                <form:errors path="lastName"></form:errors>
                            </div>
                        </spring:bind>
                    </div>
                </div>

                <div class="mb-3">
                    <spring:bind path="lastName">
                        <label for="userName">Username</label>
                        <div class="input-group">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="userName" class="form-control" placeholder="userName"
                                            autofocus="true" value="${clientById.userName}"></form:input>
                                <form:errors path="userName"></form:errors>
                            </div>
                        </div>
                    </spring:bind>
                </div>

                <div class="mb-3">
                    <spring:bind path="email">
                        <label for="email">Email <span class="text-muted">(Optional)</span></label>
                        <div class="input-group">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="email" path="email" name="email" class="form-control" id="email" placeholder="you@example.com" value="${clientById.email}"></form:input>
                                <form:errors path="email"></form:errors>
                            </div>
                        </div>
                    </spring:bind>
                </div>

                <div class="mb-3">
                    <spring:bind path="lastName">
                        <label for="address">Address</label>
                        <div class="input-group">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="text" path="address" class="form-control" placeholder="address"
                                            autofocus="true" value="${clientById.address}"></form:input>
                                <form:errors path="address"></form:errors>
                            </div>
                        </div>
                    </spring:bind>
                </div>

                <div class="mb-3">
                    <spring:bind path="country">
                        <label for="country">Country</label>
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:select class="custom-select d-block w-100" path="country" name="country" id="country">
                                <option value="${clientById.country}">${clientById.country}!</option>
                            </form:select>
                            <form:errors path="country"></form:errors>
                        </div>
                    </spring:bind>
                </div>
                <hr class="mb-4">

                <button class="btn btn-primary btn-lg btn-block" type="submit">Add Client</button>
            </form:form>
        </div>
    </div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

