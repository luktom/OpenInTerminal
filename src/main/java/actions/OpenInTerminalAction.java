/**
 * Copyright (C) 2015 Łukasz Tomczak <lksztmczk@gmail.com>.
 *
 * This file is part of OpenInTerminal plugin.
 *
 * OpenInTerminal plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OpenInTerminal plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with OpenInTerminal plugin. If not, see <http://www.gnu.org/licenses/>.
 */
package actions;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import settings.OpenInTerminalSettings;
import settings.OpenInTerminalSettingsState;

/**
 * @author Łukasz Tomczak <lksztmczk@gmail.com>
 */
public abstract class OpenInTerminalAction extends AnAction {

    protected static final String ERROR_DURING_OPENING_TERMINAL_MESSAGE = "Error during opening terminal app. You current command for opening terminal is: %s %s. Check if it is correct.";

    protected static final String OPTIONS_NOT_PROVIDED_MESSAGE = "You do not provide needed settings for OpenInTerminal plugin. Please set them before usage.";

    protected static final String NOTIFICATION_DISPLAY_ID = "OpenInTerminal";

    protected static final String NOTIFICATION_TITLE = "OpenInTerminal plugin";

    public void actionPerformed(AnActionEvent e) {

        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);

        OpenInTerminalSettingsState openInTerminalSettingsState = OpenInTerminalSettings.getInstance().getState();

        if (openInTerminalSettingsState != null) {

            String directoryPath = getPath(e, file, openInTerminalSettingsState);

            try {
                GeneralCommandLine gcl = new GeneralCommandLine(openInTerminalSettingsState.getTerminalCommand(),
                        openInTerminalSettingsState.getTerminalCommandOptions(), directoryPath);
                gcl.createProcess();
            } catch (ExecutionException exception) {
                notifyAboutIncorrectOptions(openInTerminalSettingsState);
            }
        } else {
            notifyAboutUnsetOptions();
        }
    }

    @NotNull
    protected abstract String getPath(AnActionEvent e, VirtualFile file, OpenInTerminalSettingsState openInTerminalSettingsState);

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setVisible(e.getData(CommonDataKeys.VIRTUAL_FILE) != null);
    }

    protected void notifyAboutIncorrectOptions(OpenInTerminalSettingsState openInTerminalSettingsState) {
        Notifications.Bus.notify(new Notification(NOTIFICATION_DISPLAY_ID, NOTIFICATION_TITLE,
                String.format(ERROR_DURING_OPENING_TERMINAL_MESSAGE,
                        openInTerminalSettingsState.getTerminalCommand(),
                        openInTerminalSettingsState.getTerminalCommandOptions()),
                NotificationType.ERROR));
    }

    protected void notifyAboutUnsetOptions() {
        Notifications.Bus.notify(new Notification(NOTIFICATION_DISPLAY_ID, NOTIFICATION_TITLE,
                OPTIONS_NOT_PROVIDED_MESSAGE,
                NotificationType.WARNING));
    }
}
