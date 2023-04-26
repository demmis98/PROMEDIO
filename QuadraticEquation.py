import math
print("aX^2+bX+c=0")
NumberA=float(input("a="))
NumberB=float(input("b="))
NumberC=float(input("c="))
# -b
Process1=NumberB*-1
# b^2-4ac
Process2=NumberB*NumberB
Process21=NumberA*4
Process21*=NumberC
Process2-=Process21
# 2a
Process3=NumberA*2

# /b^2-4ac regulator to positive
if Process2<0:
	Process2*=-1

# Result 1
Result1=Process1
# -b+/b^2-4ac
Result1+=math.sqrt(Process2)
# (-b+/b^2-4ac)/2a
Result1/=Process3
# Result 2
Result2=Process1
# -b-/b^2-4ac
Result2-=math.sqrt(Process2)
# (-b-/b^2-4ac)/2a
Result2/=Process3

# print results
print("X1="+str(Result1))
print("X2="+str(Result2))
input()