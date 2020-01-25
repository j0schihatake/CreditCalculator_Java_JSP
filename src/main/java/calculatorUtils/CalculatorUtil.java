package calculatorUtils;

public class CalculatorUtil {

    /*

    public int allPaymentCount = x;

    // Номер платежа
    public int currentCount = 0;

    // Месяц год:
    public int mounthYear;

    // Платеж по основному долгу:
    public float dolg;

    // Платеж по процентам:
    public float procent;

    // Остаток основного долга:
    public float ostatokOsnDolga;

    // Общая сумма платежа:
    public float summ;

    Идея какая: каждый новый месяц мы имеем новый набор входных данных,
    а потому и заново рассчитываем все показатели.

    */

    // Получаем сколько всего платежей на таких условиях(для отрисовки таблицы - строчки):
    public static int getAllPaymentCount(int summCredit, int monthCount){
        // Тут считаем сколько высего месячных выплат:
        return 1;
    }

    // Рассчитываем новое значение Месяц/год:
    public static int getNextMonthYear(int currentMonthCount,
                                       int MonthYear,
                                       float Dolg,
                                       float procent,
                                       float ostatokOsnownogoDolga,
                                       float summ){
        // Тут рассчитываем новое значение этой переменной(не вникал особо):
        return MonthYear - currentMonthCount - 1;
    }

    // Рассчитываем новую сумму долга:
    public static int getNextDolg(int currentMonthCount,
                                       int currentMonthYear,
                                       float currentDolg,
                                       float procent,
                                       float ostatokOsnownogoDolga,
                                       float summ){
        // Тут рассчитываем новое значение этой переменной:
        return 0;
    }

    // Рассчитываем новые проценты:
    public static int getNextProcent(int currentMonthCount,
                                  int currentMonthYear,
                                  float currentDolg,
                                  float procent,
                                  float ostatokOsnownogoDolga,
                                  float summ){
        // Тут рассчитываем новое значение этой переменной:
        return 0;
    }

    // Рассчитываем новый остаток основного долга:
    public static float getNextOstatokOsnownogoDolga(int currentMonthCount,
                                     int currentMonthYear,
                                     float currentDolg,
                                     float procent,
                                     float ostatokOsnownogoDolga,
                                     float summ){
        // Тут рассчитываем новое значение этой переменной:
        return 0.0f;
    }

    // Рассчитываем новую общую сумму платежа:
    public static float getNextSumm(int currentMonthCount,
                                    int currentMonthYear,
                                    float currentDolg,
                                    float procent,
                                    float ostatokOsnownogoDolga,
                                    float summ){
        // Тут рассчитываем новое значение этой переменной:
        return 0.0f;
    }


    // Выполняем валидацию по диапазону:
    public static boolean isValid(int value, int min, int max){
        if(value < min && value < max)
            return true;

        return false;
    }

}
