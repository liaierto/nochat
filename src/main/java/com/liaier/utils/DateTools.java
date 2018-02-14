package com.liaier.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

    public static String getCurrentTime(String pDateFormat) throws Exception {

        SimpleDateFormat pSMDate = new SimpleDateFormat(pDateFormat);
        Date pDate = new Date();
        String pNowDate = pSMDate.format(pDate);
        return pNowDate;

    }

    public static String getFormatDate(String pDate, String pOldFormat, String pNewFormat) throws Exception {

        SimpleDateFormat pSMDate = new SimpleDateFormat(pOldFormat);
        Date pdate = pSMDate.parse(pDate);
        SimpleDateFormat pSDF = new SimpleDateFormat(pNewFormat);
        String pFDate = pSDF.format(pdate);
        return pFDate;
    }

    public static String dateSubtract(String pDate1, String pDate2, String pDateFormat, long pSubModel) throws Exception {

        if (pDate1.length() < pDate2.length()) {
            String pTemp = pDate1;
            pDate1 = pDate2;
            pDate2 = pTemp;
        }
        SimpleDateFormat pSMDate = new SimpleDateFormat(pDateFormat);
        Date pdate1 = pSMDate.parse(pDate1);
        Date pdate2 = pSMDate.parse(pDate2);
        long pSub = (pdate1.getTime() - pdate2.getTime()) / (pSubModel * 1000);
        System.out.println(pSub);
        return String.valueOf(pSub);

    }
}