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

/**
 * @author Łukasz Tomczak <lksztmczk@gmail.com>
 */
public class OpenInTerminalSettingsState {
    private String terminalCommand;

    private String terminalCommandOptions;

    public OpenInTerminalSettingsState() {
    }

    public OpenInTerminalSettingsState(String terminalCommand, String terminalCommandOptions) {
        this.terminalCommand = terminalCommand;
        this.terminalCommandOptions = terminalCommandOptions;
    }

    public String getTerminalCommand() {
        return terminalCommand;
    }

    public void setTerminalCommand(String terminalCommand) {
        this.terminalCommand = terminalCommand;
    }

    public String getTerminalCommandOptions() {
        return terminalCommandOptions;
    }

    public void setTerminalCommandOptions(String terminalCommandOptions) {
        this.terminalCommandOptions = terminalCommandOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenInTerminalSettingsState that = (OpenInTerminalSettingsState) o;

        if (!terminalCommand.equals(that.terminalCommand)) return false;
        return terminalCommandOptions.equals(that.terminalCommandOptions);

    }

    @Override
    public int hashCode() {
        int result = terminalCommand.hashCode();
        result = 31 * result + terminalCommandOptions.hashCode();
        return result;
    }
}
