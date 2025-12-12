!      Calcola     il quadrato di un numero con la subroutine "square"
_EXIT   = 1
_PRINTF = 127
.SECT  .TEXT
start:
PUSH   (a)
CALL   square
ADD    SP,2
PUSH   AX
PUSH   (a)
PUSH   pfmt
PUSH   _PRINTF
SYS
MOV    SP,BP
PUSH   0
PUSH   _EXIT
SYS
square:
PUSH   BP
MOV    BP,SP
MOV    AX,4(BP)
MUL    AX
POP    BP
RET
.SECT  .DATA
pfmt:  .ASCIZ      "\n %d^2 = %d !\n"
a:     .WORD       3
.SECT  .BSS