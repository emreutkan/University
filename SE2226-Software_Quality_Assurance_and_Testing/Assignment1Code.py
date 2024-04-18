def grayCodeBinary(n):
    if n <= 0: 
        return
    elif n==1:
        return ["0","1"]
    elif n<32:
        x = grayCodeBinary(n-1) # get the n-1 list as X
        y = reversed(x) # switch the order of n-1 and call it Y
        final = []
        for i in x:
            final.append("0" + i) # add 0 to front as in binary to X
        for i in y:
            final.append("1" + i) # add 1 to front as in binary to Y
        return final # final list is [x,y]
    else:
        return
print("gray code in binary : ", grayCodeBinary(3))
#######################################################################################################
def grayCodeInteger(n):
    if not isinstance(n, int):
        return "!given input is not a integer"
    elif n <= 0: 
        return
    elif n==1:
        return [0, 1]
    elif n <= 32:
        x = grayCodeInteger(n-1)
        y = reversed(x)
        final = []
        for i in x:
            final.append(i)
        for i in y:
            final.append(i + 2**(n-1))
        return final
    else:
        return
print("gray code : ", grayCodeInteger(3))
