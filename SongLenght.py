import winsound
TUNNING=440
NOTE=input()
OCTAVE=input()
ACCIDENTALS=0
NEGATIVE=0
if NOTE[0]=="C" or NOTE[0]=="c":
	LETTER=0
if NOTE[0]=="D" or NOTE[0]=="d":
	LETTER=2
if NOTE[0]=="E" or NOTE[0]=="e":
	LETTER=4
if NOTE[0]=="F" or NOTE[0]=="f":
	LETTER=5
if NOTE[0]=="G" or NOTE[0]=="g":
	LETTER=7
if NOTE[0]=="A" or NOTE[0]=="a":
	LETTER=9
if NOTE[0]=="B" or NOTE[0]=="b":
	LETTER=11
NOTELETTER=NOTE[0]
if len(NOTE)==2:
	if NOTE[1]=="#":
		LETTER+=1
		ACCIDENTALS=1
		ACCIDENTAL="#"
	if NOTE[1]=="b":
		LETTER-=1
		ACCIDENTALS=1
		ACCIDENTAL="b"
N=12*int(OCTAVE)
N+=int(LETTER)
N-=57
FREQUENCY=TUNNING*(2**(N/12))
print(FREQUENCY)

SECONDS=1/FREQUENCY
print(SECONDS)

TEMPO=FREQUENCY*60
print(TEMPO)
input()