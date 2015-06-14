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
package settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Łukasz Tomczak <lksztmczk@gmail.com>
 */
public class OpenInTerminalSettingsConfigurable implements Configurable {

    private OpenInTerminalSettingsForm openInTerminalSettingsForm;

    private OpenInTerminalSettings openInTerminalSettings;

    public OpenInTerminalSettingsConfigurable() {
        this.openInTerminalSettingsForm = new OpenInTerminalSettingsForm();
        this.openInTerminalSettings = OpenInTerminalSettings.getInstance();
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "OpenInTerminal";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return openInTerminalSettingsForm.getSettingsPanel();
    }

    @Override
    public boolean isModified() {
        return !openInTerminalSettingsForm.getSettingsState().equals(openInTerminalSettings.getState());
    }

    @Override
    public void apply() throws ConfigurationException {
        openInTerminalSettings.loadState(openInTerminalSettingsForm.getSettingsState());
    }

    @Override
    public void reset() {
        if(openInTerminalSettings.getState() != null) {
            openInTerminalSettingsForm.setSettingsState(openInTerminalSettings.getState());
        }
    }

    @Override
    public void disposeUIResources() {

    }
}
