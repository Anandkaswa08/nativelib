#include <string.h>
#include <jni.h>
#include <ctype.h>



JNIEXPORT int hideandshowtwo(char *txt, char buffer[3000]) {
    const unsigned char
            encvalues[8] = { 193, 127, 143, 121, 167, 179, 187, 191 };
    char ch;
    const char key = 'a';
    const int key1 = 0x2;
    int max = strlen(txt);
    int i;
    int eindex = 0;
    for (i = 0; i < max; i++) {
        ch = *txt++;
        if (ch)
            *buffer++ = ch ^ key1;
        else
            *buffer = '\0';
        eindex %= 8;
    }
    return max;
}


JNIEXPORT int hideandshow14(char *txt, char buffer[3000]) {
    const unsigned char
            encvalues[8] = { 193, 127, 143, 121, 167, 179, 187, 191 };
    char ch;
    const char key = 'a';
    const int key1 = 0x14;
    int max = strlen(txt);
    int i;
    int eindex = 0;
    for (i = 0; i < max; i++) {
        ch = *txt++;
        if (ch)
            *buffer++ = ch ^ key1;
        else
            *buffer = '\0';
        eindex %= 8;
    }
    return max;
}




JNIEXPORT jstring JNICALL Java_com_createlibrary_nativelib_NativeLib_getStringSNAMEFORELE
        (JNIEnv * env, jobject obj)
{
    char * txt = "Uzuzp4Guz~um4_ugcu";

    char buffer[3000] = { '\0' };
    int maxlen = hideandshow14(txt, buffer);
    return (*env)->NewStringUTF(env,buffer);
}

