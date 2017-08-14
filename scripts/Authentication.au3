$title="Authentication Required"
WinWaitActive($title)
Send("username")
Send("{TAB}")
Send("password")
Send("{ENTER}")