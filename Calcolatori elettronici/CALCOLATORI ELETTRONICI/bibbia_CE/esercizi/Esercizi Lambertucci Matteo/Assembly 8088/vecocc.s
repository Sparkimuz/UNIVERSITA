!  conta le occorrenze di n nell'array.
_EXIT   = 1
_PRINTF = 127
.SECT    .TEXT
vecpstrt:
MOV      BP, SP
PUSH     vec
MOV      CX, n-vec
SHR      CX, 1
PUSH     CX
PUSH     (n)
CALL     vecconf
MOV      SP, BP
PUSH     DX
PUSH     format
PUSH     _PRINTF
SYS
MOV      SP, BP
PUSH     0
PUSH     _EXIT
SYS
vecconf:
PUSH     BP
MOV      BP, SP
MOV      AX, 4(BP) ! n
MOV      CX, 6(BP) ! lunghezza vec
MOV      BX, 8(BP) ! vec
MOV      SI, 0
MOV      DX, 0
1:       CMP AX, (BX)(SI)
JNE 2f
INC DX
2: ADD      SI, 2
LOOP     1b
MOV SP, BP
POP      BP
RET
.SECT    .DATA
vec:     .WORD         3, 4, 7, 11, 3
n:       .WORD         11
format:  .ASCIZ        "%d"
.SECT    .BSS