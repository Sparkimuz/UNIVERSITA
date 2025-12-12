! MAX(x, y, w, z) = AX con procedura.

_EXIT = 1
_PRINTF = 127

.SECT .TEXT
   MAIN:
      MOV  SP, BP
      PUSH (z)
      PUSH (w)
      PUSH (y)
      PUSH (x)
      CALL MAX
      MOV  SP, BP
      PUSH AX  ! MAX(x, y, w, z)
      PUSH (z)
      PUSH (w)
      PUSH (y)
      PUSH (x)
      PUSH format
      PUSH _PRINTF
      SYS
      MOV  SP,BP
      PUSH 0
      PUSH _EXIT
      SYS

   MAX: 
      PUSH BP
      MOV  BP, SP
      MOV  BX, 4(BP)       ! x
      MOV  DX, 6(BP)       ! y
      CMP  BX, DX
      JGE  1f
      MOV  AX, DX
      JMP  2f
      1:   MOV AX, BX
      2:   MOV BX, 8(BP)   ! w
      MOV  DX, AX
      CMP  BX, DX
      JGE  3f
      MOV  AX, DX
      JMP  4f
      3:   MOV AX, BX
      4:   MOV BX, 10(BP)  ! z
      MOV  DX, AX
      CMP  BX, DX
      JGE  5f
      MOV  AX, DX
      JMP  6f
      5:   MOV AX, BX
      6:   MOV SP, BP
      POP  BP
      RET

.SECT .DATA
   x:      .WORD  1
   y:      .WORD  -1
   w:      .WORD  0
   z:      .WORD  2
   format: .ASCII "\n MAX(%d, %d, %d, %d) = %d.\n"

.SECT .BSS