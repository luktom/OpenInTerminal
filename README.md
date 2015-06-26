## OpenInTerminal plugin
This is plugin for Intellij IDEA IDE. It's provide ability to open terminal with current file location by corresponding action in context menu (in editor and project view). 
You can also choose to open terminal in module directory instead of just parent directory of file. 

## Configuration
Before usage please set command and options for terminal app in settings. 

Example configuration:

* Terminal command: _gnome-terminal_
* Options: _--working-directory_

Above configuration will execute following command: _gnome-terminal_ _--working-directory_ _"path_to_file_or_directory"_. 