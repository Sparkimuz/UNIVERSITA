!        Stampa        la somma di un array di interi mediante una subroutine "vecsum"
_EXIT   = 1
_PRINTF = 127
.SECT    .TEXT
vecpstrt:
PUSH     vec
MOV      CX,end-vec
SHR      CX,1
PUSH     CX
CALL     vecsum
MOV      SP,BP
PUSH     AX
PUSH     format
PUSH     _PRINTF
SYS
MOV      SP,BP
PUSH     0
PUSH     _EXIT
SYS
vecsum:
PUSH     BP
MOV      BP,SP
MOV      CX,4(BP)
MOV      BX,6(BP)
MOV      SI,0
MOV      AX,0
1:       ADD           AX,(BX)(SI)
ADD      SI,2
LOOP     1b
MOV      SP,BP
POP      BP
RET
.SECT    .DATA
vec:     .WORD         3,4,7,11,3
end:     .SPACE        1
format:  .ASCII        "La somma della stringa e' %d"
.SECT    .BSS