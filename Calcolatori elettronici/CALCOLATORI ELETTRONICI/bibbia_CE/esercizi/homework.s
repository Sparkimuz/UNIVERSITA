_EXIT = 1
_PRINTF = 127

.SECT .TEXT
start:
	MOV SP,BP
	PUSH s
	CALL LUN

	MOV DX,AX
	MOV SP,BP		!10
	PUSH AX
	PUSH out1
	PUSH _PRINTF
	SYS

	MOV SP,BP
	PUSH s
	PUSH (x)
	CALL OCC		!20

	MOV SP,BP
	PUSH AX
	PUSH (x)
	PUSH out2
	PUSH _PRINTF
	SYS

	MOV SP,BP
	PUSH 0
	PUSH _EXIT		!30
	SYS

LUN:
	PUSH BP				
	MOV BP,SP

	MOV AX,0
	MOV SI,0
	MOV BX,4(BP)
1:				!40
	CMPB (BX)(SI),0
	JE 2f
	INC AX
	INC SI
	JMP 1b
2: 		
	MOV SP,BP
	POP BP 
	RET

OCC:				!51
	PUSH BP
	MOV BP,SP
	
	MOV BX,6(BP)			!Indirizzo stringa
	MOV CX,DX			!Lunghezza
	MOV DX,0			
	MOVB DL,4(BP)			!Carattere da confrontare
	MOV SI,0			!Contatore per scandire la stringa
	MOV AX,0
5:	
	CMPB (BX)(SI),0		!61	!Controllo se sono arrivato a fine stringa
	JE fine
	CMPB (BX)(SI),DL
	JNE 2f
	INC AX

2:	
	ADD SI,2
	LOOP 5b				!Sara sempre eseguito
fine:				!70
	MOV SP,BP
	POP BP
	RET

.SECT .DATA
s: .ASCIZ "mamma"
x: .ASCIZ "m"
out1: .ASCIZ "Lunghezza stringa %d \n"
out2: .ASCIZ "Il carattere %c si ripete %d volte"
.SECT .BSS