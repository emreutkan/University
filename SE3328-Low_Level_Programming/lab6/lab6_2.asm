%include "asm_io.inc"

section .data
    prompt db "Enter an integer: ", 0
    div2_msg db "The number of integers divisible by 2 is ", 0
    div3_msg db "The number of integers divisible by 3 is ", 0
    div5_msg db "The number of integers divisible by 5 is ", 0
    count2 dd 0
    count3 dd 0 
    count5 dd 0  

section .bss
    input resd 1

section .text
global _asm_main
_asm_main:
    enter 0, 0
    pusha
prompt_loop:
    mov eax, prompt
    call print_string

    call read_int
    cmp eax, 0
    jge continue_loop

    jmp end_of_loop

continue_loop:
    mov ebx, eax

    ; Check if divisible by 2
    mov eax, ebx
    test eax, 1           ; the least significant bit to see if it 0
    jnz not_divisible_by_2
    inc dword [count2]

not_divisible_by_2:

    ; Check if divisible by 3
mov eax, ebx
mov ecx, 3
xor edx, edx
div ecx
test edx, edx
je divisible_by_3
jmp not_divisible_by_3


divisible_by_3:
    inc dword [count3]

not_divisible_by_3:

    ; Check if divisible by 5
mov eax, ebx
mov ecx, 5
xor edx, edx
div ecx
test edx, edx
je divisible_by_5
jmp not_divisible_by_5


divisible_by_5:
    inc dword [count5]

not_divisible_by_5:
    jmp end_of_iteration

end_of_iteration:
    jmp prompt_loop

end_of_loop:
    mov eax, div2_msg
    call print_string
    mov eax, dword [count2]
    call print_int
    call print_nl

    mov eax, div3_msg
    call print_string
    mov eax, dword [count3]
    call print_int
    call print_nl

    mov eax, div5_msg
    call print_string
    mov eax, dword [count5]
    call print_int
    call print_nl

    popa
    leave
    ret
