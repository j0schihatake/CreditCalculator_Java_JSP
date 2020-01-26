<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="calculatorUtils" %>

<c:set var="url">
    <c:url value="${pageContext.request.contextPath}"></c:url>
</c:set>

<c:set var="summ" value='${param["summText"]}'/>

<c:set var="month" value='${param["monthText"]}'/>

<div>
    <table class="table"  border="1" width="100%" cellpadding="5">
        <td>
            <c:out value="Сумма кредита"/>
            <input type="text" id="summText" name="Сумма кредита" required
                   minlength="6" maxlength="6" size="6" required pattern="[0-9]">
        </td>
        <td>
            <c:out value="Число месяцев"/>
            <input type="text" id="monthText" name="Число месяцев" required
                   minlength="2" maxlength="2" size="10" required pattern="[0-9]">
        </td>
        <td>
            <input type="button" name="calculate" value="Рассчитать" onclick="redirect()"/>
        </td>
        </tr>
    </table>
</div>
<div>
    <c:if test="${not empty summ && not empty month}">
        <table class="table"  border="1" width="100%" cellpadding="5">
            <tr>
                <td><c:out value="Номер платежа"/></td>
                <td><c:out value="Месяц/год"/></td>
                <td><c:out value="Платеж по основному долгу"/></td>
                <td><c:out value="Платеж по процентам"/></td>
                <td><c:out value="Остаток основного долга"/></td>
                <td><c:out value="Общая сумма платежа"/></td>
            </tr>

            <c:set var="summ" value='${u:stringToFloat(summ)}'/>

            <c:set var="month" value='${u:stringToInt(month)}'/>

            <c:set var="startDate" value='${u:getStartDate()}'/>

            <c:set var="yearProcents" value='${12.9}'/>

            <c:forEach var = "i" begin = "0" end = "${month}">

                    <c:set var="payment" value='${u:getAnnuitetPaymentSumm(summ, yearProcents)}'/>

                    <tr>
                        <td>
                                ${i}
                        </td>
                        <td>
                                ${u:getNextDate(startDate, i)}'
                        </td>
                        <td>
                                ${u:getBodyPeyments(summ, yearProcents)}
                        </td>
                        <td>
                                ${u:getProcentPeyments(summ, yearProcents)}
                        </td>
                        <td>
                                ${u:getDolg(summ, yearProcents)}
                        </td>
                        <td>
                                ${payment}
                        </td>
                    </tr>

                    <c:if test='${i > 0}'>
                        <c:set var="summ" value="${summ - payment}"/>
                    </c:if>
                </c:forEach>
        </table>
    </c:if>>
</div>

<script language="JavaScript">
    function redirect() {
        var summText = document.getElementById('summText').value;
        var monthText = document.getElementById('monthText').value;

        window.location.replace("?summText=" + summText + "&monthText=" + monthText);
    }
</script>

