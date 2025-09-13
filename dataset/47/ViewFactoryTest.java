
package view;

import model.IReadOnlyCalendarModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ViewFactoryTest {

  private IReadOnlyCalendarModel mockModel;
  private String[] validHeadlessArgs;
  private String[] insufficientHeadlessArgs;

  @Before
  public void setUp() throws IOException {
    // Create a simple manual mock of IReadOnlyCalendarModel
    mockModel = new TestReadOnlyCalendarModel();

    // Create commands.txt file in the current directory
    File commandsFile = new File("commands2.txt");
    try (FileWriter writer = new FileWriter(commandsFile)) {
      // Add any test commands you want to execute
      writer.write("show status on 2023-01-01T10:00\n");
      writer.write("print events on 2023-01-01\n");
      // Make sure to end with exit command
      writer.write("exit");
    }

    // Make sure the file is deleted when the JVM exits
    commandsFile.deleteOnExit();

    validHeadlessArgs = new String[]{"--mode", "headless", "commands2.txt"};
    insufficientHeadlessArgs = new String[]{"--mode", "headless"};
  }


  @Test
  public void testCreateInteractiveView() throws FileNotFoundException {
    IView view = ViewFactory.createView("interactive", new String[]{}, mockModel);
    assertNotNull("Interactive view should not be null", view);
    assertTrue("Should return InteractiveConsoleView", view instanceof InteractiveConsoleView);
  }

  @Test
  public void testCreateHeadlessView() throws FileNotFoundException {
    IView view = ViewFactory.createView("headless", validHeadlessArgs, mockModel);
    assertNotNull("Headless view should not be null", view);
    assertTrue("Should return HeadlessConsoleView", view instanceof HeadlessConsoleView);
  }


  @Test
  public void testCreateViewWithMixedCaseType() throws FileNotFoundException {
    // Additional case-insensitivity test
    IView view = ViewFactory.createView("InTeRaCtIvE", new String[]{}, mockModel);
    assertNotNull("Interactive view should not be null with mixed case type", view);
    assertTrue("Should return InteractiveConsoleView with mixed case type", view instanceof InteractiveConsoleView);
  }

}
