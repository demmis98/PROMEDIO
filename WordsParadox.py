import random

testsNumber=100
FirstLetter=1
Words=[testsNumber]
ActualWord=-1
ActualLetter="a"
for i in range(testsNumber):
	LetterToAdd=random.randint(1, 27)
	
	if LetterToAdd==1:
		ActualLetter="a"
	if LetterToAdd==2:
		ActualLetter="b"
	if LetterToAdd==3:
		ActualLetter="c"
	if LetterToAdd==4:
		ActualLetter="d"
	if LetterToAdd==5:
		ActualLetter="e"
	if LetterToAdd==6:
		ActualLetter="f"
	if LetterToAdd==7:
		ActualLetter="g"
	if LetterToAdd==8:
		ActualLetter="h"
	if LetterToAdd==9:
		ActualLetter="i"
	if LetterToAdd==10:
		ActualLetter="j"
	if LetterToAdd==11:
		ActualLetter="k"
	if LetterToAdd==12:
		ActualLetter="l"
	if LetterToAdd==13:
		ActualLetter="m"
	if LetterToAdd==14:
		ActualLetter="n"
	if LetterToAdd==15:
		ActualLetter="o"
	if LetterToAdd==16:
		ActualLetter="p"
	if LetterToAdd==17:
		ActualLetter="q"
	if LetterToAdd==18:
		ActualLetter="r"
	if LetterToAdd==19:
		ActualLetter="s"
	if LetterToAdd==20:
		ActualLetter="t"
	if LetterToAdd==21:
		ActualLetter="u"
	if LetterToAdd==22:
		ActualLetter="v"
	if LetterToAdd==23:
		ActualLetter="w"
	if LetterToAdd==24:
		ActualLetter="x"
	if LetterToAdd==25:
		ActualLetter="y"
	if LetterToAdd==26:
		ActualLetter="z"
	if LetterToAdd==27:
		ActualWord+=1
	
	print(ActualWord)
	Words[ActualWord]=LetterToAdd
	print(LetterToAdd)
input()