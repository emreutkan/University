%include "asm_io.inc"

segment .data
    msg     db "Enter an integer: ", 0
    minMsg  db "Min: ", 0

segment .bss
    input   resd 1
    min_val resd 1

segment .text
    global  _asm_main
_asm_main:
    enter   0,0
    pusha
    mov     dword [min_val], 0x7FFFFFFF
read_loop:
    mov     eax, msg
    call    print_string
    call    read_int
    mov     [input], eax
    cmp     eax, 0
    je      finish
    cmp     eax, [min_val]
    jge     read_loop
    mov     [min_val], eax
    jmp     read_loop
finish:
    mov     eax, minMsg
    call    print_string
    mov     eax, [min_val]
    call    print_int
    call    print_nl
end_program:
    popa
    leave
    ret