%include "asm_io.inc"

segment .data

prompt db "Enter a 5-character string: ", 0
outmsg1 db "String #1: ", 0
outmsg2 db "String #2: ", 0

segment .bss

input resb 6 ; reserve 6 bytes for input string (5 characters + 1 null byte)

segment .text
global _asm_main
_asm_main:
enter 0,0 ; setup routine
pusha

; print prompt
mov eax, prompt
call print_string

; read 5 characters
mov ecx, 5
read_loop:
call read_char
mov [input + ecx - 1], al
loop read_loop

; print out string #1 (reversed)
mov eax, outmsg1
call print_string
mov eax, input
call print_string
call print_nl

; print out string #2 (ASCII code decremented by 32)
mov eax, outmsg2
call print_string
mov ecx, 5
print_loop2:
mov al, [input + ecx - 1]
sub al, 32
call print_char
loop print_loop2

; print newline
call print_nl

popa
mov eax, 0 ; return back to C
leave
ret