<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reports</title>
    <link href="<c:url value="/resources/css/report.css"/>" type="text/css" rel="stylesheet">
    <script src="<c:url value="/resources/js/report.js"/>"></script>
</head>
<body>
<form method="post" action="/getReportList">
    <input type="hidden" id="hiddenPerformer" name="hiddenPerformer">
    <input type="hidden" id="hiddenStartDate" name="hiddenStartDate">
    <input type="hidden" id="hiddenEndDate" name="hiddenEndDate">

    <table>
        <tr>
            <td>Start date:</td>
            <td><input type="text" id="startDate" onchange="checkDate()"/></td>
        </tr>
        <tr>
            <td>End date:</td>
            <td><input type="text" id="endDate" onchange="checkDate()"/></td>
        </tr>
        <tr>
            <td>Performer:</td>
            <td>
                <c:if test="${not empty performers}">
                    <select id="performer" onchange="setPerformer()">
                        <option>All performers</option>
                        <c:forEach var="performer" items="#{performers}">
                            <option>${performer}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Time period:</td>
            <td>
                <select onchange="dateFormat()" id="timePeriod">
                    <option></option>
                    <option>Last Qtr</option>
                    <option>Last Month</option>
                    <option>Last Calendar Year</option>
                    <option>Current Year to Date</option>
                    <option>Current Qtr to Date</option>
                    <option>Current Month to Date</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input class="button" type="submit" value="Submit" onclick="setHiddenDate()"></td>
        </tr>
        <tr>
            <td colspan="2">
                <p id="message">${message}</p>
            </td>
        </tr>
    </table>
    <c:if test="${not empty resultReportsList}">
        <table>
            <tr>
                <td>Start date</td>
                <td>End date</td>
                <td>Performer</td>
                <td>Activity</td>
            </tr>
            <c:forEach var="report" items="#{resultReportsList}">
                <tr>
                    <td>
                            ${report.startDate}
                    </td>
                    <td>
                            ${report.endDate}
                    </td>
                    <td>
                            ${report.performer}
                    </td>
                    <td>
                            ${report.activity}
                    </td>
                </tr>
            </c:forEach>
        </table>

    </c:if>
</form>
</body>
</html>
