package ru.nikituz.axiomatictesttask.utils.validation;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationMessageUtil {
    public static final String FIO_REGEXP = "^([А-ЯЁ][а-яё]+[\\-\\s]?){2,}$";
    public static final String FIO_ERROR_MESSAGE = "Необходимо указать полные Фамилию, Имя и Отчество(если есть)";

    public static final String PASSPORT_REGEXP = "^\\d{4}\\s\\d{6}$";
    public static final String PASSPORT_ERROR_MESSAGE = "Необходимо указать серию и номер в виде: XXXX XXXXXX";

    public static final String ADDRESS_ERROR_MESSAGE = "Необходимо указать адрес прописки";

    public static final String PHONE_REGEXP = "^\\d{10}$";
    public static final String PHONE_ERROR_MESSAGE = "Номер телефона необходимо указать в виде последовательности из 10 цифр, идущих после +7";

    public static final String EMPLOYMENT_ORGANIZATION_ERROR_MESSAGE = "Необходимо указать организацию";
    public static final String EMPLOYMENT_POSITION_ERROR_MESSAGE = "Необходимо указать занимаемую должность";
    public static final String EMPLOYMENT_PERIOD_NOT_NULL_ERROR_MESSAGE = "Необходимо указать период работы";
    public static final String EMPLOYMENT_PERIOD_MIN_ERROR_MESSAGE = "Период работы не может быть меньше 0 месяцев";
    public static final String EMPLOYMENT_PERIOD_MAX_ERROR_MESSAGE = "Период работы не может быть больше 100 месяцев";

    public static final String CREDIT_AMOUNT_NOT_NULL_ERROR_MESSAGE = "Необходимо указать желаемую сумму кредита";
    public static final String CREDIT_AMOUNT_MIN_VALUE = "5000.00";
    public static final String CREDIT_AMOUNT_MIN_VALUE_ERROR_MESSAGE = "Минимальная сумма кредита - 5000.00 ₽";
    public static final String CREDIT_AMOUNT_RANGE_ERROR_MESSAGE = "Число вне допустимого диапазона возможной суммы кредита";

}
