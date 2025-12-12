! vecsum(n, vev) con subroutine.

_EXIT = 1
_PRINTF = 127

.SECT .TEXT

MAIN:
	PUSH vec
	PUSH (n)
	CALL VECSUM
	MOV BP, SP
	PUSH AX
	PUSH DX
	PUSH format
	PUSH _PRINTF
	SYS
	MOV SP, BP
	PUSH 0
	PUSH _EXIT
	SYS
	MOV SP, BP
VECSUM:
	PUSH BP
	MOV BP, SP
	MOV CX, 4(BP)
	MOV DX, CX 
	MOV BX, 6(BP)
	MOV SI, 0
	MOV AX, 0
	1:
		ADD AX, (BX)(SI)
		ADD SI, 2
	LOOP 1b
	MOV SP, BP
	POP BP
	RET

.SECT .DATA

vec: .WORD  1, 2, 3, 4, 5
n  : .WORD  3 
end: .SPACE 1
format: .ASCII "\nLa somma di %d elementi del vettore e' %d.\n"

.SECT .BSS