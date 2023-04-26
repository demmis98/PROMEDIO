print("X1 + Y1 = Z1")
X1=float(input("X1="))
Y1=float(input("Y1="))
Z1=float(input("Z1="))
X=0
print("X2 + Y2 = Z2")
X2=float(input("X2="))
Y2=float(input("Y2="))
Z2=float(input("Z2="))
Y=0

BACK00=Z1*Y2
BACK01=X1*Y2
BACK10=Z2*Y1
BACK11=X2*Y1

LEN=BACK00-BACK10
RIN=BACK11-BACK01
X=LEN/RIN
X*=-1
print("X=")
print(X)

BACK22=Z1*X2
BACK23=Y1*X2
BACK32=Z2*X1
BACK33=Y2*X1

EDDY=BACK22-BACK32
BRETT=BACK33-BACK23
Y=EDDY/BRETT
Y*=-1
print("Y=")
print(Y)
input()