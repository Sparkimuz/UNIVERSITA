! SUM(a, b, c) con subroutine.

_EXIT   = 1
_PRINTF = 127

.SECT .TEXT

main:

   MOV  SP, BP
   PUSH (c)
   PUSH (b)
   PUSH (a)
   CALL SUM

   MOV  SP, BP
   PUSH AX
   PUSH format
   PUSH _PRINTF
   SYS
   MOV  SP, BP
   PUSH 0   
   PUSH _EXIT
   SYS
   MOV  SP, BP

SUM:
   PUSH BP
   MOV  BP, SP
   MOV AX, 4(BP)
   MOV BX, 6(BP)
   MOV DX, 8(BP)
   ADD AX, BX
   ADD AX, DX
   MOV SP, BP
   POP BP
   RET

.SECT .DATA

a:     .WORD   2
b:     .WORD   0
c:     .WORD  -1
format: .ASCII "\n%d\n"

.SECT .BSS