_EXIT = 1
_PRINTF = 127

.SECT .TEXT
MOV SP, BP
MOV CX, end - str
MOV DI, str
MOVB AL, (x)
MOV DX, 0
1: SCASB
JNE 2f
PUSH DX
2: INC DX
CMP DX, 0
JNE 3f
PUSH format2
3: PUSH           format1
PUSH           _PRINTF
SYS
MOV            SP, BP
PUSH 0
PUSH _EXIT
SYS

.SECT .DATA
str: .ASCII "**a*"  
end:  .SPACE 1
x  : .ASCII "*"
format1: .ASCII "%d %d %d"
format2: .ASCII "0"
.SECT .BSS
