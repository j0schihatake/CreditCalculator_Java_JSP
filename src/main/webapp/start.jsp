<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="calculatorUtils" %>

<c:set var="summ" value='${paramValues.containsKey(summ) ? summ : 0}'/>

<c:set var="month" value='${paramValues.containsKey(month) ? month : 0}'/>

<c:set var="error" value='${paramValues.containsKey(error) ? paramValues[error] : ""}'/>

<div>
    <table class="table"  border="1" width="100%" cellpadding="5">
        <tr>
            <td>
                <c:out value="Сумма кредита"/>
                <input type="text" id="summ" name="Сумма кредита" required
                       minlength="6" maxlength="6" size="6" required pattern="[0-9]">
            </td>

            <td>
                <c:out value="Число месяцев"/>
                <input type="text" id="monthCount" name="Число месяцев" required
                       minlength="2" maxlength="2" size="10" required pattern="[0-9]">
            </td>
            <>
                <input type="button" name="calculate" value="Рассчитать" onClick=/>
            </td>
        </tr>
    </table>
</div>
<div>
    <table class="table"  border="1" width="100%" cellpadding="5">
            <tr>
                <td><c:out value="Номер платежа"/></td>
                <td><c:out value="Месяц/год"/></td>
                <td><c:out value="Платеж по основному долгу"/></td>
                <td><c:out value="Платеж по процентам"/></td>
                <td><c:out value="Остаток основного долга"/></td>
                <td><c:out value="Общая сумма платежа"/></td>
            </tr>

            <c:set var="allMonthCount" value="${u:getAllPaymentCount(summ, month)}"/>

            <c:if test="${summ > 0 && month > 0}">

                <c:forEach var = "i" begin = "1" end = "${allMonthCount}">

                    <c:set var="monthYear" value='{u:getNextMonthYear(, , , , , )}'/>
                    <c:set var="dolg" value="{u:getNextDolg(, , , , , )}"/>
                    <c:set var="procent" value="{u:getNextProcent(, , , , , )}"/>
                    <c:set var="summ" value="{u:getNextSumm(, , , , , )}"/>

                    <tr>
                        <td>
                            ${i}
                        </td>
                        <td>
                            ${monthYear}
                        </td>
                        <td>
                            ${dolg}
                        </td>
                        <td>
                            ${procent}
                        </td>
                        <td>
                            ${dolg}
                        </td>
                        <td>
                            ${summ}
                        </td>
                    </tr>
                </c:forEach>
            </c:if>>

    </table>
</div>

<script type="text/javascript">

    function fwdToUpdatePage(){
        document.location.href(start.jsp);
    }

</script>
