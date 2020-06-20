package ir.maziardev.simkhan;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Base extends Application {
    public static String SAVE_SIMCARD_PAGE = "1";

    public static final String BASE_SIMCARD_LIMIT = "12";
    public static final String BASE_SIMCARD_USERNAME = "09122323135";
    public static final String BASE_SIMCARD_PASSWORD = "503426";

    public static final String BASE_SAVE_LOGIN = "BASE_SAVE_LOGIN";
    public static final String BASE_SAVE_TOKEN = "BASE_SAVE_TOKEN";
    public static final String BASE_SAVE_EXPIRES = "BASE_SAVE_EXPIRES";


    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iransans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
