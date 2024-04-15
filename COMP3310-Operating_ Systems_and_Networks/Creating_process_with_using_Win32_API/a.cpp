#include <windows.h>
#include <stdio.h>
#include <tchar.h>

int main()
{
FILE *fp;
fp = fopen("Test.txt", "w");
for(int i=0;i<10;i++){
	fprintf(fp, "%s\n", "Emre utkan");
}
fclose(fp);
system("pause");
return 0;
}

