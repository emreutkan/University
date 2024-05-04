%include "asm_io.inc"

segment .data

segment .bss

segment .text
    global  _asm_main
_asm_main:
    enter   0,0
    pusha
    mov     ecx, 0  
       
loop_start:
    cmp     ecx, 5
    jge     loop_end        
    cmp     ecx, 3          
    jg      increment_loop  
    mov     eax, ecx
    call    print_int  
     
increment_loop:
    inc     ecx             
    jmp     loop_start

loop_end:
    popa
    leave
    ret
