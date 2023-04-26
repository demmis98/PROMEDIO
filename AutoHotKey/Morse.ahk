#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

.::
 SEND, lol
 SetTimer,, 50000
 SEND,  y
 SetTimer,, Off
Return
+::
 ExitApp
Return