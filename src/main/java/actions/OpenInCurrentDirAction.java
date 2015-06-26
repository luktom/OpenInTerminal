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

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import settings.OpenInTerminalSettingsState;

/**
 * @author Łukasz Tomczak <lksztmczk@gmail.com>
 */
public class OpenInCurrentDirAction extends OpenInTerminalAction {

    @NotNull
    @Override
    protected String getPath(AnActionEvent e, VirtualFile file, OpenInTerminalSettingsState openInTerminalSettingsState) {
        return file.isDirectory() ? file.getPath() : file.getParent().getPath();
    }
}
