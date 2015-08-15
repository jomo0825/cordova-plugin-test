package com.memoryabc.plugin.calendar;

import android.content.Intent;

//not org.apache.cordova.api.CallbackContext;
//not org.apache.cordova.api.CordovaPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by USER on 2015/8/15.
 */
public class CalendarPlugin extends CordovaPlugin {
    public static final String ACTION_ADD_CALENDAR_ENTRY = "addCalendarEntry";

    @Override
	// add 2 final
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException{
        try {
            if (ACTION_ADD_CALENDAR_ENTRY.equals(action)) {
                JSONObject arg_object = args.getJSONObject(0);
                Intent calIntent = new Intent(Intent.ACTION_EDIT)
                        .setType("vnd.android.cursor.item/event")
                        .putExtra("beginTime", arg_object.getLong("startTimeMills"))
                        .putExtra("endTime", arg_object.getLong("endTimeMills"))
                        .putExtra("title", arg_object.getString("title"))
                        .putExtra("description", arg_object.getString("description"))
                        .putExtra("eventLocation", arg_object.getString("eventLocation"));

                this.cordova.getActivity().startActivity(calIntent);
                callbackContext.success();
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}
