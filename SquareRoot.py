Number=(input())
Characters=[]
Root=[]
Rest=0
Odd=-1
for i in Number:
	Odd*=-1
if Odd==-1:
	for i in range(1, len(Number), 2):
		if i == 0:
			Characters.append(Number[i])
		else:
			Characters.append(Number[i-1]+Number[i])
if Odd==1:
	for i in range(0, len(Number), 2):
		if i == 0:
			Characters.append(Number[i])
		else:
			Characters.append(Number[i-1]+Number[i])
print(Odd)
print(Characters)
for c in range(0, len(Characters), 1):
	Root.append(0)
for s in range(0, 10, 1):
	Digit=int(Characters[0])
	if Digit >= s*s:
		Root[0]=s
for c in range(1, len(Characters), 1 ):
	for i in range(0, c, 1):
		Ten=Root[i]
		for m in range(0, len(Characters)-i, 1):
			Ten*=100
		print(Ten)
		print("1")
		Rest+=Ten
		Rooter=Rest*Rest
		print(Rest)
		print("Lol")
	for s in range(0, 10, 1):
		Digit=int(Characters[c])
		if Digit >= Rooter:
			Root[c]=s
print(Root)
input()