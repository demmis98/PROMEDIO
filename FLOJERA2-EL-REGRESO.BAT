@ECHO OFF
SETLOCAL EnableDelayedExpansion
SET/A PRES=100
:INCEPTION
ECHO �ESCRIBE LOS VALORES DE LA PRIMER ECUACION
SET/P L1=�CUANTAS X?
IF %L1%==DEBUG GOTO DEBUG
SET/P N1=�CUANTAS Y?
SET/P R1=�RESULTADO?
SET/A X=0
ECHO �ESCRIBE LOS VALORES DE LA SEGUNDA ECUACION
SET/P L2=�CUANTAS X?
SET/P N2=�CUANTAS Y?
SET/P R2=�RESULTADO?
SET/A Y=0
:IGUALARX
SET/A BACK00=%R1%*%N2%
SET/A BACK01=%L1%*%N2%
SET/A BACK10=%R2%*%N1%
SET/A BACK11=%L2%*%N1%
:OPERACIONESX
SET/A LEN=%BACK00%-%BACK10%
SET/A RIN=%BACK11%-%BACK01%
SET/A LENIN=%LEN%*%PRES%
SET/A RININ=%RIN%
SET/A X=%LEN%/%RIN%
SET/A XDEC1=%LENIN%/%RININ%
SET/A X=%X%*-1
SET/A XDEC1=%XDEC1%*-1
SET/A XDEC2=%X%*%PRES%
SET/A XMIN=%XDEC1%-%XDEC2%
IF %XMIN% LSS 0 SET/A XMIN=%XMIN%*-1
ECHO �X=%X%.%XMIN%
:IGUALARY
SET/A BACK22=%R1%*%L2%
SET/A BACK23=%N1%*%L2%
SET/A BACK32=%R2%*%L1%
SET/A BACK33=%N2%*%L1%
:OPERACIONESY
SET/A EDDY=%BACK22%-%BACK32%
SET/A BRETT=%BACK33%-%BACK23%
SET/A PITCH=%EDDY%*%PRES%
SET/A PIZZ=%BRETT%
SET/A Y=%EDDY%/%BRETT%
SET/A YDEC1=%PITCH%/%PIZZ%
SET/A Y=%Y%*-1
SET/A YDEC1=%YDEC1%*-1
SET/A YDEC2=%Y%*%PRES%
SET/A YMIN=%YDEC1%-%YDEC2%
IF %YMIN% LSS 0 SET/A YMIN=%YMIN%*-1
ECHO �Y=%Y%.%YMIN%
SET/P REPETIR=�DESEA REPETIR EL CODIGO?Y/N
IF %REPETIR%==Y GOTO INCEPTION
IF %REPETIR%==y GOTO INCEPTION
GOTO ENDING
:DEBUG
COLOR 0A
:DEBUGIN
ECHO �BIENVENIDO AL MODO DEBUG
SET/A COMMAND=
IF %COMMAND%==COLOR GOTO RESET
%COMMAND%
GOTO DEBUGIN
:COLOR
ECHO �QUE COLOR?
SET/P COLOR=
COLOR %COLOR%
GOTO DEBUGIN
:RESET
COLOR 0F
CLS
GOTO INCEPTION
:ENDING