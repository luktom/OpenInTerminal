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

import javax.swing.*;

/**
 * @author Łukasz Tomczak <lksztmczk@gmail.com>
 */
public class OpenInTerminalSettingsForm {
    private JTextField terminalCommand;

    private JTextField terminalCommandOptions;

    private JPanel settingsPanel;

    private JCheckBox openInModule;

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    public OpenInTerminalSettingsState getSettingsState() {
        return new OpenInTerminalSettingsState(terminalCommand.getText(), terminalCommandOptions.getText(), openInModule.isSelected());
    }

    public void setSettingsState(OpenInTerminalSettingsState settingsState) {
        terminalCommand.setText(settingsState.getTerminalCommand());
        terminalCommandOptions.setText(settingsState.getTerminalCommandOptions());
        openInModule.setSelected(settingsState.isOpenInModule());
    }
}
