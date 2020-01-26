package calculatorUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalculatorUtil {

    // Выполняем валидацию по диапазону:
    public static boolean isValid(int value, int min, int max){
        if(value < min && value < max)
            return true;

        return false;
    }

    public static float stringToFloat(String value){
        Float f2 = 0f;
        try {
            f2 = Float.valueOf(value);
            System.out.println(f2);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        return f2;
    }

    public static int stringToInt(String value){
        int f2 = 0;
        try {
            f2 = Integer.valueOf(value);
            System.out.println(f2);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        return f2;
    }

    //-----------------------------Рассчеты переменных:

    // Рассчитываем ежемесячную процентную ставку:
    public static float getEveryMonthProcents(float yearProcents){
        return yearProcents/100f/12;
    }

    // Рассчитываем стартовую дату:
    public static Date getStartDate(){
        return new Date();
    }

    // Рассчитываем новую дату:
    public static Date getNextDate(Date startDate, int nextCount){
        Calendar calendar = new GregorianCalendar(startDate.getYear(), startDate.getMonth(), startDate.getDay());
        if(nextCount > 0) {
            calendar.add(Calendar.MONTH, nextCount);
        }
        return calendar.getTime();
    }

    // Рассчет аннуитетнного платежа(Общая сумма платежа):
    public static float getAnnuitetPaymentSumm(float summ, float yearProcent){
        float result = 0f;
        float everyMonthProcent = getEveryMonthProcents(yearProcent);
        result = (float) (summ * (everyMonthProcent +
                (everyMonthProcent/(Math.pow((1 + everyMonthProcent), 12))-1)));
        return result;
    }

    // Рассчет платежа по процентам:
    public static float getProcentPeyments(float summ, float yearProcent){
        return summ * getEveryMonthProcents(yearProcent);
    }

    // Рассчет части платежа по основному долгу:
    public static float getBodyPeyments(float summ, float yearProcent){
        return getAnnuitetPaymentSumm(summ, yearProcent)
                - getProcentPeyments(summ, yearProcent);
    }

    // Рассчитать остаток основного долга:
    public static float getDolg(float summ, float yearProcent){
        return summ - getBodyPeyments(summ, yearProcent);
    }
}
