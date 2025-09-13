package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Implementazione semplificata della classe CalendarModel.
 */
public class CalendarModel implements ICalendarModel {

    private final Map<String, List<ICalendarEventDTO>> calendars = new HashMap<>();
    private final Map<String, ZoneId> calendarZones = new HashMap<>();

    @Override
    public void createCalendar(String name, String timeZone) {
        calendars.putIfAbsent(name, new ArrayList<>());
        calendarZones.put(name, ZoneId.of(timeZone));
    }

    @Override
    public boolean addEvent(String calendarName, ICalendarEventDTO event) {
        List<ICalendarEventDTO> events = calendars.get(calendarName);
        if (events == null) {
            return false;
        }
        events.add(event);
        return true;
    }

    @Override
    public List<ICalendarEventDTO> getEventsInRange(String calendarName,
                                                    LocalDateTime start,
                                                    LocalDateTime end) {
        List<ICalendarEventDTO> events = calendars.get(calendarName);
        if (events == null) {
            return Collections.emptyList();
        }
        List<ICalendarEventDTO> results = new ArrayList<>();
        for (ICalendarEventDTO e : events) {
            if (!(e.getEnd().isBefore(start) || e.getStart().isAfter(end))) {
                results.add(e);
            }
        }
        return results;
    }

    // Factory method richiesto dal test
    public static ICalendarModel createInstance(String type) {
        if ("listBased".equalsIgnoreCase(type)) {
            return new CalendarModel();
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }
}
