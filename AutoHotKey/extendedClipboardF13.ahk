songsURLs:=[]
songSelect=0
songsURLs[0]:="Y3yXAMiFgyI"
songsURLs[1]:="UwIQ3nBZ4Dw"

songsSize=0
for index, elemnt in songsURLs
{
	songsSize += 1
}

+F1::
	ExitApp
	Return

+F2::
	MsgBox, running
	Return

+F4::
	songSelect += 1
	if(songSelect=songsSize){
		songSelect=0
	}
	Return

^+F5::
	SEND ^C
	Sleep, 200
	Memory1:= clipboard
	Return
+F5::
	SEND, %Memory1%
	Return


^+F6::
	SEND ^C
	Sleep, 200
	Memory2:= clipboard
	Return
+F6::
	SEND, %Memory2%
	Return


^+F7::
	SEND ^C
	Sleep, 200
	Memory3:= clipboard
	Return
+F7::
	SEND, %Memory3%
	Return


^+F8::
	SEND ^C
	Sleep, 200
	Memory4:= clipboard
	Return
+F8::
	SEND, %Memory4%
	Return

+F9::
	run, notepad
	Return

+F10::
	SoundBeep, 440, 1000
	Return

+F11::
	SEND ^C
	memoryAppend:=clipboard
	FileAppend,%memoryAppend% `n, *C:\Users\dem98\Documents\FamiTracker\Demo songs\Inicio.txt
	Return

^+F11::
	run, C:\Users\dem98\Documents\FamiTracker\Demo songs\Inicio.txt
	Return

+F12::
	URL:="https://www.infinitelooper.com/?v=" . songsURLs[songSelect] . "&p=n"
	run %URL%

	Return