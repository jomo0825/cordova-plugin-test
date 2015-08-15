var calendarPlugin = {
  createEvent: function(title, location, notes, startDate, endDate, successCallback, errorCallback) {
    cordova.exec(
      successCallback,
      errorCallback,
      'CalendarPlugin',
      'addCalendarEntry',
      [{
        "title": title;
        "description": notes,
        "eventLocation": location,
        "startTimeMills": startDate.getTime(),
        "endTimeMills": endDate.getTime()
      }]
    );
  }
}
module.exports = calendarPlugin;
