! MAX(x, y, z) = AX con procedura.

_EXIT = 1
_PRINTF = 127

.SECT .TEXT
   main:
      MOV  SP, BP
      PUSH (z)
      PUSH (y)
      PUSH (x)
      CALL max
      MOV  SP, BP
      PUSH AX
      PUSH format
      PUSH _PRINTF
      SYS
      MOV  SP,BP
      PUSH 0
      PUSH _EXIT
      SYS

   max: 
      PUSH BP
      MOV  BP, SP
      MOV  BX, 4(BP)
      MOV  DX, 6(BP)
      CMP  BX, DX
      JGE  1f
      MOV  AX, DX
      JMP  2f
      1:   MOV AX, BX
      2:   MOV BX, 8(BP)
      MOV  DX, AX
      CMP  BX, DX
      JGE  3f
      MOV  AX, DX
      JMP  4f
      3:   MOV AX, BX
      4:   MOV SP, BP
      POP  BP
      RET

.SECT .DATA
   x:      .WORD  1000
   y:      .WORD  10000
   z:      .WORD  100
   format: .ASCII "\n%d\n"

.SECT .BSS