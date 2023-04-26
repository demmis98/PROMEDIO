print("Advertencia:")
cant=int(input("Cuantos numeros son?\n"))
res = 0
num = []
for i in range(cant):
	f = i + 1
	tnac = str(f)
	message = "Cual es el numero " + tnac + "?"
	print(message)
	num.append(float(input()))
	res += num[i]

prom = res/cant
print("La suma total es:")
print(res)
print("El promedio es:")
print(prom)
der = []
derprom = 0
for i in range(cant):
	deriv = num[i] - prom
	if deriv < 0:
		deriv *= -1
	der.append(deriv)
	f = i + 1
	tnac = str(f)
	message = "La derivacion del numero " + tnac + " es:"
	print(message)
	print(der[i])
	derprom += der[i]

derprom /= cant
print("Derivacion promedio es:")
print(derprom)
input()
