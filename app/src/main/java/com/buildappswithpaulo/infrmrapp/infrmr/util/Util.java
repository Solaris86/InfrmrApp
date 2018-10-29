package com.buildappswithpaulo.infrmrapp.infrmr.util;

import android.os.Build;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by paulodichone on 10/16/17.
 */

public class Util {

    public static String dateFormatted(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = format.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");

        return dateFormat.format(date);

    }
}
