/* front.c - a lexical analyzer system for simple
arithmetic expressions */
#include <ctype.h>
#include <stdio.h>

/* Global declarations */
/* Variables */
int charClass;
int prevClass;
char lexeme[100];
char nextChar;
char insideComment;
int prevCommentCount = -1;
int commentCount;
int lexLen;
int token;
int nextToken;
// the goal is to look up and compare to see if the token that comes after will be a '*'
int prevToken = 0;
FILE *in_fp, *fopen();

/* Function declarations */
void addChar();
void getChar();
void getNonBlank();
int lex();

/* Character classes */
#define SPECIAL 0
#define UNKNOWN 99

/* Token codes */
#define OTHER 11
#define SLASH_CHAR 12
#define ASTERISK_CHAR 13

/******************************************************/
/* main driver */
int main(int argc, char const *argv[]) {
    if (argc < 2) return 1;
    /* Open the input data file and process its contents */
    if ((in_fp = fopen(argv[1], "r")) == NULL)
        fprintf(stderr, "ERROR - cannot open %s \n", argv[1]);
    else {
        getChar();
        do {
            lex();
        } while (nextToken != EOF);
    }
    puts("");
}
/*****************************************************/

/* lookup - a function to lookup operators and parentheses
and return the token */
int lookup(char ch) {
    prevToken = nextToken;
    switch (ch) {
    case '/':
        addChar();
        nextToken = SLASH_CHAR;
        break;
    case '*':
        addChar();
        nextToken = ASTERISK_CHAR;
        break;
    default:
        addChar();
        nextToken = OTHER;
        break;
    }
    return nextToken;
}

/*****************************************************/
/* addChar - a function to add nextChar to lexeme */
void addChar() {
    if (lexLen <= 98) {
        lexeme[lexLen++] = nextChar;
        lexeme[lexLen] = 0;
    } else
        fprintf(stderr, "Error - lexeme is too long \n");
}

/*****************************************************/

/* getChar - a function to get the next character of
input and determine its character class */
void getChar() {
    if ((nextChar = getc(in_fp)) != EOF) {
        if (nextChar == '/' || nextChar == '*')
            charClass = SPECIAL;
        else
            charClass = UNKNOWN;
    } else
        charClass = EOF;
}

/*****************************************************/
/* lex - a simple lexical analyzer for arithmetic
expressions */
int lex() {
    fprintf(stderr, "--------\n");
    lexLen = 0;
    switch (charClass) {
    /* Parse identifiers */
    case SPECIAL:
        lookup(nextChar);
        getChar();
        if (prevToken == SLASH_CHAR && nextToken == ASTERISK_CHAR) {
            /* This indicates the comment block is begin */
            prevToken = nextToken;
            nextToken = OTHER;
            fprintf(stderr, "Comment detected! \n");
            insideComment = 1;
            commentCount++;
        } else if (prevToken == ASTERISK_CHAR && nextToken == SLASH_CHAR) {
            /* This indicates the comment bloked is end */
            fprintf(stderr, "End of Comment detected! \n");
            insideComment = 0;
            prevToken = nextToken;
            nextToken = OTHER;
        }
        break;
    /* slash and asterisk */
    case UNKNOWN:
        while (charClass == UNKNOWN) {
            lookup(nextChar);
            prevClass = charClass;
            getChar();
        }
        break;
    /* EOF */
    case EOF:
        nextToken = EOF;
        lexeme[0] = 'E';
        lexeme[1] = 'O';
        lexeme[2] = 'F';
        lexeme[3] = 0;
        break;
    } /* End of switch */
    if (insideComment) {
        /* print the line header */
        if (prevCommentCount != commentCount) {
            printf("\nComment %d: ", commentCount);
            prevCommentCount = commentCount;
        }
        for (int i = 0; i < lexLen; i++) {
            putchar(lexeme[i]);
        }
    }
    fprintf(stderr, "Nextchar: '%c', PrevToken: %d, NextToken: %d\n", nextChar, prevToken, nextToken);
    fprintf(stderr, "Next token is: %d, Next lexeme is \"%s\"\n",
           nextToken, lexeme);
    prevToken = nextToken;
    return nextToken;
} /* End of function lex */