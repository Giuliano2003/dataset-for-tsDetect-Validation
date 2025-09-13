package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.time.DayOfWeek;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


import org.junit.Before;
import org.junit.Test;

import controller.ICommandExecutor;
import view.IView;

/**
 * Test suite for the {@link CalendarModel} class.
 * Verifies functionality such as calendar creation, event manipulation,
 * timezone adjustments, recurrence handling, and conflict detection.
 */

public class CalendarModelTest {

  private CalendarModel model;

  @Before
  public void setUp() {
    model = new CalendarModel();
  }

  @Test
  public void createInstance_withValidType_returnsModel() {
    ICalendarModel model = ICalendarModel.createInstance("listBased");
    assertNotNull(model);
  }


  @Test
  public void testAddNonRecurringEvent() {
    model.createCalendar("Work", "America/New_York");
    LocalDateTime start = LocalDateTime.of(2025, 3, 18, 10, 0);
    LocalDateTime end = LocalDateTime.of(2025, 3, 18, 11, 0);

    ICalendarEventDTO eventDTO = CalendarEventDTO.builder();

    assertTrue(model.addEvent("Work", eventDTO));

    List<ICalendarEventDTO> events = model.getEventsInRange("Work", start.minusMinutes(1),
        end.plusMinutes(1));
    assertEquals(1, events.size());
    assertEquals("Meeting", events.get(0).getEventName());
  }


}