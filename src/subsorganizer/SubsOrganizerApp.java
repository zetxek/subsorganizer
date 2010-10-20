/*
 * SubsOrganizerApp.java
 */

package subsorganizer;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class SubsOrganizerApp extends SingleFrameApplication {

    @Override protected void startup() {
        show(new SubsOrganizerMain());
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SubsOrganizerApp
     */
    public static SubsOrganizerApp getApplication() {
        return Application.getInstance(SubsOrganizerApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(SubsOrganizerApp.class, args);
    }
}
